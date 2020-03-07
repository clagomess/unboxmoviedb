DROP ALL OBJECTS;

-- TABLES
create table tbl_usuario (
    seq_usuario bigint not null,
    des_email varchar(255) not null,
    des_senha varchar(255) not null
);

ALTER TABLE tbl_usuario ADD CONSTRAINT pk_usuario PRIMARY KEY ( seq_usuario );

-- SEQUENCES
CREATE SEQUENCE seq_usuario START WITH 1;

-- DML
insert into tbl_usuario (seq_usuario, des_email, des_senha)
values ( nextval('seq_usuario'), 'cla.gomess@gmail.com', '{bcrypt}$2a$10$FJPkaSyQSZmNFb0CGylmf.xPvm8umkSZRqtmGw5nhaGqQW6eixbTG' );