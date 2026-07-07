import React from 'react';
import { Link } from 'react-router-dom'; // Adicione essa importação
import './style.css';

export default function Header() {
  return (
    <header className="main-header">
      <div className="header-container">
        <div className="logo">
          <h1>Atlantic Offshore Energy</h1>
          <span className="subtitle">Portal Corporativo</span>
        </div>
        <nav className="nav-menu">
          <ul>
            {/* Trocamos 'href' por 'to' e 'a' por 'Link' */}
            <li><Link to="/">Home</Link></li>
            <li><Link to="/quem-somos">Quem Somos</Link></li>
            <li><Link to="/incidentes">Registro de Incidentes</Link></li>
            <li><Link to="/manutencao">Solicitar Manutenção</Link></li>
            <li><Link to="/producao">Produção Diária</Link></li>
            <li><Link to="/escala">Escala de Tripulação</Link></li>
            <li><Link to="/contato">Contato/Emergência</Link></li>
          </ul>
        </nav>
      </div>
    </header>
  );
}