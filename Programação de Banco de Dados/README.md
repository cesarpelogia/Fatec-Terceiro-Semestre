### Programação de Banco de Dados
#### Fatec São José dos Campos - Professor Jessen Vidal
#### Prof. Juliana Forin Pasquini Martinez
<br>
<br>

### Prática 01 DDL:

Atividade realizada em dupla com: [Naira Maximo](https://gitgum.com/naira-maximo)
 
 - Criar o esquema físico de um banco de dados no MySQL para o projeto bdpratica01. O banco de dados deve conter três tabelas principais: CINEMA, FILME e SESSAO.

A tabela CINEMA deve incluir os seguintes atributos:

- cin_nomefantasia, que é obrigatório.
- cin_capacidade_lotacao, que também é obrigatório e deve ser maior que 0.
- cin_estado, que deve aceitar apenas os valores 'São Paulo', 'Rio de Janeiro' e 'Minas Gerais'.

A tabela FILME deve ter:

- fil_titulo_origem, que deve ser obrigatório e único.
- fil_duracao, que é obrigatório e deve ser maior que 0 minutos.

A tabela SESSAO deve conter:

ses_hora_inicial, que é obrigatório.<br>
ses_hora_final, que é obrigatório e deve ser posterior à ses_hora_inicial.<br>
ses_total_pessoas, que tem um valor padrão de 0.<br><br>
As restrições de integridade de dados, como preenchimento obrigatório e validações específicas, devem ser implementadas para assegurar a consistência e validade dos dados no banco de dados.

### Prática 02 - SQL (Junções)

Atividade realizada em dupla com: [Naira Maximo](https://gitgum.com/naira-maximo)

Com base no modelo E-R Venda, realizar as questões listadas a seguir, utilizando SQL.

1 -  Listar todos os clientes, ordenados por nome do cliente.<br><br>
2 - Listar os clientes cujos nomes começam com as letras 'F' ou 'B' e que são do estado de São Paulo (SP). <br><br>
&nbsp;&nbsp;&nbsp;&nbsp;Dica: Usar o comando LIKE.<br><br>
3 - Listar o nome do cliente do pedido de número 1.<br><br>
4 - Listar o nome do cliente e o nome do vendedor do pedido de código 2.<br><br>
5 - Listar a quantidade de pedidos.<br><br>
6 -Listar a quantidade de pedidos que cada vendedor realizou. <br>
&nbsp;&nbsp;&nbsp;&nbsp;Dica: Utilizar GROUP BY.<br><br>
7 - Listar todos os itens do pedido de código 1.<br><br>
8 - Listar a soma total do pedido de código 1.<br><br>
9 - Listar os clientes e os seus telefones (somente os clientes que possuam telefone).<br>
&nbsp;&nbsp;&nbsp;Dica: Utilizar INNER JOIN ou WHERE.<br><br>
10 - Listar os clientes e os seus telefones (incluindo os que não possuem telefone).<br>
&nbsp;&nbsp;&nbsp;Dica: Utilizar LEFT OUTER JOIN ou RIGHT OUTER JOIN.<br><br>
11 - Listar a quantidade de produtos por unidade (descrição).<br><br>
12 - Listar todos os pedidos realizados na data 01/10/2010.<br><br>
13 - Listar todos os pedidos realizados na data 01/10/2010 e que possuem prazo de entrega maior que 3 dias.<br><br>
14 - Listar todas as vendas (pedidos) do produto "Caneta".<br><br>
15 - Listar todos os pedidos que o cliente de código 1 realizou (exibir o número do pedido, data do pedido e o nome do cliente).<br><br>
16 - Listar a quantidade de pedidos que o cliente de código 2 realizou.<br><br>
17 - Listar o nome do produto de maior valor.<br><br>
18 - Quais pedidos possuem uma quantidade de itens maior que 5?<br><br>
19 - Quais clientes possuem pedidos com prazo de entrega maior que 15 dias e que são do estado de São Paulo ou Rio de Janeiro?<br><br>
20 - Criar mais 7 consultas (perguntas e respostas), seguindo as sintaxes apresentadas na aula.<br>
&nbsp;&nbsp;&nbsp;OBS: Usar UNION para representar o FULL OUTER JOIN.