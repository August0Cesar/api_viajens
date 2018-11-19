class PagamentoPassageiro {
    constructor(parcela, valorPagamento, dataPagamento, dataVencimento,formaPagamentoId, viajemId, passageiroId) {
        this.parcela = parcela;
        this.valor = valorPagamento;
        this.dataPagamento = dataPagamento == '' ? null : DateHelper.textoParaData(dataPagamento).getTime();
        this.dataVencimento = DateHelper.textoParaData(dataVencimento).getTime();
        this.formaPagamentoId = formaPagamentoId;
        this.viajemId = viajemId;
        this.passageiroId = passageiroId;
        Object.freeze(this);
    }

}