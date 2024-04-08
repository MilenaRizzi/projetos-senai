/*Na tabela de herois criada, insira os seguintes dados via SQL: 
Nome: Spiderman
Superpoder: teia
Idade: 18
data de cadastro: data atual
---
Nome: Iron Man
Superpoder: armadura
Idade: 40
data de cadastro: data atual
---
Nome: Batman
Superpoder: bat-coisas
Idade: 39
data de cadastro: data atual
---
Nome: Superman
Superpoder: super-força
Idade: 26
data de cadastro: data atual
*/

INSERT INTO herois 
(nome, superpoder, idade, data_cadastro)
VALUES
('Spiderman', 'teia', 18, CURRENT_TIMESTAMP),
('Iron Man', 'armadura', 40, CURRENT_TIMESTAMP),
('Batman', 'bat-coisas', 39, CURRENT_TIMESTAMP),
('Superman', 'super-força', 26, CURRENT_TIMESTAMP);
