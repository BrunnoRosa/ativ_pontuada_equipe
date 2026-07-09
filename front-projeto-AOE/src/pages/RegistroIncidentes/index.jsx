import React, { useState, useEffect } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import axios from 'axios'; 

import './style.css';

export default function RegistroIncidentes() {
  // Mantendo o estado com 'data' e 'hora' separados para facilitar a exibição visual nos inputs
  const [formData, setFormData] = useState({
    gravidade: 'BAIXA', // Inicializado em maiúsculo para bater com o Enum Criticidade do seu Back
    data: '',
    hora: '',
    plataforma: '',
    descricao: '',
    acoesImediatas: ''
  });

  const [loading, setLoading] = useState(false);

  // AUTOMAÇÃO: Preenche os inputs de Data e Hora assim que o componente carrega na tela
  useEffect(() => {
    preencherDataHoraAtual();
  }, []);

  const preencherDataHoraAtual = () => {
    const agora = new Date();
    
    // Captura a data local no formato YYYY-MM-DD
    const ano = agora.getFullYear();
    const mes = String(agora.getMonth() + 1).padStart(2, '0');
    const dia = String(agora.getDate()).padStart(2, '0');
    const dataAtual = `${ano}-${mes}-${dia}`;

    // Captura a hora local no formato HH:MM
    const horas = String(agora.getHours()).padStart(2, '0');
    const minutos = String(agora.getMinutes()).padStart(2, '0');
    const horaAtual = `${horas}:${minutos}`;

    setFormData(prev => ({
      ...prev,
      data: dataAtual,
      hora: horaAtual
    }));
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    // Validando os campos locais do formulário
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

    setLoading(true);

    // ======================================================================
    // MONTAGEM DO OBJETO ADAPTADO PARA O SEU BACK-END (IncidentesRequestDTO)
    // ======================================================================
    const dadosParaOBack = {
      gravidade: formData.gravidade, // Vai enviar como string ex: "BAIXA", "MEDIA", "ALTA", "CRITICA"
      dataHora: `${formData.data} ${formData.hora}`, // Junta as variáveis do Front. Ex final: "2026-07-08 21:00" (16 caracteres, cumpre o min=11)
      plataforma: formData.plataforma,
      descricao: formData.descricao,
      acaoImediata: formData.acoesImediatas // Mapeado para 'acaoImediata' (no singular) conforme seu DTO
    };

    try {
      // Enviando os dados formatados para o seu endpoint existente
      const response = await axios.post('http://localhost:8080/api/incidentes', dadosParaOBack);
      
      // Captura a mensagem de sucesso mapeada no seu ResponseEntity (Map.of("Mensagem", "..."))
      toast.success(response.data.Mensagem || 'Registro Realizado com Sucesso. ✅');
      
      // Reseta o formulário limpando os textos digitados
      setFormData({
        gravidade: 'BAIXA',
        data: '',
        hora: '',
        plataforma: '',
        descricao: '',
        acoesImediatas: ''
      });
      
      // Roda a automação novamente para que a data/hora fiquem prontas para o próximo registro
      preencherDataHoraAtual(); 
      
    } catch (error) {
      console.error('Erro na integração:', error);
      
      // Caso o seu Back-End recuse por alguma validação do @Valid (ex: tamanho menor que o esperado)
      if (error.response && error.response.data) {
        toast.error('Erro de validação no servidor. Verifique os dados inseridos.');
      } else {
        toast.error('Não foi possível conectar ao servidor Spring Boot.');
      }
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="incidentes-page">
      <ToastContainer position="top-right" autoClose={4000} theme="colored" />

      <h2>Registro de Incidentes Operacionais (HSE)</h2>
      <p>Formulário crítico para reporte imediato de anomalias ou acidentes em plataformas offshore.</p>

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
            {/* Opções configuradas exatamente com as strings esperadas pelo Enum Criticidade do Back */}
            <option value="BAIXA">Baixa (Anomalia Operacional)</option>
            <option value="MEDIA">Média (Incidente sem Afastamento)</option>
            <option value="ALTA">Alta (Acidente com Afastamento)</option>
            <option value="CRITICA">Crítica (Emergência Geral)</option>
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
          {loading ? 'Enviando ao servidor...' : 'Enviar Relatório HSE'}
        </button>
      </form>
    </div>
  );
}