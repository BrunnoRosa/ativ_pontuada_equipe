import React, { useState } from 'react';
import './style.css'; // Certifique-se de que o CSS abaixo esteja neste arquivo

//Importando o ajuste do caminho relativo da pasta services conforme a estrutura do Front
import { criarOrdemServico } from '../../services';

export default function SolicitacaoManutencao() {
  // Estado para capturar todos os campos do formulário
  const [formData, setFormData] = useState({
    equipamentoId: '',
    criticidade: '',
    descricaoFalha: ''
  });

  const [loading, setLoading] = useState(false); //feat:Inserindo "loading" para os carregamentos do site

  // Atualiza o estado conforme o usuário digita
  const handleChange = (e) => {
    const { name, value } = e.target;
    // Este log ajuda a provar que o React está capturando a sua digitação!
    console.log(`Campo atualizado: ${name} -> ${value}`);
    setFormData({ ...formData, [name]: value });
  };

  // Lida com o envio do formulário
  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log('Enviando dados via POST para o Spring Boot:', formData);
    
    // Aqui entrará o fetch/axios para enviar ao Backend
    // ex: axios.post('http://localhost:8080/api/manutencao', formData)

    setLoading(true);

    //feat:inserindo a chamada para o Back-End

    try{
      //Chamada assíncrona ao Back-End

      const respostaBack = await criarOrdemServico(formData);

      console.log('Resposta do Spring Boot:', respostaBack);


      alert(`Ordem de serviço n° ${respostaBack.id || ''} registrada com sucesso no banco de dados!`);

      // Limpa o formulário após o envio
    setFormData({
      equipamentoId: '',
      criticidade: '',
      descricaoFalha: ''
    });

    }catch(error){
      // Se o servidor respondeu com status (400, 404, 500, etc.)
  if (error.response) {
    alert(`Erro do Servidor (${error.response.status}): ${error.response.data?.message || 'Dados inválidos'}`);
  } 
  // Se a requisição foi feita mas NENHUMA resposta voltou (Servidor fora ou CORS)
  else if (error.request) {
    alert('Não foi possível alcançar o servidor. Verifique se o Back-End está rodando na porta 8080.');
  } 
  // Outros erros de código
  else {
    alert(`Erro na requisição: ${error.message}`);
  }
    }finally{
      setLoading(false);
    }
    
  };

  return (
    <main className='solicitacao-manutencao-page'>
      <section className='solicitacao-manutencao-card'>
        <h1>Abertura de Ordem de Serviço</h1>
        <p>
          Use este formulário para abrir ordens de serviço em equipamentos como turbinas de compressão,
          brocas de perfuração e geradores. Informe o ID do equipamento, o nível de criticidade e a descrição
          da falha para que nossa equipe possa agir rapidamente.
        </p>

        <form onSubmit={handleSubmit} className='solicitacao-form'>
          <div className="form-group">
            <label htmlFor='equipamentoId'>ID do Equipamento:</label>
            <input
              id='equipamentoId'
              name='equipamentoId'
              type='text'
              value={formData.equipamentoId}
              onChange={handleChange}
              placeholder='Ex: TC-1023'
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor='criticidade'>Criticidade:</label>
            <select 
              id='criticidade' 
              name='criticidade'
              value={formData.criticidade}
              onChange={handleChange}
              required
            >
              <option value=''>Selecione a criticidade</option>
              <option value='BAIXA'>Baixa</option>
              <option value='MEDIA'>Média</option>
              <option value='ALTA'>Alta</option>
              <option value="CRITICA">Crítica</option>{/*Feat:Adicionando a Criticidade "crítica" */}
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
              required
            />
          </div>

          <button type='submit' className="btn-submit" disabled={loading}>{loading ? 'Enviando...' : 'Enviar Ordem de Serviço'}</button> {/*Feat:Adicionando o 'loading' de carregamento ao clicar no botão */}
        </form>
      </section>
    </main>
  );
}