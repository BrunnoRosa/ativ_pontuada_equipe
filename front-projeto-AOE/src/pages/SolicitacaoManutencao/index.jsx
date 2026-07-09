import React, { useState } from 'react';

// Feat: Importando o Toastify e seu CSS

import { ToastContainer, toast } from 'react-toastify';

import 'react-toastify/dist/ReactToastify.css';



import './style.css';

import { criarOrdemServico } from '../../services';



export default function SolicitacaoManutencao() {

  const [formData, setFormData] = useState({

    equipamentoId: '',

    criticidade: '',

    descricaoFalha: ''

  });



  const [loading, setLoading] = useState(false);



  const handleChange = (e) => {

    const { name, value } = e.target;

    console.log(`Campo atualizado: ${name} -> ${value}`);

    setFormData({ ...formData, [name]: value });

  };



  const handleSubmit = async (e) => {

    e.preventDefault();

   

    // ==========================================

    // VALIDAÇÕES OBRIGATÓRIAS COM TOASTIFY

    // ==========================================

    if (!formData.equipamentoId.trim()) {

      toast.warning('O ID do Equipamento é obrigatório!');

      return;

    }

   

    if (!formData.criticidade) {

      toast.warning('A Criticidade não pode ficar vazia. Selecione uma opção!');

      return;

    }



    if (!formData.descricaoFalha.trim()) {

      toast.warning('A Descrição da Falha é obrigatória!');

      return;

    }

    // ==========================================



    console.log('Enviando dados via POST para o Spring Boot:', formData);

    setLoading(true);



    try {

      const respostaBack = await criarOrdemServico(formData);

      console.log('Resposta do Spring Boot:', respostaBack);



      // Trocando o alert pelo toast de sucesso

      toast.success(`Ordem de serviço n° ${respostaBack.id || ''} registrada com sucesso!`);



      setFormData({

        equipamentoId: '',

        criticidade: '',

        descricaoFalha: ''

      });



    } catch(error) {
      console.group('❌ [DEBUG ERRO MANUTENÇÃO]');
      
      if (error.response) {
        // O servidor respondeu, mas com status de erro (400, 404, 500)
        console.error('Status do Servidor:', error.response.status);
        console.error('Resposta do Servidor:', error.response.data);
        toast.error(`Erro do Servidor (${error.response.status}): ${error.response.data?.message || 'Dados inválidos'}`);
      } 
      else if (error.request) {
        // A requisição foi enviada mas ninguém respondeu (ERR_CONNECTION_REFUSED)
        console.error('Falha de Conexão: Nenhuma resposta recebida.');
        console.error('URL Tentada:', error.config?.url);
        console.error('Base URL:', error.config?.baseURL);
        
        toast.error('Servidor desconectado! Verifique se o Back-End (Spring Boot) está rodando na porta 8080.');
      } 
      else {
        // Erro na montagem da requisição no JavaScript
        console.error('Erro de Configuração:', error.message);
        toast.error(`Erro na requisição: ${error.message}`);
      }
      
      console.groupEnd();

    } finally {

      setLoading(false);

    }

  };



  return (

    <main className='solicitacao-manutencao-page'>

      {/* Componente que renderiza os balões flutuantes na tela */}

      <ToastContainer position="top-right" autoClose={4000} theme="colored" />



      <section className='solicitacao-manutencao-card'>

        <h1>Abertura de Ordem de Serviço</h1>

        <p>

          Use este formulário para abrir ordens de serviço em equipamentos como turbinas de compressão,

          brocas de perfuração e geradores. Informe o ID do equipamento, o nível de criticidade e a descrição

          da falha para que nossa equipe possa agir rapidamente.

        </p>



        {/* Adicionado 'noValidate' para desativar as mensagens brancas feias do navegador */}

        <form onSubmit={handleSubmit} className='solicitacao-form' noValidate>

          <div className="form-group">

            <label htmlFor='equipamentoId'>ID do Equipamento:</label>

            <input

              id='equipamentoId'

              name='equipamentoId'

              type='text'

              value={formData.equipamentoId}

              onChange={handleChange}

              placeholder='Ex: TC-1023'

            />

          </div>



          <div className="form-group">

            <label htmlFor='criticidade'>Criticidade:</label>

            <select

              id='criticidade'

              name='criticidade'

              value={formData.criticidade}

              onChange={handleChange}

            >

              <option value=''>Selecione a criticidade</option>

              <option value='BAIXA'>Baixa</option>

              <option value='MEDIA'>Média</option>

              <option value='ALTA'>Alta</option>

              <option value="CRITICA">Crítica</option>

            </select>

          </div>



          <div className="form-group">

            <label htmlFor='descricaoFalha'>Descrição da Falha:</label>

            <textarea

              id='descricaoFalha'

              name='descricaoFalha'

              value={formData.descricaoFalha}

              onChange={handleChange}

              rows='6'

              placeholder='Descreva o problema observado no equipamento...'

            />

          </div>



          <button type='submit' className="btn-submit" disabled={loading}>

            {loading ? 'Enviando...' : 'Enviar Ordem de Serviço'}

          </button>

        </form>

      </section>

    </main>

  );

} 

