class Viajem {
    constructor(nomeViajem, valorViajem, dataInicio, dataFinal, descricao, qtdPassageiros, tipoViajem, empresaId,dias,jantar,
        almoco,cafeManha,hospedagem,urlHospedagem) {
        this.nomeViajem = nomeViajem;
        this.valorViajem = valorViajem;
        this.custo = [];
        this.dataInicio = DateHelper.textoParaData(dataInicio).getTime();
        this.dataFinal = DateHelper.textoParaData(dataFinal).getTime();
        this.descricao = descricao;
        this.qtdPassageiros = qtdPassageiros;
        this.tipoViajem = tipoViajem;
        this.empresaId = empresaId;
        this.dias = dias;
        this.jantar = jantar;
        this.almoco = almoco;
        this.cafeManha = cafeManha;
        this.local_hospedagem = hospedagem;
        this.urlHospedagem = urlHospedagem;
        Object.freeze(this);
    }

}