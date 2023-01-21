import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "../../Context/Auth/AuthContext";

export const Login = () => {
    const auth = useContext(AuthContext);
    const navigate = useNavigate()

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async () => {
        if(email && password){
            
            const isLogado = await auth.signin(email, password);
            if (isLogado){
                navigate('/');
                // window.location.href = window.location.href;
            } else {
                //add melhores alertas
                alert('Erro no login');
            }
            
        }
    }
    const handleEmailInput = (event: React.ChangeEvent<HTMLInputElement>) => setEmail( event.target.value );

    const handlePasswordInput = (event: React.ChangeEvent<HTMLInputElement>) => setPassword( event.target.value );

    return (
        <div>
            <h2>Pagina bloqueada</h2>

            <input type="text" value={email} onChange={handleEmailInput} placeholder="Digite o email" />
            <input type="password" value={password} onChange={handlePasswordInput} placeholder="Digite a senha" />

            <button onClick={handleLogin}>Login</button>
        </div>
    );
}