class ListaViajem {
   
    constructor() {
        let listaViajens = [
            {
                _nomeViajem: 'Excursão para Porto Seguro na Bahia', _valorViajem: 10.00, custo: [], _dataInicio: '15/10/2018 4:00',
                _dataFinal: '15/11/2018 18:00', _descricao: '2 quartos com almoço incluido', _qtdPassageiros: 45
            }
            // , {
            //     nomeViajem: 'Excursão para Porto de Galinha no Ceará', valorViajem: 10.00, custo: [], dataInicio: '15/10/2018 4:00',
            //     dataFinal: '15/11/2018 18:00', observacao: '2 quartos com almoço incluido', qtdPassageiros: 20
            // }
        ];
        this._viajens = listaViajens;
    }
    adicionaViajem(viajem){
        this._viajens.push(viajem);
    }
    get viajem(){
        return [].concat(this._viajens);
    }
}