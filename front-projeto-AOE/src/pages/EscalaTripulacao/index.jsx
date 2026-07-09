import React, { useState, useEffect } from 'react';
import { listarTripulacao } from '../../services';
import './style.css';

export default function EscalaTripulacao() {
  // Estado que armazenará os dados vindos da API
  const [tripulacao, setTripulacao] = useState([]);

  // Consome a API usando Axios ao carregar a página
  useEffect(() => {
    listarTripulacao()
      .then((data) => {
        // O Axios já trata a resposta e nos entrega o JSON diretamente no 'data'
        setTripulacao(data);
      })
      .catch((error) => {
        console.error('Erro ao buscar os dados da tripulação via Axios:', error);
      });
  }, []);

  return (
    <div className="tripulacao-page">
      <h2>Escala de Embarque e Tripulação</h2>
      <p>
        Relação dos profissionais embarcados em cada plataforma, incluindo
        função exercida e período do regime de confinamento.
      </p>

      <div className="table-container">
        <table className="tripulacao-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Plataforma</th>
              <th>Funcionário</th>
              <th>Função</th>
              <th>Início do Regime</th>
              <th>Fim do Regime</th>
              <th>Escala</th>
            </tr>
          </thead>

          <tbody>
            {tripulacao.length > 0 ? (
              tripulacao.map((item) => (
                <tr key={item.id}>
                  <td>{item.id}</td>
                  <td>{item.plataforma}</td>
                  <td>{item.funcionario}</td>
                  <td>{item.funcao}</td>
                  <td>{item.dataInicio}</td>
                  <td>{item.dataFim}</td>
                  <td>{item.escala}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="7">Nenhum registro encontrado.</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
}