import './style.css'
import imagemQuemSomos from '../../assets/img-quemsomos.jpg'

export default function QuemSomos() {
  return (
    <main className='quem-somos-page'>
      
      {/* === COLUNA DA ESQUERDA: Esta div é OBRIGATÓRIA para empacotar os textos === */}
      <div className="quem-somos-textos">
        
 <section className='quem-somos-intro'>
          <h1>Quem Somos</h1>
          <p>
            Oferecemos soluções de segurança offshore confiáveis e sustentáveis, unindo 
            excelência operacional e respeito absoluto ao ecossistema marinho.
          </p>
        </section>

        <section className='quem-somos-card'>
          <h2>Missão</h2>
          <p>
            Promover a excelência em segurança offshore, protegendo vidas, equipamentos 
            e os oceanos através de inovação, integridade e responsabilidade.
          </p>
        </section>

        <section className='quem-somos-card'>
          <h2>Foco em Segurança</h2>
          <p>
            Utilizamos processos rigorosos, treinamento especializado e alta tecnologia 
            para garantir os mais altos padrões de segurança e prevenção de incidentes.
          </p>
        </section>

        <section className='quem-somos-card'>
          <h2>Preservação Ambiental</h2>
          <p>
            Aplicamos políticas rígidas de gestão, monitoramento contínuo e controle 
            de resíduos para proteger a biodiversidade marinha.
          </p>
        </section>
        
      </div>
      {/* === FIM DA COLUNA DA ESQUERDA === */}

      {/* === COLUNA DA DIREITA: Aqui fica a imagem === */}
      <div className="quem-somos-imagem">
        <img 
          src={imagemQuemSomos} 
          alt="Operações da Atlantic Offshore Energy" 
          className="img-destaque" 
        />
      </div>

    </main>
  )
}