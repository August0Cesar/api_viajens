class HttpService {
    get(url, data) {
        return new Promise((resolve, reject) => {
            fetch(url, {
                method: 'GET',
                headers: {
                    // 'Accept': 'application/json',
                    // 'Content-Type': 'application/json',
                    // 'Access-Control-Allow-Origin': 'http://Vps11062.publiccloud.com.br',
                    // 'Access-Control-Allow-Credentials': 'true',
                    'Authorization': localStorage.getItem('token')
                },
                body: data
            })
                .then(function (response) {
                    resolve(response.json());
                })
                .catch(function (err) {
                    console.error('Falha ao autenticar usuario', err);
                    reject(err);
                });
        });
    }

    post(url, data) {

        return new Promise((resolve, reject) => {
            fetch(url, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': 'http://vps11062.publiccloud.com.br',
                    'Access-Control-Allow-Credentials': 'true',
                    'Authorization': localStorage.getItem('token')
                },
                body: data
            })
                .then(function (response) {
                    resolve(response);
                })
                .catch(function (err) {
                    console.error('Falha ao autenticar usuario', err);
                    reject(err);
                });
        });
    }
    postLogin(url, data) {

        return new Promise((resolve, reject) => {
            fetch(url, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    //'Access-Control-Allow-Origin': 'http://vps11062.publiccloud.com.br'
                },
                body: data
            })
                .then(function (response) {
                    resolve(response);
                })
                .catch(function (err) {
                    console.error('Falha ao autenticar usuario', err);
                    reject(err);
                });
        });
    }
}