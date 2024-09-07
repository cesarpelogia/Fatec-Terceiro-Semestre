create database bdpratica01;

use bdpratica01;

create table cinema (
    cin_cod integer primary key,
    cin_nomefantasia varchar(18) not null,
    cin_rua varchar(20),
    cin_avenida varchar(20),
    cin_bairro varchar(10),
    cin_municipio varchar(20),
    cin_estado varchar(18),
    cin_capacidade_lotacao integer not null,
    constraint ck_cin_estado check(cin_estado in ('São Paulo', 'Rio de Janeiro', 'Minas Gerais')),
    constraint ck_cin_capacidade check (cin_capacidade_lotacao > 0)
);

create table ator (
    ato_codigo integer primary key,
    ato_nome varchar(20),
    ato_nacionalidade varchar(20),
    ato_idade integer
);

create table genero (
    gen_codigo integer primary key,
    gen_descricao varchar(18)
);

create table tipo (
    tip_codigo integer primary key,
    tip_descricao varchar(18)
);

create table filme (
    fil_codigo integer primary key,
    gen_codigo integer,
    tip_codigo integer,
    fil_titulo_original varchar(18) not null unique,
    fil_titulo_portugues varchar(18),
    fil_duracao integer not null,
    fil_pais_origem varchar(15),
    foreign key(gen_codigo) references genero(gen_codigo),
    foreign key(tip_codigo) references tipo(tip_codigo),
    constraint ck_fil_duracao check (fil_duracao > 0)
);

create table filme_cinema (
    fil_codigo integer,
    cin_cod integer,
    primary key (fil_codigo, cin_cod),
    foreign key(fil_codigo) references filme(fil_codigo),
    foreign key(cin_cod) references cinema(cin_cod)
);

create table sessao (
    ses_codigo integer primary key,
    fil_codigo integer,
    cin_cod integer,
    ses_hora_inicial datetime not null,
    ses_hora_final datetime not null,
    ses_total_pessoas integer default 0,
    constraint ck_ses_hora_final check(ses_hora_final > ses_hora_inicial),
    foreign key(fil_codigo, cin_cod) references filme_cinema(fil_codigo, cin_cod)
);

create table ator_filme (
    ato_codigo integer,
    fil_codigo integer,
    primary key (fil_codigo, ato_codigo),
    foreign key(ato_codigo) references ator(ato_codigo),
    foreign key(fil_codigo) references filme(fil_codigo)
);

SHOW CREATE TABLE sessao;
SHOW TABLE STATUS WHERE Name ='sessao';




