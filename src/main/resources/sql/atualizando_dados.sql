/* Atualizando registros na tabela de titulos. */
update cobranca.titulo
set status='PENDENTE'
where id between 1 and 10;