class PagamentoPassageiroController {
    //http://www.fabiobmed.com.br/excelente-codigo-para-mascara-e-validacao-de-cnpj-cpf-cep-data-e-telefone/
    constructor() {
        let $ = document.querySelector.bind(document);

        this.nomeEmpresa = $('#nomeEmpresa');

        //fazendo bind dos inputs do formulario Custo
        this.inputPagamentoId = $('#pagamentoId');
        this._inputNumeroParcela = $('#numeroParcela');
        this._inputValorParcela = $('#valorParcela');
        this._inputDataPagamento = $('#dataPagamento');
        this._inputDataVencimento =  $('#dataVencimento');
        this._inputFormaPagamento = $('#formaPagamento');

        this._empresaViewEmpresa = new EmpresaView($('#nomeEmpresa'));

        this._pagamentoPassageiroView = new PagamentoPassageiroView($('#containerPagamentos'));

        this._pagamentoPassageiroService = new PagamentoPassageiroService();

        this._detalheRequest = new Object();

        this.buscaPagamentoPassageiro();
    }


    buscaPagamentoPassageiro() {
        this._detalheRequest.viajemId = localStorage.getItem('viajemAtiva');
        this._detalheRequest.passageiroId = localStorage.getItem('passageiroAtivo');
        this._pagamentoPassageiroService.buscaPagamentoPassageiro(JSON.stringify(this._detalheRequest))
            .then(data => {
                console.log(data);
                localStorage.setItem('dadosPagamentos', JSON.stringify(data));
                this._empresaViewEmpresa.atualizaEmpresa();
                this._pagamentoPassageiroView.inicializaContainer(data);
            }).catch(error => {
                console.log(error);
            });
    }

    cadastroEditPagamento(event) {
        event.preventDefault();
        let pagamentoId = this.inputPagamentoId.value;
        let viajemId = localStorage.getItem('viajemAtiva');
        let passageiroId = localStorage.getItem('passageiroAtivo');
        let pagamentoPassageiro = new PagamentoPassageiro(this._inputNumeroParcela.value, this._inputValorParcela.value, this._inputDataPagamento.value,
             this._inputDataVencimento.value,this._inputFormaPagamento.value, viajemId, passageiroId);
        $('#modalPagamento').modal('hide');
        if (pagamentoId == '') {
            console.log('cadastrar');
            console.log(JSON.stringify(pagamentoPassageiro));
            this._pagamentoPassageiroService.savePagamento(JSON.stringify(pagamentoPassageiro))
                .then(data => {
                    console.log(data);
                    this.buscaPagamentoPassageiro();
                })
                .catch(error => {
                    console.log(error);
                    alert('Erro ao tentar cadastrar novo custo.');
                });
        } else {
            console.log('editar' + custoId);
            console.log(JSON.stringify(pagamentoPassageiro));
            // this._detalhesViajemService.editCusto(JSON.stringify(custo), custoId)
            //     .then(data => {
            //         console.log(data);
            //         this.buscaDetalhesViajem();
            //     })
            //     .catch(error => {
            //         console.log(error);
            //         alert('Erro ao tentar cadastrar novo custo.');
            //     });
        }
        this.limpaFormularioCusto();
    }
    limpaFormularioCusto() {
        this.inputPagamentoId.value = '';
        this._inputNumeroParcela.value = '';
        this._inputValorParcela.value = '';
        this._inputDataPagamento.value = '';
        this._inputDataVencimento.value =  '';
        this._inputFormaPagamento.value = '';
    }

    excluiPagamento(event, pagamentoId) {
        event.preventDefault();
        this._pagamentoPassageiroService.deletePagamento(pagamentoId)
            .then(data => {
                this.buscaPagamentoPassageiro();
            })
            .catch(error => {
                console.log(error);
                alert('Erro ao tentar excluir passageiro');
            });
    }

    // excluiCusto(event, custoId) {
    //     event.preventDefault();
    //     this._detalhesViajemService.deleteCusto(custoId)
    //         .then(data => {
    //             this.buscaDetalhesViajem();
    //         })
    //         .catch(error => {
    //             console.log(error);
    //             alert('Erro ao tentar excluir custo');
    //         });
    // }

    // editCusto(event, custoId) {
    //     event.preventDefault();
    //     let dados = localStorage.getItem('dados');

    //     let custos = JSON.parse(dados);
    //     custos.custos.forEach(element => {
    //         if (custoId == element.id) {
    //             this._inputCustoId.value = element.id;
    //             this._inputDescricaoCusto.value = element.descricao;
    //             this._inputValorCusto.value = element.valor;
    //         }

    //     });
    //     $('#modalCusto').modal('show');
    // }

    // openDetalhesPagamento(event, data) {
    //     event.preventDefault();
    //     console.log(data);
    //     localStorage.setItem('passageiroAtivo', data);
    //     window.location.replace("historicoPagamentos.html");
    // }
}