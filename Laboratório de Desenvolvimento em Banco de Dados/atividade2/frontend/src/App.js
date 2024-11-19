import React, { useEffect, useState } from "react";
import './App.css';

const App = () => {
  const [data, setData] = useState([]);
  const [isModalOpen, setModalOpen] = useState(false);
  const [modalData, setModalData] = useState({
    id: null,
    marca: '',
    nome: '',
    qnt: '',
    preco: ''
  });

  useEffect(() => {
    const getCerveja = async () => {
      try {
        const response = await fetch('http://localhost:8080/cerveja');
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data = await response.json();
        setData(data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };
    getCerveja();
  }, []);

  const openModal = (item = null) => {
    if (item) {
      setModalData(item); // Preenche os campos com os dados atuais
    } else {
      setModalData({
        id: null,
        marca: '',
        nome: '',
        qnt: '',
        preco: ''
      });
    }
    setModalOpen(true);
  };

  const closeModal = () => {
    setModalOpen(false);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
  
    if (modalData.id) {
      const updatedBeer = {
        ...modalData,
        qnt: parseInt(modalData.qnt),
        preco: parseFloat(modalData.preco)
      };
      fetch(`http://localhost:8080/cerveja/${modalData.id}`, {
        method: 'PUT',
        body: JSON.stringify(updatedBeer),
        headers: {
          'Content-Type': 'application/json',
        },
      }).then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      }).then(data => {
        setData(prevData => prevData.map(item => item.id === modalData.id ? data : item));
        closeModal();
      }).catch(error => {
        console.error('Erro ao atualizar a cerveja:', error);
      });
    } else {
      const newBeer = {
        marca: modalData.marca,
        nome: modalData.nome,
        qnt: parseInt(modalData.qnt),
        preco: parseFloat(modalData.preco),
      };
      fetch('http://localhost:8080/cerveja', {
        method: 'POST',
        body: JSON.stringify(newBeer),
        headers: {
          'Content-Type': 'application/json',
        },
      }).then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      }).then(data => {
        setData(prevData => [...prevData, data]);
        closeModal();
      }).catch(error => {
        console.error('Erro ao adicionar a cerveja:', error);
      });
    }
  };
  
  const deleteCerveja = (id) => {
    if (window.confirm('Tem certeza que deseja excluir esta cerveja?')) {
      fetch(`http://localhost:8080/cerveja/${id}`, { method: 'DELETE' })
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          // Não tente converter a resposta para JSON, pois DELETE geralmente não retorna um corpo
          setData(prevData => prevData.filter(item => item.id !== id));
        })
        .catch(error => {
          console.error('Erro ao excluir a cerveja:', error);
        });
    }
  };

  const formatPrice = (price) => {
    return `R$ ${price.toFixed(2).replace('.', ',')}`;
  };

  return (
    <div className="app-container">
      <h1 className="title">Cervejaria Pelogia</h1>
      <button className="add-button" onClick={() => openModal()}>Adicionar Cerveja</button>

      {/* Modal */}
      {isModalOpen && (
        <div className="modal-overlay">
          <div className="modal-container">
            <h2>{modalData.id ? 'Editar Cerveja' : 'Adicionar Cerveja'}</h2>
            <form onSubmit={handleSubmit}>
              <label>Marca</label>
              <input
                type="text"
                value={modalData.marca}
                onChange={(e) => setModalData({ ...modalData, marca: e.target.value })}
                required
              />
              <label>Nome</label>
              <input
                type="text"
                value={modalData.nome}
                onChange={(e) => setModalData({ ...modalData, nome: e.target.value })}
                required
              />
              <label>Quantidade</label>
              <input
                type="number"
                value={modalData.qnt}
                onChange={(e) => setModalData({ ...modalData, qnt: e.target.value })}
                required
              />
              <label>Preço</label>
              <input
                type="number"
                step="0.01"
                value={modalData.preco}
                onChange={(e) => setModalData({ ...modalData, preco: e.target.value })}
                required
              />
              <button className="save-button" type="submit">Salvar</button>
              <button className="cancel-button" type="button" onClick={closeModal}>Cancelar</button>
            </form>
          </div>
        </div>
      )}

      <table className="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Marca</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Preço</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {data.map(item => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.marca}</td>
              <td>{item.nome}</td>
              <td>{item.qnt}</td>
              <td>{formatPrice(item.preco)}</td>
              <td className="actions">
                <button className="edit-button" onClick={() => openModal(item)}>Editar</button>
                <button className="delete-button" onClick={() => deleteCerveja(item.id)}>Excluir</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default App;