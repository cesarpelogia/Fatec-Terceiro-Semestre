fetch('http://localhost:8080/cerveja')
    .then(response => response.json())
    .then(cervejas => {
        const tabela = document.getElementById('tabela-cervejas');

        tabela.innerHTML = '';

        cervejas.forEach(cerveja => {
            const linha = document.createElement('tr');

            linha.innerHTML = `
                <td>${cerveja.marca}</td>
                <td>${cerveja.nome}</td>
                <td>${cerveja.quantidade}ml</td>
                <td>R$ ${cerveja.preco.toFixed(2)}</td>
                <td>
                    <button onclick="editarCerveja(this)">Editar</button>
                    <button onclick="deletarCerveja(this)">Deletar</button>
                </td>
            `;
            tabela.appendChild(linha);
        });
    })
    .catch(error => console.error('Erro ao carregar cervejas:', error));


    