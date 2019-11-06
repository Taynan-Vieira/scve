create sequence public.sc06_login_seq start 1;
create table if not exists public.sc06_login
(
    sc06_usuario varchar(255) not null,
    sc06_senha varchar(255) not null,
    constraint pksc06_usuario primary key (sc06_usuario)
);