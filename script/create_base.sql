create database dados_beneficiario_spring;
use dados_beneficiario_spring;

create table login(
idlogin int auto_increment,
login varchar(100) not null,
senha varchar(100) not null,
email varchar(300) not null,
senhainicial varchar(2) not null,
ativo int,
ultimologin datetime,

 constraint login_pk PRIMARY KEY (idlogin)

);

create table estado(

idestado int auto_increment,
estado varchar(300) not null,

constraint Pk_estado PRIMARY KEY (idestado)

);

create table cidade(

idcidade int auto_increment,
cidade varchar(300) not null,
idestado int not null,

constraint pk_cidade PRIMARY KEY (idcidade),
constraint fk_estado_cidade foreign key(idestado) references estado(idestado)

);

create table beneficiario(

idbenef int auto_increment,
idlogin int not null,
nome_comp varchar(255) not null,
cpfcnpj varchar(30),
RG varchar(30),
data_nasc datetime,
idestado int,
cidade int,
telefone varchar(20),
celular varchar(20),
ativo varchar(1),
sexo int not null,
carteirinha varchar(100) not null unique,

constraint pk_benef PRIMARY KEY (idbenef),
constraint fk_benef_estado foreign key(idestado) references estado(idestado),
constraint fk_benef_login foreign key(idlogin) references login(idlogin),
constraint fk_benef_est foreign key(idestado) references estado(idestado)
);

