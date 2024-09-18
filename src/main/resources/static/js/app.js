/* Código de validação de formulário com bootstrap 4.0 */
(function () {
    'use strict';
    window.addEventListener('load', function () {
        // Pega todos os formulários que nós queremos aplicar estilos de validação Bootstrap personalizados.
        var forms = document.getElementsByClassName('needs-validation');
        // Faz um loop neles e evita o envio
        var validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();

/* Configuração de calendário Datepicker */
$('.datepicker_input').datepicker({startDate: "date", todayHighlight: true})
    .on('changeDate', function (ev) {
        $('.datepicker_input').datepicker('hide');
    });

/* Configuração do campo valor, onde ao digitar um valor ele será formatado de acordo com o que for sendo digitado */
// prepara o input com a mascara
$(function () {
    $(".formatMonetario").maskMoney({
        allowNegative: true,
        thousands: '.',
        decimal: ','
    });
});

/* Configurando o modal para exclusão de títulos */
$('#exclusaoTituloModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal

    var titulo = button.data('id');
    var descricao = button.data('descricao');
    var valor = button.data('valor');
    var status = button.data('status');

    var modal = $(this);

    modal.find('.modal-title').text('EXCLUIR');

    modal.find('.modal-body span').html('<h6>Tem certeza que deseja EXCLUIR o título?</h6><strong>Descrição:</strong> ' + descricao + ';<br><strong>Valor:</strong> R$ ' + valor + ';<br><strong>Status:</strong> ' + status + ';');

    /* Recuperando o recurso/url do formulário para acessar o método de exclusão */
    var form = modal.find('form');
    var action = form.attr('action');

    /* Caso recurso/url não contenha barra (/) será adicionada. */
    if (!action.endsWith('/')) {
        action += '/';
    }
    onExcluirConfirmado(action, titulo);
})

/* Função que irá repassar ao mérodo de exclusão o Id do título e o verbo HTTP DELETE. */
function onExcluirConfirmado(action, titulo) {

    var URL = action + titulo;

    $.ajax({
        url: URL,
        method: "DELETE",
        contentType: 'application/json'
    });
}

/* Ativando efeito do tooltip da página de pesquisa de títulos, nos botões de editar e excluir. */
$(function () {
    $('[rel="tooltip"]').tooltip();
});

/* Função que irá atualizar o status do título na view */
$(function () {
    $('.atualizar-status').on('click', function (event) {
        event.preventDefault();

        var botaoReceber = $(event.currentTarget);
        var urlReceber = botaoReceber.attr('href');

        console.log('URL: ', urlReceber);
    });
});