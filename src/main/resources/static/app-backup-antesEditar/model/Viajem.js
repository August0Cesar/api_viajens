class Viajem {
    constructor(nomeViajem, valorViajem, dataInicio, dataFinal, descricao, qtdPassageiros, tipoViajem, empresaId) {
        this.nomeViajem = nomeViajem;
        this.valorViajem = valorViajem;
        this.custo = [];
        this.dataInicio = DateHelper.textoParaData(dataInicio).getTime();
        this.dataFinal = DateHelper.textoParaData(dataFinal).getTime();
        this.descricao = descricao;
        this.qtdPassageiros = qtdPassageiros;
        this.tipoViajem = tipoViajem;
        this.empresaId = empresaId;
        Object.freeze(this);
    }

}