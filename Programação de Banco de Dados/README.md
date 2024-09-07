### Programação de Banco de Dados
#### Fatec São José dos Campos - Professor Jessen Vidal
#### Prof. Juliana Forin Pasquini Martinez
<br>
<br>

### Pratica DDL 01:
 
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