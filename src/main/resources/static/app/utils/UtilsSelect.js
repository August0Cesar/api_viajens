class UtilsSelect {

    constructor() {
        throw new Error('Esta classe não pode ser instanciada');
    }
    
    static populaSelectCondicaoEspecialEdit(condicaoEspecialId) {
        let optionCondicoesEspeciais = '';

        let opcoesCondicoesEpesciais = [{ id: 1, texto: 'Adulto' },
                                        { id: 2, texto: 'Crianças' },
                                        { id: 3, texto: 'Combo' },
                                        { id: 4, texto: 'Outros' },
        ];

        opcoesCondicoesEpesciais.forEach(op => {

            if (op.id == condicaoEspecialId) {

                optionCondicoesEspeciais += `<option value="${op.id}" selected>${op.texto}</option>`
            } else {

                optionCondicoesEspeciais += `<option value="${op.id}">${op.texto}</option>`
            }
        });
        return optionCondicoesEspeciais;
    }
    static populaSelectCondicaoFormaPagamentoEdit(formaPagamento) {
        console.log('Forma Pagamento '+ formaPagamento);
        let formaPagamentoSelecionado = '';

        let formaPagamentos = [
                                { id: 1,texto: 'Dinheiro'},
                                { id: 2,texto: 'Crédito'},
                                { id: 3,texto: 'Débito'},
                                { id: 4,texto: 'Outros'},
                                { id: 5,texto: 'Cheque'}
                              ];

        formaPagamentos.forEach(op => {

            if (op.id == formaPagamento.id) {
                formaPagamentoSelecionado += `<option value="${op.id}" selected>${op.texto}</option>`
            } else {

                formaPagamentoSelecionado += `<option value="${op.id}">${op.texto}</option>`
            }
        });
        return formaPagamentoSelecionado;
    }

}
