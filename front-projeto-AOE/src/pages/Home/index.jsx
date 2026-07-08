import React from 'react';
import './style.css';

export default function Home() {
  // Exemplo de dado mockado para os indicadores (pode virar dinâmico no futuro)
  const indicadores = {
    diasSemAcidentes: 450,
    plataformasAtivas: 12,
    producaoAtualBarris: "245.000 / dia"
  };

  return (
    <div className="home-page">
      <section className="hero-section">
        <h2>Bem-vindo ao Portal de Operações</h2>
        <p>Monitoramento, Gestão de Ativos e Segurança Offshore em Tempo Real.</p>
      </section>

      {/* Grid de Indicadores de Segurança e Operação */}
      <section className="dashboard-cards">
        <div className="card hse-card">
          <h3>Indicador de Segurança</h3>
          <p className="card-value">{indicadores.diasSemAcidentes} Dias</p>
          <span>Sem acidentes de trabalho registrados</span>
        </div>

        <div className="card operational-card">
          <h3>Plataformas Ativas</h3>
          <p className="card-value">{indicadores.plataformasAtivas}</p>
          <span>Unidades operando na costa brasileira</span>
        </div>

        <div className="card production-card">
          <h3>Extração Estimada</h3>
          <p className="card-value">{indicadores.producaoAtualBarris}</p>
          <span>Média corporativa consolidada</span>
        </div>
      </section>

      {/* Seção do Mapa de Localização */}
      <section className="map-section">
        <h3>Mapa de Localização das Plataformas Ativas</h3>
        <div className="map-placeholder">
          {/* Aqui futuramente pode entrar uma biblioteca de mapas ou imagem representativa das bacias */}
          <p>[ Espaço Reservado para o Mapa das Plataformas - Bacia de Santos e Campos ]</p>
        </div>
      </section>
    </div>
  );
}