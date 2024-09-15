-- Prática 02 - Join

use venda;

-- 1. Listar todos os clientes, ordenados por nome do cliente. 
select * from cliente
order by cli_nome;

-- 2. Listar os clientes que os nomes comecem com as letras ‘F’ ou ‘B’ e são do estado de São Paulo (SP). Dica: Usar o comando like. 
select * from cliente
where cli_nome like 'F%' or cli_nome like 'B%'
and cli_estado = 'SP';

-- 3. Listar o nome do cliente do pedido de número 1. 
select p.ped_numero, c.cli_nome
from pedido p, cliente c
where c.cli_codigo = p.cli_codigo and p.ped_numero = 1;

-- 4. Listar o nome do cliente, o nome do vendedor do pedido de código 2. 
select p.ped_numero, c.cli_nome, v.ven_nome
from cliente c, pedido p, vendedor v
where c.cli_codigo = p.cli_codigo and v.ven_codigo = p.ven_codigo and p.ped_numero = 2;

-- 5. Listar a quantidade de pedido.
select count(ped_numero) 'quantidade de pedido'
from pedido;

-- 6. Listar a quantidade de pedido que cada vendedor realizou (Dica: Utilizar group by) 
select v.ven_nome, count(p.ped_numero)
from vendedor v
left join pedido p on v.ven_codigo = p.ven_codigo
group by v.ven_nome;

-- 7. Listar todos os itens do pedido de código 1.
select i.pro_codigo, p.prod_descricao, i.item_quantidade
from item_pedido i, produto p
where i.pro_codigo = p.pro_codigo and i.ped_numero = '1';

-- 8. Listar a soma total do pedido de código 1.
select sum(i.item_quantidade * p.pro_valor_unidade) 'soma total do pedido'
from item_pedido i
join produto p on i.pro_codigo = p.pro_codigo
where i.ped_numero = 1;

-- 9. Listar os clientes e os seus telefones (Listar apenas os clientes que possuam telefone). 
select c.cli_codigo, c.cli_nome, t.tel_numero
from cliente c join telefone t
where t.cli_codigo = c.cli_codigo;

-- 10. Listar os clientes e os seus telefones (Listar também os clientes que não tenham telefone) 
select c.cli_codigo, c.cli_nome, t.tel_numero
from cliente c left join telefone t
on t.cli_codigo = c.cli_codigo;

-- 11. Listar quantidade de produtos por unidade(descrição).
select prod_descricao, pro_quantidade
from produto
order by pro_quantidade;

-- 12. Listar todos os pedidos realizados na data 01/10/2010.
select * from pedido
where ped_data = '2010-10-01';

-- 13. Listar todos os pedidos realizados na data 01/10/2010 e que possuem prazo de entrega maior que 3. 
select * from pedido
where ped_data = '2010-10-01' and ped_prazo_entrega > 3;

-- 14. Listar todas as vendas(pedidos) do produto Caneta.
select i.pro_codigo, pr.prod_descricao, i.item_quantidade, i.ped_numero, p.ped_data
from item_pedido i join produto pr join pedido p
on i.pro_codigo = pr.pro_codigo and i.ped_numero = p.ped_numero
where pr.prod_descricao = 'Caneta';

-- 15. Listar todos os pedidos que o cliente de código 1 realizou (exibir o número do pedido, data do pedido e o nome do cliente)
select p.ped_numero, p.ped_data, c.cli_nome
from pedido p
join cliente c on p.cli_codigo = c.cli_codigo
where p.cli_codigo = 2;

-- 16. Listar a quantidade de pedidos que o cliente de código 2 realizou.
select count(distinct p.ped_numero) as quantidade_pedidos
from pedido p
join item_pedido i on p.ped_numero = i.ped_numero
where cli_codigo = '2';

-- 17. Listar o nome do produto de maior valor.
select prod_descricao
from produto
where pro_valor_unidade = (select max(pro_valor_unidade) from produto);

-- 18. Quais pedidos possuem uma quantidade de itens maior que 5?
select p.ped_numero, SUM(ip.item_quantidade) as total_itens
from pedido p
join item_pedido ip on p.ped_numero = ip.ped_numero
group by p.ped_numero
having sum(ip.item_quantidade) > 5;


-- 19. Quais clientes possuem pedidos com prazo de entrega maior que 15 dias e que são do estado de São Paulo ou Rio de Janeiro?
select c.cli_nome, c.cli_codigo, p.ped_prazo_entrega
from cliente c
join pedido p on c.cli_codigo = p.cli_codigo
where cli_estado in ('SP', 'RJ') and p.ped_prazo_entrega > 15;

-- 20. Criar mais 7 consultas (Perguntas e Respostas), seguindo as sintaxes apresentadas na imagem a seguir. OBS: Usar Union para representar o FULL OUTER JOIN. 

-- 20.1.a Listar todos os vendedores e suas respectivas vendas (pedidos).
select v.ven_nome, p.ped_numero
from vendedor v left join pedido p 
on v.ven_codigo = p.ven_codigo;

-- 20.1.b Listar as quantidades de vendas (pedidos) de cada vendedor.
select v.ven_nome, count(p.ped_numero) 'quantidade de vendas'
from vendedor v left join pedido p 
on v.ven_codigo = p.ven_codigo
group by v.ven_nome;

-- 20.2 Listar todos os clientes que possuem pelo menos um pedido.
select c.cli_nome, p.ped_numero
from cliente c inner join pedido p
on c.cli_codigo = p.cli_codigo;

-- 20.3.a Listar todos os pedidos e seus respectivos clientes.
select p.ped_numero, c.cli_nome
from cliente c right join pedido p
on p.cli_codigo = c.cli_codigo;

-- 20.3.b Listar todos os clientes e a quantidade dos pedidos feitos.
select c.cli_nome, count(p.ped_numero) 'quantidade de pedidos'
from pedido p right join cliente c
on p.cli_codigo = c.cli_codigo
group by c.cli_nome;

-- 20.4 Listar todos os clientes que não possuem pedidos.
select c.cli_nome
from cliente c left join pedido p 
on c.cli_codigo = p.cli_codigo
where p.ped_numero is null;

-- 20.5 Listar todos os clientes que não possuem telefone.
select c.cli_nome
from telefone t right join cliente c
on c.cli_codigo = t.cli_codigo
where t.tel_numero is null;

-- 20.6 Listar todos os funcionários e seus departamentos, incluindo os nulos.
select f.fun_nome as 'Funcionario', d.dep_descricao as 'Departamento'
from funcionario f left join departamento d
on f.dep_id = d.dep_id
union 
select f.fun_nome as 'Funcionario', d.dep_descricao as 'Departamento'
from departamento d left join funcionario f
on d.dep_id = f.dep_id
where f.dep_id is null;

-- 20.7  Listar clientes que não têm pedidos e pedidos que não têm clientes
select c.cli_nome, c.cli_codigo as ' Cliente sem Pedido'
from cliente c
left join pedido p on c.cli_codigo = p.cli_codigo
where p.ped_numero is null
union
select cli_nome, p.cli_codigo as 'Pedido Sem Cliente'
from pedido p
right join cliente c on p.cli_codigo = c.cli_codigo
where c.cli_codigo is null;
