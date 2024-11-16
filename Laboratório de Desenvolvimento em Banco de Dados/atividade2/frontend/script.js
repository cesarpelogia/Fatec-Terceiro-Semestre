// URL base para as requisições
const baseUrl = 'http://localhost:8080/cerveja';

// Função para carregar as cervejas do backend
async function carregarCervejas() {
    try {
        const response = await fetch(baseUrl);
        if (!response.ok) throw new Error('Erro ao carregar cervejas');
        const cervejas = await response.json();

        const listaCervejas = document.getElementById('listaCervejas');
        listaCervejas.innerHTML = ''; // Limpa a lista antes de popular

        cervejas.forEach(cerveja => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${cerveja.id}</td>
                <td>${cerveja.marca}</td>
                <td>${cerveja.nome}</td>
                <td>${cerveja.qnt}</td>
                <td>${cerveja.preco}</td>
                <td>
                    <button onclick="editarCerveja(${cerveja.id})">Editar</button>
                    <button onclick="excluirCerveja(${cerveja.id})">Excluir</button>
                </td>
            `;
            listaCervejas.appendChild(row);
        });
    } catch (error) {
        console.error('Erro ao carregar as cervejas:', error);
        alert('Não foi possível carregar as cervejas.');
    }
}

// Função para adicionar uma nova cerveja
async function adicionarCerveja() {
    const novaCerveja = {
        marca: prompt('Digite a marca da cerveja:'),
        nome: prompt('Digite o nome da cerveja:'),
        qnt: parseFloat(prompt('Digite a quantidade:')),
        preco: parseFloat(prompt('Digite o preço:')),
    };

    try {
        const response = await fetch(baseUrl, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(novaCerveja),
        });

        if (response.ok) {
            alert('Cerveja adicionada com sucesso!');
            carregarCervejas();
        } else {
            throw new Error('Erro ao adicionar cerveja');
        }
    } catch (error) {
        console.error('Erro ao adicionar a cerveja:', error);
        alert('Não foi possível adicionar a cerveja.');
    }
}

// Função para editar uma cerveja existente
async function editarCerveja(id) {
    const marca = prompt('Digite a nova marca da cerveja:');
    const nome = prompt('Digite o novo nome da cerveja:');
    const qnt = parseFloat(prompt('Digite a nova quantidade:'));
    const preco = parseFloat(prompt('Digite o novo preço:'));

    const cervejaAtualizada = { id, marca, nome, qnt, preco };

    try {
        const response = await fetch(`${baseUrl}/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(cervejaAtualizada),
        });

        if (response.ok) {
            alert('Cerveja atualizada com sucesso!');
            carregarCervejas();
        } else {
            throw new Error('Erro ao atualizar cerveja');
        }
    } catch (error) {
        console.error('Erro ao atualizar a cerveja:', error);
        alert('Não foi possível atualizar a cerveja.');
    }
}

// Função para excluir uma cerveja
async function excluirCerveja(id) {
    if (!confirm('Tem certeza que deseja excluir esta cerveja?')) return;

    try {
        const response = await fetch(`${baseUrl}/${id}`, { method: 'DELETE' });

        if (response.ok) {
            alert('Cerveja excluída com sucesso!');
            carregarCervejas();
        } else {
            throw new Error('Erro ao excluir cerveja');
        }
    } catch (error) {
        console.error('Erro ao excluir a cerveja:', error);
        alert('Não foi possível excluir a cerveja.');
    }
}

// Carrega as cervejas ao abrir a página
carregarCervejas();
