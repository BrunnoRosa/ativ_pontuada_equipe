import React, { useState, useEffect } from 'react';
import './style.css';

export default function MonitoramentoProducao() {
  // Estado que armazenará os dados vindos da API
  const [producoes, setProducoes] = useState([]);

  // Consome a API ao carregar a página
  useEffect(() => {
    fetch('http://localhost:8080/api/producao')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Erro ao buscar os dados da API.');
        }
        return response.json();
      })
      .then((data) => {
        setProducoes(data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div className="producao-page">
      <h2>Monitoramento de Produção Diária</h2>
      <p>
        Dados consolidados em tempo real extraídos diretamente do sistema de
        telemetria das plataformas.
      </p>

      <div className="table-container">
        <table className="producao-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Plataforma / Unidade</th>
              <th>Extração de Petróleo (Barris)</th>
              <th>Extração de Gás Natural (m³)</th>
              <th>Status da Meta</th>
            </tr>
          </thead>

          <tbody>
            {producoes.length > 0 ? (
              producoes.map((item) => (
                <tr key={item.id}>
                  <td>{item.id}</td>
                  <td className="plataforma-nome">{item.plataforma}</td>
                  <td>{item.petroleoBarris.toLocaleString()} bbl</td>
                  <td>{item.gasMetrosCubicos.toLocaleString()} m³</td>
                  <td>
                    <span
                      className={`status-badge ${
                        item.metaAtingida ? 'meta-ok' : 'meta-atraso'
                      }`}
                    >
                      {item.metaAtingida
                        ? 'Meta Atingida'
                        : 'Abaixo da Meta'}
                    </span>
                  </td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="5">Nenhum registro encontrado.</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
}