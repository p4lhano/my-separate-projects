import { useEffect, useState } from "react";
import { useApi } from "../../hooks/useApi";
import { User } from "../../types/User";
import { AuthContext } from "./AuthContext";


export const AuthProvider = ({children}: {children: JSX.Element}) => {
    const [user,setUser] = useState<User | null>(null);
    const api = useApi();

    const validadeToken = async () => {
        const storageDataToken = localStorage.getItem('authToken');
        if (storageDataToken){
            const data = await api.validadeToken(storageDataToken);
            if (data.user) {
                setUser(data.user);
            }
        }
    }
    useEffect( () => { // esta gerando loopp infinito esse use effect e uso da api
        validadeToken();
    },[]); // a ausencia de dependencia esta gerando apenas o useEffect quando deveria
    

    const signin = async (email: string, password: string) => {
        console.log('Esta usando signin');

        const data = await api.singin(email, password);
        console.log('Logou api.singin(email, password');
        if (data.user && data.token){
            console.log(`setando ${data.user}`);
            console.log(`setando ${data.token}`);
            setUser(data.user);
            setToken(data.token);
            console.log('Terminou');
            
            return true;
        }
        return false;

    }
    const singout = async () => {
        console.log('Esta usando sigout');
        await api.singout();
        setUser(null);
        setToken('');
    }

    const setToken = (token: string) => {
        localStorage.setItem('authToken',token);
    }
    return (
        <AuthContext.Provider value={{ user, signin, singout }}>
            {children}
        </AuthContext.Provider>
    );
}