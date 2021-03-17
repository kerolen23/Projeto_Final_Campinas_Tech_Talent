create database cadastro;
use cadastro;

create table dados (
id int auto_increment not null primary key,
nome varchar(60) not null,
login varchar(60) not null,
senha varchar(20) not null,
datacadastro date);  

select * from dados;
