# systemLogin_CRUD

## Sistema de login em Java, utilizando banco de dados (MySQL).

Utilizando jdbc para conectar com o MySQL e javax Swing para criar a GUI simples. 

Divido em três pacotes (GUI(Graphical User Interface), DAO (Data Acess Object) e DTO (Data Transfer Object)).

 *** Criar, ler, alterar dados e deletar dados da tabela do MySQL estão funcionando, entretanto, preciso corrigir a exception "userjava.sql.SQLIntegrityConstraintViolationException", que é retornada quando tenta registrar utilizando um username já registrado no banco de dados, sendo que username é uma entrada única(não é possível registrar 2 usernames iguais no banco de dados). ***