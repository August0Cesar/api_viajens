class Passageiro {
    constructor(nomePassageiro, email, telefone, whatsApp, rua, numeroRua, bairro, cidade, dataNascimento,
        rg, cpf,viajemId,estado,condicaoEspecial,condicoesEspeciais,valorViajem) {
        this.nomePassageiro = nomePassageiro;
        this.email = email;
        this.telefone = telefone
        this.whatsApp = whatsApp;
        this.rua = rua;
        this.numeroRua = numeroRua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.dataNascimento = DateHelper.textoParaData(dataNascimento).getTime();
        this.cpf = cpf;
        this.rg = rg;
        this.viajemId = viajemId;
        this.empresaId = localStorage.getItem('empresaId');
        this.estado = estado;
        
        if(!condicaoEspecial){
            this.condicaoEspecial = false;
            this.condicoesEspeciais = '';
            this.valorViajem = 0;
        }else{
            this.condicaoEspecial = condicaoEspecial;
            if(condicoesEspeciais != 'Escolha a Condição Especial'){
                this.condicoesEspeciais = condicoesEspeciais;
            }else{
                this.condicoesEspeciais = 1;
            }
            this.valorViajem = valorViajem;        
        }
        
        Object.freeze(this);
    }

}