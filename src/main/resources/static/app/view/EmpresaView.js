class EmpresaView {
    constructor(elemento,elementoPassageiros) {
        this._elemento = elemento;
    }
    
    _templateEmpresa() {
        let nomeEmpresa = localStorage.getItem('empresa');
        let templateEmpresa = `<h3 class="text-center">${nomeEmpresa}</h3>`;

        return templateEmpresa;
    }

    atualizaEmpresa() {
        this._elemento.innerHTML = this._templateEmpresa();
    }
    
}