import { useContext } from 'react';
import { Link, Route, Routes, useNavigate } from 'react-router-dom';
import './App.css';
import { AuthContext } from './Context/Auth/AuthContext';
import { RequireAuth } from './Context/Auth/RequireAuth';
import Home from './pages/Home';
import Private from './pages/Private';

function App() {
  const auth = useContext(AuthContext);
  const navigate = useNavigate();
  const handleLogout = () => {
    auth.singout();
    navigate('/');

  }

  return (
    <div className="App">
      <header>
        <h1>Header</h1>
        <nav>
        <Link to="/">Home</Link>
        <Link to="/private">Private </Link>
        {auth.user && <button onClick={handleLogout}>Sair</button>}
        </nav>
      </header>
      <hr />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/private" element={<RequireAuth><Private /></RequireAuth>} />
      </Routes>
    </div>
  );
}

export default App;
