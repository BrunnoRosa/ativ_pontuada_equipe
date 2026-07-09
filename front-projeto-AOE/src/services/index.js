import axios from 'axios';

// Criação da instância centralizada do Axios
const api = axios.create({
    baseURL: 'http://localhost:8080/api',
    headers: {
        'Content-Type' : 'application/json'
    }
});

// Função para chamar especificamente a rota de manutenção
export const criarOrdemServico = async (dadosManutencao) => {
    const response = await api.post('/manutencoes', dadosManutencao);
    return response.data;
}

// Função para criar o incidente
export const criarIncidente = async (dadosIncidente) => {
    const response = await api.post('/incidentes', dadosIncidente);
    return response.data;
}

// Nova Função: Buscar a listagem da tripulação (Método GET)
export const listarTripulacao = async () => {
    const response = await api.get('/tripulacao');
    return response.data;
}

// Função para buscar a lista de produção diária
export const obterProducaoDiaria = async () => {
    const response = await api.get('/producao');
    return response.data;
};


export default api;