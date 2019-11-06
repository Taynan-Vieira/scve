create sequence public.sc03_produto_seq start 1;
create table if not exists public.sc03_produto
(
   sc03_cod_produto bigint not null,
   sc03_nome varchar(255),
   fksc03sc02_cod_venda bigint not null,
   constraint pksc03_cod_produto primary key (sc03_cod_produto),
   constraint fksc03sc02_cod_venda foreign key (fksc03sc02_cod_venda)
   references sc02_venda (sc02_cod_venda)
);