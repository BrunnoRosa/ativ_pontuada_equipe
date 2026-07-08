import './style.css'

export default function ContatoEmergencia() {
    return (
        <main className='contato-emergencia-page'>
            <section className='contato-card'>
                <h1>Contatos de Emergência</h1>
                <p>
                    Canais diretos com as bases em terra e telefones de contingência internacional.
                    Use os números abaixo para comunicação imediata em situações críticas.
                </p>

                <h2>Bases em Terra</h2>
                <ul className='contato-list'>
                    <li>
                        <strong>Macaé:</strong> Centro de Operações — (22) 2121-0000 · Rádio VHF Canal 16
                    </li>
                    <li>
                        <strong>Santos:</strong> Centro de Operações — (13) 3322-1111 · Rádio VHF Canal 16
                    </li>
                    <li>
                        <strong>Rio de Janeiro:</strong> Centro de Operações — (21) 4411-2222 · Rádio VHF Canal 16
                    </li>
                </ul>

                <h2>Telefones de Contingência Internacional</h2>
                <ul className='contato-list'>
                    <li>
                        <strong>Reino Unido (Hotline):</strong> +44 20 7946 0000
                    </li>
                    <li>
                        <strong>Noruega (Support):</strong> +47 22 00 0000
                    </li>
                    <li>
                        <strong>Estados Unidos (Contingency):</strong> +1 713-555-0100
                    </li>
                </ul>

                <p className='nota'>
                    Em caso de emergência, contate primeiro a base mais próxima e informe: ID da
                    unidade, natureza da emergência e coordenadas (se disponíveis).
                </p>
            </section>
        </main>
    )
}