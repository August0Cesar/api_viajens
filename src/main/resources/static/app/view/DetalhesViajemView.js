class DetalhesViajemView {
    constructor(templateContainer) {
        this._templateContainer = templateContainer;
    }
    _inicializaTemplateContainer(model) {
        let cardsViajens = '';
        cardsViajens += `
        <div class="col-md-4" id="templateCardViajem">
        <div class="card" style="width: 25rem;">
            <img class="card-img-top" src="https://images.unsplash.com/photo-1517303650219-83c8b1788c4c?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=bd4c162d27ea317ff8c67255e955e3c8&auto=format&fit=crop&w=2691&q=80"
                alt="Card image cap">
            <h4 class="card-title card-principal text-center">${model.viajem.nomeViajem}</h4>
            <h5 class="card-text card-principal"><b>Valor da Passagem </b> R$ ${model.viajem.valorPassagem} </h5>
            <h5 class="card-text card-principal"><b>Custos </b> R$ ${model.viajem.totalCusto} </h5>
            <p class="card-text card-principal"><b>Saída </b> ${model.viajem.dataInicio} </p>
            <p class="card-text card-principal"><b>Pago até o momento R$ ${model.viajem.valorPago}</b></p>
            <div class="align-self-center">
                <div class="circle-card">${model.passageiros.length}/${model.viajem.qtdPassageiros}</div>
            </div>
        </div>
    </div>
    <div class="col-md-8" id="templateDadosViajem">
        <div class="card card-nav-tabs">
            <div class="card-header card-header-danger">
                <div class="row">
                    <div class="col-md-6">
                        <div class="card">
                            <div class="card-body">
                                <p><b>Data de Saída: </b>${model.viajem.dataInicio}</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card">
                            <div class="card-body">
                                <p><b>Data de Chegada: </b>${model.viajem.dataFinal}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-body">
                <h4 class="card-title">Descricao da Viajem</h4>
                <p class="card-text">${model.viajem.descricao}</p>
            </div>
        </div> 
        <!-- <br> -->
        <div class="card">
            <div class="card-header card-header-danger" style="margin-top:1em">
                <h4 class="card-title ">Custos Fixos da Viajem</h4>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <th>Descrição do Custo</th>
                            <th>Valor</th>
                            <th>Ação</th>
                        </thead>
                        <tbody id="bodyCustos">
                            
                        </tbody>
                    </table>
                    <button class="btn btn-danger" data-toggle="modal" data-target="#modalCusto">Novo Custo</button>
                </div>
            </div>
        </div> 
        <!-- Tabela de Passageiros -->
        <div class="card">
            <div class="card-header card-header-danger" style="margin-top:1em">
                <h4 class="card-title">Passageiros</h4>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <th>Nome Passageiro</th>
                            <th>Parcelas Pagas</th>
                            <th>Quantidade de Parcelas</th>
                            <th>Valor Pago</th>
                            <th>Ação</th>
                        </thead>
                        <tbody id="bodyPassageiros">
                            
                        </tbody>
                    </table>
                    <button class="btn btn-danger" data-toggle="modal" data-target="#modalPassageiro">Novo Passageiro</button>
                    <button class="btn btn-danger">Gera lista de Passageiros</button>
                </div>
            </div>
        </div>
            `;
        return cardsViajens;
    }
    _templateCustos(model) {
        let cardCustos = '';
        if (model.custos != null && model.custos.length > 0) {
            model.custos.forEach(element => {
                cardCustos += `
                    <tr>
                        <td>${element.descricao}</td>
                        <td>R$ ${element.valor}</td>
                        <td>editCusto
                            <a href="#" onclick="detalhesViajemController.editCusto(event,${element.id})"><i class="material-icons" style="color:black">edit</i></a>
                            <a href="#" onclick="detalhesViajemController.excluiCusto(event,${element.id})"><i class="material-icons" style="color:black">delete_forever</i></a>
                        </td>
                    </tr>
                `;
            });
        }
        return cardCustos;
    }
    _templatePassageiros(model) {
        let cardPassageiros = '';
        if (model != null && model.length > 0) {
            
            model.forEach(element => {
                cardPassageiros += `
                    <tr>
                        <td>${element.nomePassageiro}</td>
                        <td>${element.parcelasPagas}</td>
                        <td>${element.qtdParcelas}</td>
                        <td>R$ ${element.valorPago}</td>
                        <td>
                            <a href="#" style="color:black" onclick="detalhesViajemController.openDetalhesPagamento(event,${element.passageiroId})"><i class="material-icons">format_list_bulleted</i></a>
                            <a href="#" onclick="detalhesViajemController.excluiPassageiro(event,${element.passageiroId})"><i class="material-icons" style="color:black">delete_forever</i></a>
                        </td>
                    </tr>
                `;
            });
        }
        
        return cardPassageiros;
    }

    inicializaContainer(model) {
        this._templateContainer.innerHTML = this._inicializaTemplateContainer(model);
        this.atualizaCustos(model);
        this.atualizaPassageiros(model.passageiros);
        this.carregaModalNovoPassageiro(model);
    }
    
    atualizaCustos(model) {
        let element = document.querySelector('#bodyCustos');
        element.innerHTML = this._templateCustos(model);
    }

    atualizaPassageiros(model) {
        let element = document.querySelector('#bodyPassageiros');
        element.innerHTML = this._templatePassageiros(model);
    }

    carregaModalNovoPassageiro(model) {
        let select = document.getElementById('viajemPassageiro');
        let opcoes = '<option value="' + model.viajem.viajemId + '">' + model.viajem.nomeViajem + '</option>';
        select.innerHTML = opcoes;
    }
}