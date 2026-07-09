import React, { useState, useEffect } from 'react';
import './style.css';

// Importando a função específica do arquivo de serviços
import { obterProducaoDiaria } from '../../services'; // Ajuste o caminho relativo da pasta services se necessário

export default function MonitoramentoProducao() {
  // Estado que armazenará os dados vindos da API
  const [producoes, setProducoes] = useState([]);
  const [loading, setLoading] = useState(true);

  // Consome a API ao carregar a página
  useEffect(() => {
    const carregarDados = async () => {
      try {
        setLoading(true);
        const dados = await obterProducaoDiaria();
        setProducoes(dados);
      } catch (error) {
        console.error('Erro ao buscar os dados da API de Produção:', error);
      } finally {
        setLoading(false);
      }
    };

    carregarDados();
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
            {loading ? (
              <tr>
                <td colSpan="5">Carregando dados da produção...</td>
              </tr>
            ) : producoes.length > 0 ? (
              producoes.map((item) => (
                <tr key={item.id}>
                  <td>{item.id}</td>
                  <td className="plataforma-nome">{item.plataforma}</td>
                  <td>{(item.petroleoBarris ?? 0).toLocaleString()} bbl</td>
                  <td>{(item.gasMetrosCubicos ?? 0).toLocaleString()} m³</td>
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