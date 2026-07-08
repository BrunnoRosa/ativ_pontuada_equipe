import './App.css'
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

// Importando os componentes globais que você criou
import Header from './components/Header';
import Footer from './components/Footer';

// Importando as SUAS páginas
import Home from './pages/Home';
import RegistroIncidentes from './pages/RegistroIncidentes';
import MonitoramentoProducao from './pages/MonitoramentoProducao';

// Importando a página real que você acabou de criar
import SolicitacaoManutencao from './pages/SolicitacaoManutencao';

// Páginas da sua DUPLA (Criamos componentes temporários aqui para o código não quebrar)
const QuemSomos = () => <div style={{ padding: '40px' }}><h2>Página Quem Somos</h2></div>;
const EscalaTripulacao = () => <div style={{ padding: '40px' }}><h2>Página Escala de Tripulação</h2></div>;
const ContatoEmergencia = () => <div style={{ padding: '40px' }}><h2>Página Contato de Emergência</h2></div>;

export default function App() {
  return (
    <Router>
      {/* O Header fica fixo no topo de todas as páginas */}
      <Header />

      <main className="content-container" style={{ minHeight: '80vh', padding: '20px' }}>
        <Routes>
          {/* Suas Páginas */}
          <Route path="/" element={<Home />} />
          <Route path="/incidentes" element={<RegistroIncidentes />} />
          <Route path="/producao" element={<MonitoramentoProducao />} />

          {/* Páginas da sua Dupla (Rotas já configuradas) */}
          <Route path="/quem-somos" element={<QuemSomos />} />
          <Route path="/manutencao" element={<SolicitacaoManutencao />} />
          <Route path="/escala" element={<EscalaTripulacao />} />
          <Route path="/contato" element={<ContatoEmergencia />} />
        </Routes>
      </main>

      {/* O Footer fica fixo no rodapé de todas as páginas */}
      <Footer />
    </Router>
  );
}