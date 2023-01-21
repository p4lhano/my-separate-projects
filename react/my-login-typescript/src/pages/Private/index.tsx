import { useContext } from 'react';
import { AuthContext } from '../../Context/Auth/AuthContext';

export const Private = () => {
    const auth = useContext(AuthContext);
    return (
        <div>
            Private, Hellow {auth.user?.name}
        </div>
    );
}

export default Private;