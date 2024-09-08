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
$('.datepicker_input').datepicker();

/* Configuração do campo valor, onde ao digitar um valor ele será formatado de acordo com o que for sendo digitado */
// prepara o input com a mascara
$(function () {
    $(".formatMonetario").maskMoney({
        allowNegative: true,
        thousands: '.',
        decimal: ','
    });
});