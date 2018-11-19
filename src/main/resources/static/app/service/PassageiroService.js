class PassageiroService {
    
    constructor() {
        this.http = new HttpService();
    }
    buscaPassageiros(empresaId) {
        let url = '/passageiros?empresaId='+empresaId;
        return new Promise((resolve, reject) => {
            this.http.get(url).then(data => {
                resolve(data);
            }).catch(error => {
                reject(error);
            })
        });
    }
    savePassageiro(data) {
        let url = '/passageiros';

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
    editaPassageiro(data,passageiroId) {
        let url = '/editPassageiro?passageiroId='+passageiroId;

        return new Promise((resolve, reject) => {
            this.http.post(url,data).then(data => {
                resolve(data);
            }).catch(error => {
                reject(error);
            })
        });
    }
    deletePassageiro(passageiroId,viajemId){
        let url = '/deletePassageiros?passageiroId='+passageiroId+'&viajemId='+viajemId;
        return new Promise((resolve, reject) => {
            this.http.post(url).then(data => {
                data.json().then(function (data) {
                    resolve(data);
                });
            }).catch(error => {
                reject(error);
            })
        });
    }
}