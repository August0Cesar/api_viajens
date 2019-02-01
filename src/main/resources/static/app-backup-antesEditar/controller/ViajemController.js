class ViajemController {
    //http://www.fabiobmed.com.br/excelente-codigo-para-mascara-e-validacao-de-cnpj-cpf-cep-data-e-telefone/
    constructor() {
        let $ = document.querySelector.bind(document);

        this.nomeEmpresa = $('#nomeEmpresa');


        //fazendo bind dos inputs do formulario Viajens
        this.inputNomeViajem = $('#nomeViajem');
        this.inputValorPassagem = $('#valorPassagem');
        this.inputQtdPassageiros = $('#qtdPassageiros');
        this.inputDataInicio = $('#dataInicio');
        this.inputDataFinal = $('#dataFinal');
        this.inputDescricaoViajem = $('#descricaoViajem');
        this.tipoViajem = $('#tipoViajem');

        //fazendo bind dos inputs do formulario Passageiros
        this._inputIdPassageiro = $('#idPassageiro');
        this._inputNomePassageiro = $('#nomePassageiro');
        this._inputEmail = $('#emailPassageiro');
        this._inputTelefone = $('#telefonePassageiro');
        this._inputWhatsApp = $('#whatsappPassageiro');
        this._inputRua = $('#ruaPassageiro');
        this._inputNumeroRua = $('#numeroRuaPassageiro');
        this._inputBairro = $('#bairroPassageiro');
        this._inputCidade = $('#cidadePassageiro');
        this._inputDataNascimento = $('#dataNascimentoPassageiro');
        this._inputCpf = $('#cpfPassageiro');
        this._inputRg = $('#rgPassageiro');
        this._inputViajemId = $('#viajemPassageiro');
        this._inputEstado = $('#estadoPassageiro');

        //fazendo bind dos inputs do filtro passageiro
        this._inputNnomePassageiroFiltro = $('#nomePassageiroFiltro');
        this._inputFiltroStatusPassageiro = $('#filtroStatusPassageiro');
        this._inputFiltroViajens = $('#filtroViajens');

        //remove
        localStorage.removeItem('viajemAtiva');
        localStorage.removeItem('passageiroAtivo');
        localStorage.removeItem('dados');
        localStorage.removeItem('dadosPagamento');

        this._listaViajens = new ListaViajem();
        this._empresaViewEmpresa = new EmpresaView($('#nomeEmpresa'));
        this._viajemView = new ViajemView($('#container-viajens'), $('#painel-passageiros'), $('#painel-perfil'));
        this._passageiroService = new PassageiroService();
        this._viajemService = new ViajemService();
        this._tipoViajens = [];
        this._viajemService.buscaViajens('onibus').then(data => {
            console.log(data);
            localStorage.setItem('empresa', data.nomeEmpresa);
            localStorage.setItem('empresaId', data.empresaId);

            this._listaViajens = data.viajens;
            this.nomeEmpresa.value = data.nomeEmpresa;
            this._viajemView.atualizaViajens(this._listaViajens);
            this._viajemView.carregaFiltroPassageiros(data);
            this._empresaViewEmpresa.atualizaEmpresa();
            this._viajemView.carregaModalNovaViajem(data.tipoViajens);
            this._viajemView.carregaModalNovoPassageiro(this._listaViajens);
        }).catch(error => {
            console.log(error);
        });
    }
    buscaViajens(tipoViajem) {
        this._listaViajens = [];
        this._viajemService.buscaViajens(tipoViajem).then(data => {
            this._listaViajens = data.viajens;
            this._viajemView.atualizaViajens(this._listaViajens);
        }).catch(error => {
            alert(error);
            console.log(error);
        });
    }
    cadastraViajem(event) {
        event.preventDefault();

        let viajem = new Viajem(this.inputNomeViajem.value, this.inputValorPassagem.value, this.inputDataInicio.value, this.inputDataFinal.value,
            this.inputDescricaoViajem.value, this.inputQtdPassageiros.value, this.tipoViajem.value, localStorage.getItem('empresaId')
        );

        let dados = JSON.stringify(viajem);
        $('#modalViajem').modal('hide');
        //let retorno =
        this._viajemService.saveViajens(dados)
            .then(data => {
                this._viajemView.atualizaViajens(data);

            }).catch(error => {
                console.log(error);
                alert('Erro ao cadastrar viajem.');

            });
    }
    buscaPassageiros() {
        let empresaId = localStorage.getItem('empresaId');
        this._passageiroService.buscaPassageiros(empresaId)
            .then(data => {
                this._viajemView.atualizaPassageiros(data);
                localStorage.setItem('dadosPassageiros', JSON.stringify(data));
            }).catch(error => {
                console.log(error);
            });
    }
    cadastroPassageiro(event) {
        event.preventDefault();

        
        $('#modalPassageiro').modal('hide');
        console.log();
        if(this._inputIdPassageiro.value == ''){
            let passageiro = new Passageiro(this._inputNomePassageiro.value, this._inputEmail.value, this._inputTelefone.value, this._inputWhatsApp.value,
                this._inputRua.value, this._inputNumeroRua.value, this._inputBairro.value, this._inputCidade.value, this._inputDataNascimento.value,
                this._inputRg.value, this._inputCpf.value, this._inputViajemId.value, this._inputEstado.value
            );
            console.log('cadastrar passageiro');
            this._passageiroService.savePassageiro(JSON.stringify(passageiro))
                .then(data => {
                    console.log(data);
                    alert('Passageiro Cadastrado com sucesso.');
                    this.limpaFormulario();
                    this.buscaPassageiros();
                }).catch(error => {
                    alert('Erro ao cadastrar passageiro.Verifique se tem algum campo em banco.');
                    console.log(error);
                });
        }else{
            let passageiro = new Passageiro(this._inputNomePassageiro.value, this._inputEmail.value, this._inputTelefone.value, this._inputWhatsApp.value,
                this._inputRua.value, this._inputNumeroRua.value, this._inputBairro.value, this._inputCidade.value, this._inputDataNascimento.value,
                this._inputRg.value, this._inputCpf.value, null, this._inputEstado.value
            );
            console.log('editar passageiro');
            this._passageiroService.editaPassageiro(JSON.stringify(passageiro),this._inputIdPassageiro.value)
                .then(data => {
                    alert('Passageiro Editado com sucesso.');
                    this.limpaFormulario();
                    this.buscaPassageiros();
                }).catch(error => {
                    alert('Erro ao cadastrar passageiro.Verifique se tem algum campo em banco.');
                    console.log(error);
                });
        }
        
    }
    excluiPassageiro(event, passageiroId, viajemId) {
        event.preventDefault();
        this._passageiroService.deletePassageiro(passageiroId, viajemId)
            .then(data => {
                this.buscaPassageiros();
            })
            .catch(error => {
                console.log(error);
                alert('Erro ao tentar excluir passageiro');
            });
    }

    detalheViajens(event, data) {
        event.preventDefault();
        localStorage.setItem('viajemAtiva', data);
        window.location.replace("/detalhesViajem");
    }
    filtraPassageiros(event) {
        event.preventDefault();
        let listaPassageiros = JSON.parse(localStorage.getItem('dadosPassageiros'));

        if (this._inputFiltroStatusPassageiro.value == 'Escolha Filtro'
            && this._inputFiltroViajens.value == 'Escolha Filtro') {

            this._viajemView.atualizaPassageiros(listaPassageiros);
        } else {
            let novaListaPassageiro = listaPassageiros.filter(element => {
                if (this._inputFiltroStatusPassageiro.value == 'Escolha Filtro') {
                    return element.viajem.viajemId == this._inputFiltroViajens.value;
                } else if (this._inputFiltroViajens.value == 'Escolha Filtro') {
                    return element.statusPagamento == this._inputFiltroStatusPassageiro.value;
                } else {
                    return element.statusPagamento == this._inputFiltroStatusPassageiro.value && element.viajem.viajemId == this._inputFiltroViajens.value;
                }

            });
            this._viajemView.atualizaPassageiros(novaListaPassageiro);
        }
    }
    exibePerfilPassageiro(event, passageiroid) {
        event.preventDefault();
        let listaPassageiros = JSON.parse(localStorage.getItem('dadosPassageiros'));
        listaPassageiros.forEach(element => {
            if (element.id == passageiroid) {
                this._viajemView.atualizaPerfilPassageiro(element);
            }
        });
    }
    editaPassageiro(event, passageiroId) {
        event.preventDefault();

        let listaPassageiros = JSON.parse(localStorage.getItem('dadosPassageiros'));
        console.log(passageiroId);
        listaPassageiros.forEach(element => {
            console.log(element.id);
            if (element.id == passageiroId) {
                this._inputIdPassageiro.value = element.id;
                this._inputNomePassageiro.value = element.nomePassageiro;
                this._inputEmail.value = element.email;
                this._inputTelefone.value = element.telefone;
                this._inputWhatsApp.value = element.whatsapp;
                this._inputRua.value = element.endereco.rua;
                //this._inputNumeroRua = element.endereco.rua;
                this._inputBairro.value = element.endereco.bairro;
                this._inputCidade.value = element.endereco.cidade;
                this._inputDataNascimento.value = element.dataNascimento;
                this._inputCpf.value = element.cpf;
                this._inputRg.value = element.rg;
                //this._inputViajemId.value = element.viajem.viajemId;
                this._inputEstado.value = element.endereco.estado;
            }
        });

        $('#modalPassageiro').modal('show');

    }
    openDetalhesPagamento(event, passageiroId, viajemId) {
        event.preventDefault();
        localStorage.setItem('viajemAtiva', viajemId);
        localStorage.setItem('passageiroAtivo', passageiroId);
        window.location.replace("/historicoPagamentos");
    }
    limpaFormulario() {
        this._inputIdPassageiro.value = '';
        this._inputIdPassageiro.value = '';
        this._inputNomePassageiro.value = '';
        this._inputEmail.value = '';
        this._inputTelefone.value = '';
        this._inputWhatsApp.value = '';
        this._inputRua.value = '';
        this._inputNumeroRua.value = '';
        this._inputBairro.value = '';
        this._inputCidade.value = '';
        this._inputDataNascimento.value = '';
        this._inputCpf.value = '';
        this._inputRg.value = '';
        this._inputViajemId.value = '';
        this._inputEstado.value = '';
    }
    /******************/
    validateTelefone(tel) {
        /*  exp = /\(\d{2}\)\ \d{4}\-\d{4}/
         if (!exp.test(tel.value))
             alert('Numero de Telefone Invalido!'); */
    }

    MascaraTelefone(event) {
        //console.log(event);
        /* if (mascaraInteiro(event) == false) {
            event.returnValue = false;
        }
        return MascUtiuls.formataCampo(tel, '(00) 0000-0000', event); */
    }
    mascaraInteiro(event) {
        console.log(event);
        if (event.keyCode < 48 || event.keyCode > 57) {
            //event.returnValue = false;
            return false;
        }
        return true;
    }
}