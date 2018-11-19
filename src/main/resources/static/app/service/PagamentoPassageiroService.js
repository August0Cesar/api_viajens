class PagamentoPassageiroService {
    
    constructor() {
        this.http = new HttpService();
    }
    buscaPagamentoPassageiro(data) {
        let url = '/pagamentoPassageiros';

        return new Promise((resolve, reject) => {
            this.http.post(url, data).then(data => {
                data.json().then(function (data) {
                    resolve(data);
                });
            }).catch(error => {
                reject(error);
            })
        });
    }
    savePagamento(data) {
        let url = '/savePagamentoPassageiro';

        return new Promise((resolve, reject) => {
            this.http.post(url,data).then(data => {
                resolve(data);
            }).catch(error => {
                reject(error);
            })
        });
    }
    deletePagamento(pagamentoId){
        let url = '/deletePagamentoPassageiro?pagamentoId='+pagamentoId;
        return new Promise((resolve, reject) => {
            this.http.post(url).then(data => {
                resolve(data);
            }).catch(error => {
                reject(error);
            })
        });
    }
}