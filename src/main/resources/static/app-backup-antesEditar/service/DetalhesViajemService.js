class DetalhesViajemService {

    constructor() {
        this.http = new HttpService();
    }
    buscaDetalhesViajem(data) {
        let url = '/detalhesViajem';

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
    saveCusto(data) {
        let url = '/custoViajem';

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
    deleteCusto(data) {
        let url = '/deleteCustoViajem?custoId='+data;

        return new Promise((resolve, reject) => {
            this.http.post(url).then(data => {
                resolve(data);
            }).catch(error => {
                reject(error);
            })
        });
    }

    editCusto(data,custoId) {
        let url = '/editCustoViajem?custoId='+custoId;

        return new Promise((resolve, reject) => {
            this.http.post(url,data).then(data => {
                resolve(data);
            }).catch(error => {
                reject(error);
            })
        });
    }
}