/* Criação da tabela titulos no banco de dados cobrança. */
create table cobranca.titulo
(
    id        bigint not null auto_increment,
    data_vencimento date,
    descricao varchar(255),
    status    enum ('PENDENTE','RECEBIDO'),
    valor     decimal(38, 2),
    primary key (id)
) engine=InnoDB