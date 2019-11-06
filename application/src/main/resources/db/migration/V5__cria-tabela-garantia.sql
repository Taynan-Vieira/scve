create sequence public.sc05_garantia_seq start 1;
create table if not exists public.sc05_garantia
(
    sc05_cod_garantia bigint not null,
    sc05_descricao varchar(255) not null,
    fksc05sc02_cod_venda bigint not null,
    constraint pksc05_cod_garantia primary key (sc05_cod_garantia),
    constraint fksc05sc02_cod_venda foreign key (fksc05sc02_cod_venda)
    references sc02_venda (sc02_cod_venda)
);