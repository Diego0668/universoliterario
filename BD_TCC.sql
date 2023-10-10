create database UniversoLiterario1
go


use UniversoLiterario1

--drop table editora

create table editora
(
id int identity primary key,
nome varchar (50) not null,
)

insert into editora values ('Harper Collins')
insert into editora values ('Darkside')
insert into editora values ('Record')
insert into editora values ('Intr�nseca')
insert into editora values ('Suma')

insert into editora values ('Seguinte')
insert into editora values ('Galera')
insert into editora values ('Alt')

insert into editora values ('Arqueiro ')
insert into editora values ('Jangada')
insert into editora values ('Outro Planeta')

insert into editora values ('Planeta Minotauro')
insert into editora values ('Rocco')

insert into editora values ('Aleph')

insert into editora values ('Via Leitura')
insert into editora values ('Culturama')
insert into editora values ('C. F. Telles')
insert into editora values ('Rocco Jovens Leitores')
insert into editora values ('Geogr�fica Editora')


create table autor
(
id int identity primary key,
nome varchar (50) not null,
)

insert into autor values ('William Peter Blatty')
insert into autor values ('Bram Stoker')
insert into autor values ('Alex Michaelides')
insert into autor values ('C. J. Tudor')
insert into autor values ('Stephen King')
insert into autor values ('Agustina Bazterrica')
insert into autor values ('John Fowles')
insert into autor values ('Sheridan Le Fanu')
insert into autor values ('Harold Schechter')

insert into autor values ('Casey McQuiston')
insert into autor values ('Giulianna Domingues')
insert into autor values ('Clara Alves')
insert into autor values ('Elayne Baeta')
insert into autor values ('Adam Silveira')
insert into autor values ('Pedro Rhuas')
insert into autor values ('Vitor Martins')
insert into autor values ('Vitor Marins')

insert into autor values ('Rachael Lippincott')
insert into autor values ('Ali Hazelwood')
insert into autor values ('Jenna Evans Welch')
insert into autor values ('Kiera Cass')
insert into autor values ('Colleen Hoover')
insert into autor values ('C. C. Hunter')
insert into autor values ('John Green')
insert into autor values ('Samantha Silvany')
insert into autor values ('Tillie Cole')

insert into autor values ('J.R.R. Tolkien')
insert into autor values ('GEORGE R. R. MARTIN')
insert into autor values ('Neil Gaiman')
insert into autor values ('Marion Zimmer Bradley')
insert into autor values ('PATRICK ROTHFUSS')
insert into autor values ('Clive Staples Lewis')
insert into autor values ('Lyman Frank Baum')
insert into autor values ('Christopher Paolini')
insert into autor values ('Danielle L. Jensen')
insert into autor values ('Lewis Carroll')

insert into autor values ('Daniel Keyes')
insert into autor values ('Blake crouch') 
insert into autor values ('Cixin Liu')
insert into autor values ('Rysa Walker')
insert into autor values ('Andy Weir')
insert into autor values ('John Scalzi')
insert into autor values ('Anthony Burgess')
insert into autor values ('Isaac Asimov')

insert into autor values ('HG Wells')
insert into autor values ('rick riordan')
insert into autor values ('marvel comics')
insert into autor values ('c. f. telles')
insert into autor values ('suzanne collins')
insert into autor values ('carter roy')
insert into autor values ('sergio cariello')


create table genero
(
id int identity primary key,
descricao varchar (30) not null,
)

insert into genero (descricao) values ('terror')
insert into genero (descricao) values ('lgbtqia+')
insert into genero (descricao) values ('romance')
insert into genero (descricao) values ('fantasia')
insert into genero (descricao) values ('fic��o cientifica')
insert into genero (descricao) values ('a��o e aventura')


create table livro
(
id int identity primary key,
titulo varchar (150) not null,
isbn varchar (50) not null,
estoque int not null,
preco decimal (10,2) not null, -- 99999999.99
imagem varbinary(MAX),
id_editora int  not null,
id_autor int  not null,
id_genero int  not null,
foreign key (id_editora) references editora(id),
foreign key (id_autor) references autor(id),
foreign key (id_genero) references genero(id)
)



create table funcionario
(
id int identity primary key,
nome varchar (120) not null,
email varchar (400) not null,
senha_usuario varchar (150) not null,
nivelAcess varchar (10) null
)

select * from funcionario

insert into funcionario values ('sabrine', 'sabrineintint@gmail.com', 'mkvybhf__0214356', 'adm')
insert into funcionario values ('milenu', 'milolikuj87@gmail.com', '7841poiuytwq', 'func')

