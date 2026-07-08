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

// Páginas da sua DUPLA (Criamos componentes temporários aqui para o código não quebrar)
const QuemSomos = () => <div style={{ padding: '40px' }}><h2>Página Quem Somos</h2></div>;
const SolicitacaoManutencao = () => <div style={{ padding: '40px' }}><h2>Página Solicitação de Manutenção</h2></div>;
const EscalaTripulacao = () => <div style={{ padding: '40px' }}><h2>Página Escala de Tripulação</h2></div>;
const ContatoEmergencia = () => <div style={{ padding: '40px' }}><h2>Página Contato de Emergência</h2></div>;

export default function App() {
  return (
    <Router>
      {/* Criamos essa div para envelopar todo o site */}
      <div className="app-container">
        <Header />

        {/* Tiramos aquele 'style' em linha daqui e vamos controlar pelo CSS */}
        <main className="content-container">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/incidentes" element={<RegistroIncidentes />} />
            <Route path="/producao" element={<MonitoramentoProducao />} />
            {/* ... as outras rotas permanecem iguais ... */}
          </Routes>
        </main>

        <Footer />
      </div>
    </Router>
  );
}