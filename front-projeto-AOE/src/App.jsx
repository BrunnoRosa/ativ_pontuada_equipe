import './App.css'; // Certifique-se de que o CSS ajustado esteja aqui ou no index.css
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

// Importando os componentes globais que você criou
import Header from './components/Header';
import Footer from './components/Footer';

// Importando as SUAS páginas
import Home from './pages/Home';
import RegistroIncidentes from './pages/RegistroIncidentes';
import MonitoramentoProducao from './pages/MonitoramentoProducao';
import SolicitacaoManutencao from './pages/SolicitacaoManutencao';
import QuemSomos from './pages/QuemSomos'; 

// IMPORTANDO AS PÁGINAS NOVAS DA SUA DUPLA (As versões reais agora!)
import EscalaTripulacao from './pages/EscalaTripulacao';
import ContatoEmergencia from './pages/ContatoEmergencia';

// Nota: As funções falsas (const EscalaTripulacao e const ContatoEmergencia) 
// foram apagadas daqui para que o React use os arquivos reais importados acima.

export default function App() {
  return (
    <Router>
      {/* O Header fica fixo no topo de todas as páginas */}
      <Header />

      {/* O main usa a classe flexível do CSS para empurrar o footer para o rodapé */}
      <main className="content-container">
        <Routes>
          {/* Suas Páginas */}
          <Route path="/" element={<Home />} />
          <Route path="/incidentes" element={<RegistroIncidentes />} />
          <Route path="/producao" element={<MonitoramentoProducao />} />
          <Route path="/quem-somos" element={<QuemSomos />} />
          <Route path="/manutencao" element={<SolicitacaoManutencao />} />
          
          {/* As rotas agora chamam os componentes reais */}
          <Route path="/escala" element={<EscalaTripulacao />} />
          <Route path="/contato" element={<ContatoEmergencia />} />
        </Routes>
      </main>

      {/* O Footer fica fixo no rodapé de todas as páginas */}
      <Footer />
    </Router>
  );
}