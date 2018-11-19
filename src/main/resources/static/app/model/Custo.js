class Custo {
    constructor(descricaoCusto, valorCusto,viajemId) {
        this.descricao = descricaoCusto;
        this.valor = valorCusto;
        this.viajemId = viajemId;
        Object.freeze(this);
    }

}