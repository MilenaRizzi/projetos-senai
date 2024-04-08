-- Criar no banco de dados Postgres uma Tabela “herois”.
-- colunas: identificador (number - pk - auto-incremento), nome (varchar - not null), superpoder (varchar - nullable), idade (number - nullable),data_cadastro (data e hora - not null)
CREATE TABLE herois(
	identificador serial PRIMARY KEY,
	nome VARCHAR(40) NOT NULL,
	superpoder VARCHAR(40) NOT NULL,
	idade INT,
	data_cadastro timestamp NOT NULL
);
