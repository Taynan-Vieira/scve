create sequence public.sc04_tipo_produto_seq start 1;
create table if not exists public.sc04_tipo_produto
(
    sc04_cod_tipo_produto bigint not null,
    sc04_descricao varchar(255) not null,
    fksc04sc03_cod_produto bigint not null,
    constraint pksc04_cod_tipo_produto primary key (sc04_cod_tipo_produto),
    constraint fksc04sc03_cod_produto foreign key (fksc04sc03_cod_produto)
    references sc03_produto (sc03_cod_produto)

);