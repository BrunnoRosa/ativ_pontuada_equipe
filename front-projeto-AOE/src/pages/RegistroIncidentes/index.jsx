import React, { useState, useEffect } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import axios from 'axios'; 

import './style.css';

export default function RegistroIncidentes() {
  const [formData, setFormData] = useState({
    gravidade: 'BAIXA', 
    data: '',
    hora: '',
    plataforma: '',
    descricao: '',
    acoesImediatas: ''
  });

  const [loading, setLoading] = useState(false);

  useEffect(() => {
    preencherDataHoraAtual();
  }, []);

  const preencherDataHoraAtual = () => {
    const agora = new Date();
    
    const ano = agora.getFullYear();
    const mes = String(agora.getMonth() + 1).padStart(2, '0');
    const dia = String(agora.getDate()).padStart(2, '0');
    const dataAtual = `${ano}-${mes}-${dia}`;

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
    
    if (!formData.plataforma.trim()) {
      toast.warning('O nome da plataforma é obrigatório!');
      return;
    }
    if (!formData.data || !formData.hora) {
      toast.warning('A data e a hora do ocorrido são obrigatórias!');
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

    const dadosParaOBack = {
      gravidade: formData.gravidade,
      dataHora: `${formData.data} ${formData.hora}`, 
      plataforma: formData.plataforma,
      descricao: formData.descricao,
      acaoImediata: formData.acoesImediatas
    };

    try {
      const response = await axios.post('http://localhost:8080/api/incidentes', dadosParaOBack);
      
      // ALTERAÇÃO AQUI: Como o novo Controller devolve o objeto criado (DTO), 
      // nós criamos a mensagem no Front e podemos até exibir o ID retornado!
      toast.success(`Incidente registrado com sucesso!`);
      
      setFormData({
        gravidade: 'BAIXA',
        data: '',
        hora: '',
        plataforma: '',
        descricao: '',
        acoesImediatas: ''
      });
      
      preencherDataHoraAtual(); 
      
    } catch (error) {
      console.error('Erro na integração:', error);
      
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