class PagamentoPassageiroView {
    constructor(templateContainer) {
        this._templateContainer = templateContainer;
    }
    _inicializaTemplateContainer(model) {
        let containerPagamentos = '';
        containerPagamentos += `
            <div class="container-fluid">
            <div class="row">
                <div class="col-md-4">
                    <div class="card card-nav-tabs">
                        <div class="card-header card-header-warning">
                            Passageiro
                        </div>
                        <div class="card-body">
                            <h4 class="card-title">${model.nomePassageiro}</h4>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card card-nav-tabs">
                        <div class="card-header card-header-warning">
                            Viajem
                        </div>
                        <div class="card-body">
                            <h4 class="card-title">${model.nomeViajem}</h4>
                            <!-- <p>Saída 10/09/2018 18:30 </p> -->
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card card-nav-tabs">
                        <div class="card-header card-header-warning">
                            Valor Da Viajem
                        </div>
                        <div class="card-body">
                            <h4 class="card-title">R$ ${model.valorViajem}</h4>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-9">
                    <div class="card">
                        <div class="card-header card-header-danger">
                            <h4 class="card-title">Pagamentos</h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <th>Parcela</th>
                                        <th>Valor</th>
                                        <th>Data vencimento</th>
                                        <th>Data pagamento</th>
                                        <th>Forma de pagemento</th>
                                        <th>Status</th>
                                        <th>Ação</th>
                                    </thead>
                                    <tbody id="pagamentosTemplate">
                                        
                                    </tbody>
                                </table>
                                <button class="btn btn-danger" data-toggle="modal" data-target="#modalPagamento"><i
                                        class="material-icons">add</i></button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card card-nav-tabs">
                        <div class="card-header card-header-danger">
                            Status
                        </div>
                        <div class="card-body">
                            <h4 class="card-title">${model.status}</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        `;
        return containerPagamentos;
    }
    _templatePagamentos(model) {
        console.log(model);
        let cardPagamentos = '';
        if (model != null && model.length > 0) {
            
            model.forEach(element => {
                
                cardPagamentos += `
                <tr>
                    <td>${element.parcela}</td>
                    <td>R$ ${element.valor}</td>
                    <td>${element.dataVencimento}</td>
                    <td>${element.dataPagamento}</td>
                    <td>${element.formaPagamento}</td>
                    <td>${element.statusPagamento}</td>
                    <td>
                        <a href="#" onclick="pagamentoPassageiroController.openEditPagamento(event,${element.pagamentoId})" style="color:black">
                            <i class="material-icons">edit</i>
                        </a>
                        <a href="#" onclick="pagamentoPassageiroController.excluiPagamento(event,${element.pagamentoId})">
                            <i class="material-icons" style="color:black">delete_forever</i>
                        </a>
                    </td>
                </tr>
                `;
            });
        }
        
        return cardPagamentos;
    }

    inicializaContainer(model) {
        this._templateContainer.innerHTML = this._inicializaTemplateContainer(model);
        this.atualizaPagamentos(model);
    }
    
    atualizaPagamentos(model) {
        let element = document.querySelector('#pagamentosTemplate');
        element.innerHTML = this._templatePagamentos(model.listaPagamentos);
    }
    
}