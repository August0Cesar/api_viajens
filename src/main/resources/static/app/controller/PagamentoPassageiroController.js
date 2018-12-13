class PagamentoPassageiroController {
    //http://www.fabiobmed.com.br/excelente-codigo-para-mascara-e-validacao-de-cnpj-cpf-cep-data-e-telefone/
    constructor() {
        let $ = document.querySelector.bind(document);
        localStorage.removeItem('dadosPassageiros');
        // localStorage.removeItem('viajemAtiva');

        this.nomeEmpresa = $('#nomeEmpresa');

        //fazendo bind dos inputs do formulario Custo
        this._inputPagamentoId = $('#pagamentoId');
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
        let pagamentoId = this._inputPagamentoId.value;
        let viajemId = localStorage.getItem('viajemAtiva');
        let passageiroId = localStorage.getItem('passageiroAtivo');
        let pagamentoPassageiro = new PagamentoPassageiro(this._inputNumeroParcela.value, this._inputValorParcela.value, this._inputDataPagamento.value,
             this._inputDataVencimento.value,this._inputFormaPagamento.value, viajemId, passageiroId,this._inputPagamentoId.value);
        $('#modalPagamento').modal('hide');
        /*if (pagamentoId == '') {
            console.log('cadastrar');
            console.log(JSON.stringify(pagamentoPassageiro));*/
            this._pagamentoPassageiroService.savePagamento(JSON.stringify(pagamentoPassageiro))
                .then(data => {
                    console.log(data);
                    this.buscaPagamentoPassageiro();
                })
                .catch(error => {
                    console.log(error);
                    alert('Erro ao tentar cadastrar novo custo.');
                });
        /*} else {
            console.log('editar' + pagamentoId);
            console.log(JSON.stringify(pagamentoPassageiro));
            
        }*/
        this.limpaFormularioCusto();
    }
    limpaFormularioCusto() {
        this._inputPagamentoId.value = '';
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

    openEditPagamento(event, pagamentoId) {
        console.log('id pagamento: '+pagamentoId);
        event.preventDefault();
        let dadosPagamentos = localStorage.getItem('dadosPagamentos');

        let pagamentos = JSON.parse(dadosPagamentos);
        console.log(pagamentos);
        pagamentos.listaPagamentos.forEach(element => {
            if (pagamentoId == element.pagamentoId) {
                this._inputPagamentoId.value = pagamentoId;
                this._inputNumeroParcela.value = element.parcela;
                this._inputValorParcela.value = element.valor;
                this._inputDataPagamento.value = element.dataPagamento;
                this._inputDataVencimento.value =  element.dataVencimento;
                this._inputFormaPagamento.value = element.formaPagamento;
            }

        });
        $('#modalPagamento').modal('show');
    }
}