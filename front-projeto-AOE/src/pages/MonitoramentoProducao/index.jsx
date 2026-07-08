import React, { useState, useEffect } from 'react';
import './style.css';

export default function MonitoramentoProducao() {
  // Estado para armazenar os registros que virão do banco de dados MySQL via API
  const [producoes, setProducoes] = useState([]);

  // Simulando o consumo da API (GET) com useEffect e dados mockados estruturados
  useEffect(() => {
    // Quando o backend estiver pronto, aqui entrará o fetch/axios:
    // fetch('http://localhost:8080/api/producao').then(res => res.json()).then(data => setProducoes(data))

    const dadosMockadosDoBackend = [
      { id: 1, plataforma: 'Atlantic-I (Bacia de Santos)', petroleoBarris: 45000, gasMetrosCubicos: 12000, metaAtingida: true },
      { id: 2, plataforma: 'Atlantic-II (Bacia de Campos)', petroleoBarris: 38000, gasMetrosCubicos: 9500, metaAtingida: false },
      { id: 3, plataforma: 'P-52 Extração', petroleoBarris: 62000, gasMetrosCubicos: 18500, metaAtingida: true },
      { id: 4, plataforma: 'P-58 Norte', petroleoBarris: 29000, gasMetrosCubicos: 7000, metaAtingida: false }
    ];

    setProducoes(dadosMockadosDoBackend);
  }, []);

  return (
    <div className="producao-page">
      <h2>Monitoramento de Produção Diária</h2>
      <p>Dados consolidados em tempo real extraídos diretamente do sistema de telemetria das plataformas.</p>

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
            {producoes.map((item) => (
              <tr key={item.id}>
                <td>{item.id}</td>
                <td className="plataforma-nome">{item.plataforma}</td>
                <td>{item.petroleoBarris.toLocaleString()} bbl</td>
                <td>{item.gasMetrosCubicos.toLocaleString()} m³</td>
                <td>
                  <span className={`status-badge ${item.metaAtingida ? 'meta-ok' : 'meta-atraso'}`}>
                    {item.metaAtingida ? 'Meta Atingida' : 'Abaixo da Meta'}
                  </span>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}