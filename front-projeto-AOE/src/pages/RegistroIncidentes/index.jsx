import React, { useState } from 'react';
import './style.css';

export default function RegistroIncidentes() {
  // Estado para capturar todos os campos do formulário exigidos no escopo
  const [formData, setFormData] = useState({
    gravidade: 'Baixa',
    data: '',
    hora: '',
    plataforma: '',
    descricao: '',
    acoesImediatas: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Enviando dados via POST para o Spring Boot:', formData);
    
    // Aqui entrará o fetch/axios para enviar ao Backend
    // ex: axios.post('http://localhost:8080/api/incidentes', formData)
    
    alert('Incidente registrado com sucesso no banco de dados (MySQL)!');
    
    // Limpa o formulário após o envio
    setFormData({
      gravidade: 'Baixa',
      data: '',
      hora: '',
      plataforma: '',
      descricao: '',
      acoesImediatas: ''
    });
  };

  return (
    <div className="incidentes-page">
      <h2>Registro de Incidentes Operacionais (HSE)</h2>
      <p>Formulário crítico para reporte imediato de anomalias ou acidentes em plataformas offshore.</p>

      <form onSubmit={handleSubmit} className="form-incidente">
        <div className="form-group">
          <label htmlFor="plataforma">Plataforma:</label>
          <input 
            type="text" 
            id="plataforma" 
            name="plataforma" 
            value={formData.plataforma} 
            onChange={handleChange} 
            placeholder="Ex: P-52, Atlantic-I" 
            required 
          />
        </div>

        <div className="form-row">
          <div className="form-group">
            <label htmlFor="data">Data do Ocorrido:</label>
            <input 
              type="date" 
              id="data" 
              name="data" 
              value={formData.data} 
              onChange={handleChange} 
              required 
            />
          </div>

          <div className="form-group">
            <label htmlFor="hora">Hora do Ocorrido:</label>
            <input 
              type="time" 
              id="hora" 
              name="hora" 
              value={formData.hora} 
              onChange={handleChange} 
              required 
            />
          </div>
        </div>

        <div className="form-group">
          <label htmlFor="gravidade">Gravidade:</label>
          <select 
            id="gravidade" 
            name="gravidade" 
            value={formData.gravidade} 
            onChange={handleChange}
          >
            <option value="Baixa">Baixa (Anomalia Operacional)</option>
            <option value="Média">Média (Incidente sem Afastamento)</option>
            <option value="Alta">Alta (Acidente com Afastamento / Impacto Ambiental)</option>
            <option value="Crítica">Crítica (Emergência Geral)</option>
          </select>
        </div>

        <div className="form-group">
          <label htmlFor="descricao">Descrição Detalhada do Fato:</label>
          <textarea 
            id="descricao" 
            name="descricao" 
            value={formData.descricao} 
            onChange={handleChange} 
            placeholder="Descreva minuciosamente o que ocorreu..." 
            rows="4" 
            required 
          />
        </div>

        <div className="form-group">
          <label htmlFor="acoesImediatas">Ações Imediatas Tomadas:</label>
          <textarea 
            id="acoesImediatas" 
            name="acoesImediatas" 
            value={formData.acoesImediatas} 
            onChange={handleChange} 
            placeholder="Quais foram as primeiras barreiras e ações de contenção?" 
            rows="3" 
            required 
          />
        </div>

        <button type="submit" className="btn-submit">Enviar Relatório HSE</button>
      </form>
    </div>
  );
}