import axios, { AxiosResponse } from 'axios';

const api = axios.create({
    baseURL: process.env.REACT_APP_API
});

export const useApi = () => ({
    validadeToken: async (token: string) => {
        // provisório para testes
        return {
            user: {id: 3, name: 'Jose', email: 'jose@jose.com'},
        };

        // const response = await api.post('validade',{token});
        // return response.data;
    },
    singin: async (email: string, password: string) => {

        // provisório para testes
        // return {
        //     user: {id: 3, name: 'Jose', email: 'jose@jose.com'},
        //     token: '123abc'
        // };
        try{
            console.log('Testando logn');
            
            let response: AxiosResponse<any,any> ; // falta realizar tratativas para erros, como 401
            response = await api.post('/auth/login',{email,password})
            //.then(resp => response = resp)
            //.catch(error => console.log(error));
            console.log('Chegou da api resposta');
            console.log(response);
            return response?.data ;
        }catch(e){
            console.log(e);
            
        }
    },
    singout:async () => {
        // const responser = await api.post('/singout');
        // return responser.data;
    }
});