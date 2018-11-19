class LoginService {
    constructor() {
        this._http = new HttpService();
        this._url = '/login';
        //this._url = 'http://vps11062.publiccloud.com.br:8080/api-viajens/login';
    }
    fazLogin(jsonUser) {
        return new Promise((resolve, reject) => {
            this._http.post(this._url, jsonUser)
                .then(data => {
                    console.log(data);
                    if (data.status == 403) {
                        alert('Usuario ou senha errado.')
                    } else {
                        data.json().then(function (data) {
                            resolve(data);
                            localStorage.setItem('token', data.Authorization);
                            window.location.replace("/template");
                            //window.location.replace("template.html");
                        });
                    }
                })
                .catch(error => {
                    console.log('Error' + error);
                    reject(error);
                });
        });
    }
}   