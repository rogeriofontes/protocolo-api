# protocolo-api


EXEMPLO de Criação do Bando de dados em PostGres

CREATE DATABASE blog_4P_ads;

CREATE SCHEMA blog;

CREATE TABLE blog.tbl_user (
	id SERIAL CONSTRAINT pk_user_id PRIMARY KEY,
	username varchar(120) NOT NULL,
	password varchar(120) NOT NULL,
	UNIQUE(username)
);

CREATE TABLE blog.tbl_autor (
	id SERIAL CONSTRAINT pk_autor_id PRIMARY KEY,
	nome varchar(120) NOT NULL,
	email varchar(120) NOT NULL,
	bio TEXT NOT NULL,
	id_user integer NOT NULL,
	FOREIGN KEY (id_user) REFERENCES blog.tbl_user (id) ON DELETE CASCADE
);

CREATE TABLE blog.tbl_blog (
	id SERIAL CONSTRAINT pk_blog_id PRIMARY KEY,
	nome varchar(120) NOT NULL,
	id_user integer NOT NULL,
	FOREIGN KEY (id_user) REFERENCES blog.tbl_user (id) ON DELETE CASCADE
);

CREATE TABLE blog.tbl_categoria (
	id SERIAL CONSTRAINT pk_categoria_id PRIMARY KEY,
	nome varchar(120) NOT NULL,
	UNIQUE(nome)
);

CREATE TABLE blog.tbl_tag (
	id SERIAL CONSTRAINT pk_tag_id PRIMARY KEY,
	nome varchar(120) NOT NULL,
	UNIQUE(nome)
);

CREATE TABLE blog.tbl_post (
	id SERIAL CONSTRAINT pk_post_id PRIMARY KEY,
	titulo varchar(120) NOT NULL,
	conteudo TEXT NOT NULL,
	data_post date,
	id_autor integer NOT NULL,
	id_blog integer NOT NULL,
	FOREIGN KEY (id_autor) REFERENCES blog.tbl_autor (id) ON DELETE CASCADE,
	FOREIGN KEY (id_blog) REFERENCES blog.tbl_blog (id) ON DELETE CASCADE
);

CREATE TABLE blog.tbl_post_tab (
	id SERIAL CONSTRAINT pk_post_tab_id PRIMARY KEY,
	id_tag integer NOT NULL,
	id_post integer NOT NULL,
	FOREIGN KEY (id_tag) REFERENCES blog.tbl_tag (id) ON DELETE CASCADE,
	FOREIGN KEY (id_post) REFERENCES blog.tbl_post (id) ON DELETE CASCADE
);


--
INSERT INTO blog.tbl_user (username, password) VALUES ('rogerio.fontes', '123456');
INSERT INTO blog.tbl_autor (nome, email, bio, id_user) VALUES ('Rogerio Fontes', 'rogerio.fontes@localhost.com', 'nada a declarar', '1');
INSERT INTO blog.tbl_categoria (nome) VALUES ('Programação');

INSERT INTO blog.tbl_blog (nome, id_user) VALUES ('blog 4 p ads', '1')
INSERT INTO blog.tbl_post (titulo, conteudo, data_post, id_autor, id_blog) VALUES ('post test', 'post test conteudo', '2021-09-28', '1', '1');

INSERT INTO blog.tbl_tag (nome) VALUES ('#java');
INSERT INTO blog.tbl_tag (nome) VALUES ('#foguete não tem 4');

INSERT INTO blog.tbl_post_tab (id_tag, id_post) VALUES ('1', '1');
INSERT INTO blog.tbl_post_tab (id_tag, id_post) VALUES ('2', '1');

