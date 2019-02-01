class ViajemService {
    
    constructor() {
        this.http = new HttpService();
    }
    buscaViajens(tipo) {
        let url = '/viajens?tipoViajem='+tipo;

        return new Promise((resolve, reject) => {
            this.http.get(url).then(data => {
                resolve(data);
            }).catch(error => {
                reject(error);
            })
        });
    }
    saveViajens(data) {
        let url = '/viajens';

        return new Promise((resolve, reject) => {
            this.http.post(url,data).then(data => {
                data.json().then(function (data) {
                    resolve(data);
                });
            }).catch(error => {
                reject(error);
            })
        });
    }
}