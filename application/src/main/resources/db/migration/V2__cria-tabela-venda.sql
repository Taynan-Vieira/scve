create sequence public.sc02_venda_seq start 1;
create table if not exists public.sc02_venda
(
    sc02_cod_venda bigint not null default nextval('public.sc02_venda'::regclass),
    sc02_data_venda timestamp not null,
    sc02_tipo_de_pagamento varchar(255) not null,
    sc02_valor numeric not null,
    fksc02sc01_cod_cliente bigint not null,
    constraint pksc02_cod_venda primary key (sc02_cod_venda),
    constraint fksc02sc01_cod_cliente foreign key (fksc02sc01_cod_cliente)
    references sc01_cliente (sc01_cod_cliente)
);