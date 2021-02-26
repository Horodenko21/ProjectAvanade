#Projeto Final (Avaliação)

Api de Conta Corrente

## Especificações Funcionais

- Autenticar o usuário pelo Login do Cliente
- Alterar os dados cadastrais do Cliente
- Depositar/Sacar da Conta Corrente do Cliente
- Mostrar a situação da Conta Corrente (saldo)
- Mostrar o histórico de Operações

## Especificações Não Funcionais

- As operações de Cliente e Login devem ser feitos com o banco relacional PostgreSql
- As operações de Conta Corrente devem ser feitas com o banco não relacional MongoDB
- Não deve conter interface, somente o Postman


## Modelagem

TODOS
- Id
- dataCriacao
- dataAtualizacao
- ativo

Cliente
- Nome
- Sobrenome
- Telefone
- Email
- Login

Login
- Senha
- Usuario

ContaCorrente
- Saldo

---------------------------

Operação
- Id
- dataCriacao
- ContaCorrente
- valor
- tipo