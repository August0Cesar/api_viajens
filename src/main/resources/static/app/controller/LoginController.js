class LoginController {
    constructor() {
        let $ = document.querySelector.bind(document);
        //fazendo bind dos inputs do formulario
        this.username = $('#username');
        this.password = $('#password');

        this._loginService = new LoginService();
    }
    login(event) {
        event.preventDefault();
        if (this.login.value == '' | this.password.value == '') {
            alert('Preencha os campos para fazer Login no Sistema.');
        }else{
            let usuario = new Login(this.username.value, this.password.value);    
            let data = this._loginService.fazLogin(JSON.stringify(usuario));
            console.log(data);
        }
        
    }
}