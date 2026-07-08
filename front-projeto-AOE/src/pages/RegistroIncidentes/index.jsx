import React, { useState } from 'react';
// Feat: Importando o Toastify e o CSS dele
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

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

  // Feat: Estado para gerenciar o botão de carregamento
  const [loading, setLoading] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    // ==========================================
    // VALIDAÇÕES MANUAIS COM TOASTIFY
    // ==========================================
    if (!formData.plataforma.trim()) {
      toast.warning('O nome da plataforma é obrigatório!');
      return;
    }

    if (!formData.data) {
      toast.warning('A data do ocorrido é obrigatória!');
      return;
    }

    if (!formData.hora) {
      toast.warning('A hora do ocorrido é obrigatória!');
      return;
    }

    if (!formData.descricao.trim()) {
      toast.warning('A descrição detalhada do fato é obrigatória!');
      return;
    }

    if (!formData.acoesImediatas.trim()) {
      toast.warning('As ações imediatas tomadas são obrigatórias!');
      return;
    }
    // ==========================================

    console.log('Enviando dados via POST para o Spring Boot:', formData);
    setLoading(true);

    try {
      // Aqui entrará o fetch/axios para enviar ao Backend
      // ex: await axios.post('http://localhost:8080/api/incidentes', formData)
      
      // Simulando um tempo de resposta do servidor (remova quando integrar com o backend real)
      await new Promise(resolve => setTimeout(resolve, 800));
      
      // Trocando o alert() pelo Toast de Sucesso
      toast.success('Incidente registrado com sucesso');
      
      // Limpa o formulário após o envio
      setFormData({
        gravidade: 'Baixa',
        data: '',
        hora: '',
        plataforma: '',
        descricao: '',
        acoesImediatas: ''
      });
      
    } catch (error) {
      console.error('Erro ao salvar o incidente:', error);
      toast.error('Erro ao conectar com o servidor para salvar o registro.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="incidentes-page">
      {/* Container obrigatório para exibir as notificações */}
      <ToastContainer position="top-right" autoClose={4000} theme="colored" />

      <h2>Registro de Incidentes Operacionais (HSE)</h2>
      <p>Formulário crítico para reporte imediato de anomalias ou acidentes em plataformas offshore.</p>

      {/* noValidate impede o navegador de mostrar aquelas bolhas nativas brancas de erro */}
      <form onSubmit={handleSubmit} className="form-incidente" noValidate>
        <div className="form-group">
          <label htmlFor="plataforma">Plataforma:</label>
          <input 
            type="text" 
            id="plataforma" 
            name="plataforma" 
            value={formData.plataforma} 
            onChange={handleChange} 
            placeholder="Ex: P-52, Atlantic-I" 
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
          />
        </div>

        <button type="submit" className="btn-submit" disabled={loading}>
          {loading ? 'Enviando...' : 'Enviar Relatório HSE'}
        </button>
      </form>
    </div>
  );
}