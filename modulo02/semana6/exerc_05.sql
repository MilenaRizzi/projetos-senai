--Selecione, usando SQL, o “identificador” e “nome” dos heróis que tem o campo de “superpoder” preenchido (not null).


SELECT identificador, nome FROM herois WHERE superpoder IS NULL;
