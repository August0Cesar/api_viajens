class ViajemView {
    constructor(elemento, elementoPassageiros, elementoPerfilPassageiro) {
        this._elemento = elemento;
        this._elementoPassageiros = elementoPassageiros;
        this._elementoPerfilPassageiro = elementoPerfilPassageiro;
    }
    _templateViajens(model) {
        let cardsViajens = '';

        if (model.length == 0) {
            cardsViajens = `
            <div class="col-sm-4 col-md-3">    
                <p>Nehuma Viajem no Momento.</p>
            </div>`;
            return cardsViajens;
        }
        model.forEach(element => {
            cardsViajens += `
                <div class="col-sm-4 col-md-3">
                    <div class="card" style="width: 17rem;height:400px">
                        <img class="card-img-top" src="https://images.unsplash.com/photo-1517303650219-83c8b1788c4c?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=bd4c162d27ea317ff8c67255e955e3c8&auto=format&fit=crop&w=2691&q=80"
                            alt="Card image cap">
                        <h4 class="card-title"><a href="detalhesViajem.html" onclick="viajemController.detalheViajens(event,${element.viajemId})"> ${element.nomeViajem} </a></h4>
                        <h5 class="card-text"><b>Custos </b> R$ ${element.totalCusto} </h5>
                        <p class="card-text"><b>Saída </b>${element.dataInicio}</p>
                        <p class="card-text"><b>Pago até o momento R$ ${element.valorPago}</b></p>
                        <div class="align-self-center">
                        <div class="circle-card">${element.totalPassageiro} | ${element.qtdPassageiros}</div>
                    </div>
                    </div>
                </div>`
        });
        return cardsViajens;
    }
    _templatePassageiros(model) {
        let cardsPassageiros = '';

        if (model.length == 0) {
            cardsPassageiros = `
            <div class="col-sm-4 col-md-3">    
                <p>Nehum Passageiro no Momento.</p>
            </div>`;
            return cardsPassageiros;
        }
        model.forEach(element => {
            cardsPassageiros += `
                <div class="cardd col-md-12">
                    <div class="row">
                        <div class="col-md-2  ">
                            <div class="profile-photo-small align-middle">
                                <img src="./assets/img/faces/default.png" alt="Circle Image" class="rounded-circle align-middle img-fluid float-left avatar-card">
                            </div>
                        </div>
                        <div class="col-md-8">
                            <h5 style="padding-top:0.5em;text-align: left;padding-bottom: 0;margin-bottom: 0">
                                <a href="#" style="color:black" onclick="viajemController.exibePerfilPassageiro(event,${element.id})">
                                    <b>${element.nomePassageiro}</b>
                                </a>
                            </h5>
                            <p style="text-align: left;">${element.viajem.nomeViajem}</p>
                            <hr>
                            <p style="text-align: left;padding-top: 0;margin-top: 0;" class="text-warning">
                                <b>${element.statusPagamento}</b>
                            </p>
                        </div>
                        <div class="col-md-2">  
                            <div class="p2" style="padding-top:4em">
                                <a href="historicoPagamentos.html" style="color:black" onclick="viajemController.openDetalhesPagamento(event,${element.id},${element.viajem.viajemId})">
                                    <i class="material-icons">format_list_bulleted</i>
                                </a>
                                <a href="#" style="color:black" onclick="viajemController.excluiPassageiro(event,${element.id},${element.viajem.viajemId})">
                                    <i class="material-icons">delete_forever</i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>`
        });
        return cardsPassageiros;
    }
    _templatePerfilPassageiro(model) {
        let cardPerfilPassageiros = `
            <div class="card-perfil">
                <a href="#pablo">
                <img src="./assets/img/faces/default.png" alt="Circle Image" class="img rounded-circle align-middle"
                    style="height: 250px;  width: 250px;">
                </a>
                <div class="card-body">
                    <h4 class="card-title">${model.nomePassageiro}</h4>
                    <h5 class=" text-center" style="padding-left:2em">${model.email}</h5>
                    <p class="card-description text-left" style="padding-left:2em">
                        <b>Telefone:</b> ${model.telefone} | <b>WhatsApp:</b> ${model.whatsapp}
                    </p>
                    <p class="card-description text-left" style="padding-left:2em">
                        <b>CPF:</b> ${model.cpf}
                    </p>
                    <p class="card-description text-left" style="padding-left:2em">
                        <b>RG:</b> ${model.rg}
                    </p>
                    <p class="card-description text-left" style="padding-left:2em">
                    <b>Endereço:</b> ${model.endereco.rua} - ${model.endereco.bairro} 
                    </p>
                    <p class="card-description text-left" style="padding-left:2em">
                        <b>${model.endereco.cidade} - ${model.endereco.estado}</b>
                    </p>
                    <a href="#" class="btn btn-danger btn-round" onclick="viajemController.editaPassageiro(event,${model.id})">
                        <i class="material-icons">edit</i> 
                        Editar Passageiro
                    </a>
                </div>
            </div>
        `;
        // <p class="card-description">
        //     <b>Já viajou ${model.viajens.length} vezes</b>
        // </p>

        return cardPerfilPassageiros;
    }
    _templateEmpresa() {
        let nomeEmpresa = localStorage.getItem('empresa');
        let templateEmpresa = `<h3 class="text-center">${nomeEmpresa}</h3>`;

        return templateEmpresa;
    }

    atualizaViajens(model) {
        this._elemento.innerHTML = this._templateViajens(model);
    }

    atualizaEmpresa(model) {
        this._elemento.innerHTML = this._templateEmpresa();
    }
    atualizaPassageiros(model) {
        console.log(model);
        let passageiro = model[0];
        this._elementoPassageiros.innerHTML = this._templatePassageiros(model);
        this.atualizaPerfilPassageiro(passageiro);

    }
    atualizaPerfilPassageiro(model) {
        if(model == null){
            this._elementoPerfilPassageiro.innerHTML = '';    
        }else{
            this._elementoPerfilPassageiro.innerHTML = this._templatePerfilPassageiro(model);
        }
    }
    carregaModalNovaViajem(model) {
        let select = document.getElementById('tipoViajem');
        let opcoes = '<option>Escolha Tipo Viajem</option>';
        model.forEach(element => {
            opcoes += '<option value="' + element.id + '">' + element.descricao + '</option>';
        });
        select.innerHTML = opcoes;
    }
    carregaModalNovoPassageiro(model) {
        let select = document.getElementById('viajemPassageiro');
        let opcoes = '<option>Escolha Viajem</option>';
        model.forEach(element => {
            opcoes += '<option value="' + element.viajemId + '">' + element.nomeViajem + '</option>';
        });
        select.innerHTML = opcoes;
    }
    carregaFiltroPassageiros(model) {
        console.log('filtro');
        console.log(model);
        let selectStatusPassageiro = document.getElementById('filtroStatusPassageiro');
        let opcoesStatusPassageiro = '<option>Escolha Filtro</option>';
        model.listaStatus.forEach(element => {
            if (element.entidade.descricao == 'PAGAMENTO_PASSAGEIROS') {
                opcoesStatusPassageiro += '<option value="' + element.descricao + '">' + element.descricao + '</option>';
            }

        });
        selectStatusPassageiro.innerHTML = opcoesStatusPassageiro;

        let selectFiltroViajnes = document.getElementById('filtroViajens');
        let opcoesViajens = '<option>Escolha Filtro</option>';
        model.viajens.forEach(element => {
            opcoesViajens += '<option value="' + element.viajemId + '">' + element.nomeViajem + '</option>';
        });
        selectFiltroViajnes.innerHTML = opcoesViajens;
    }
}