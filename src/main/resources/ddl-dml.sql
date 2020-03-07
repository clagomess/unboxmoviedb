DROP ALL OBJECTS;

-- TABLES
create table tbl_usuario (
    seq_usuario bigint not null,
    des_email varchar(255) not null,
    des_senha varchar(255) not null
);

ALTER TABLE tbl_usuario ADD CONSTRAINT pk_usuario PRIMARY KEY ( seq_usuario );

create table tbl_filme (
    seq_filme bigint not null,
    nom_filme varchar(200) not null,
    nom_filme_original varchar(200) not null,
    num_voto bigint not null,
    num_voto_media numeric(10,2) not null,
    sit_filme varchar(200) not null
);

ALTER TABLE tbl_filme ADD CONSTRAINT pk_filme PRIMARY KEY ( seq_filme );

create table tbl_filme_produtora (
    seq_filme_produtora bigint not null,
    seq_filme bigint not null,
    nom_produtora varchar(200) not null,
    sgl_pais varchar(2) not null
);

alter table tbl_filme_produtora ADD CONSTRAINT pk_filme_produtora PRIMARY KEY ( seq_filme_produtora );

-- SEQUENCES
CREATE SEQUENCE seq_usuario START WITH 1;
CREATE SEQUENCE seq_filme START WITH 1;
CREATE SEQUENCE seq_filme_produtora START WITH 1;

-- DML
insert into tbl_usuario (seq_usuario, des_email, des_senha)
values ( nextval('seq_usuario'), 'cla.gomess@gmail.com', '{bcrypt}$2a$10$FJPkaSyQSZmNFb0CGylmf.xPvm8umkSZRqtmGw5nhaGqQW6eixbTG' );

insert into tbl_filme (
    seq_filme, nom_filme, nom_filme_original,
    num_voto_media, num_voto, sit_filme
) values (
    nextval('seq_filme'), 'Clube da Luta', 'Fight Club',
    8.4, 18276, 'Released'
);

insert into tbl_filme_produtora (seq_filme_produtora, seq_filme, nom_produtora, sgl_pais)
values ( nextval('seq_filme_produtora'), currval('seq_filme'), 'Regency Enterprises', 'US');