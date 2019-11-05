create sequence public.sc01_cliente_seq start 1;
create table if not exists public.sc01_cliente
(
    sc01_cod_cliente bigint not null default nextval('public.sc01_cliente_seq'::regclass),
    sc01_nome         varchar(255),
    sc01_telefone varchar(255),
    sc01_whatsapp boolean,
    constraint pksc01_cod_cliente primary key (sc01_cod_cliente)
);