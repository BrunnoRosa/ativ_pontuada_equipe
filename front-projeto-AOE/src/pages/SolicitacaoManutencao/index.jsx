import './style.css'

export default function SolicitacaoManutencao() {
  return (
    <main className='solicitacao-manutencao-page'>
      <section className='solicitacao-manutencao-card'>
        <h1>Abertura de Ordem de Serviço</h1>
        <p>
          Use este formulário para abrir ordens de serviço em equipamentos como turbinas de compressão,
          brocas de perfuração e geradores. Informe o ID do equipamento, o nível de criticidade e a descrição
          da falha para que nossa equipe possa agir rapidamente.
        </p>

        <form className='solicitacao-form'>
          <label htmlFor='equipamentoId'>ID do Equipamento</label>
          <input
            id='equipamentoId'
            name='equipamentoId'
            type='text'
            placeholder='Ex: TC-1023'
          />

          <label htmlFor='criticidade'>Criticidade</label>
          <select id='criticidade' name='criticidade'>
            <option value=''>Selecione a criticidade</option>
            <option value='alta'>Alta</option>
            <option value='media'>Média</option>
            <option value='baixa'>Baixa</option>
          </select>

          <label htmlFor='descricaoFalha'>Descrição da Falha</label>
          <textarea
            id='descricaoFalha'
            name='descricaoFalha'
            rows='6'
            placeholder='Descreva o problema observado no equipamento...'
          />

          <button type='submit'>Enviar Ordem de Serviço</button>
        </form>
      </section>
    </main>
  )
}