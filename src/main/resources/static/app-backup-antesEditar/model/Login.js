class Login {
    constructor(usuario,senha) {
        this.username = usuario;
        this.password = senha;
    }

    get userName() {
        return this.username;
    }

    get userPassword() {
        return this.password;
    }
}

