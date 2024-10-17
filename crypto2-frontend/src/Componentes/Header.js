import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
    return (
        <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', backgroundColor: '#181a20', padding: '10px' }}>
            <nav>
                <ul style={{ listStyle: 'none', display: 'flex', gap: '25px', padding: '0' }}>
                    <li>
                        <Link to="/" style={{ color: '#128e17', textDecoration: 'none', fontSize: '18px', fontWeight: 'bold' }}>COINGEKO</Link>
                    </li>
                    <li><Link to="/" style={{ color: '#fff', textDecoration: 'none' }}>Inicio</Link></li>
                    <li><Link to="/page1" style={{ color: '#fff', textDecoration: 'none' }}>Comprar Cripto</Link></li>
                    <li><Link to="/cripto" style={{ color: '#fff', textDecoration: 'none' }}>Mercado</Link></li>
                    <li><Link to="/" style={{ color: '#fff', textDecoration: 'none' }}>Trade</Link></li>
                </ul>
            </nav>
            <div style={{ display: 'flex', gap: '15px' }}>
                <Link to="/login" style={{ color: '#fff', textDecoration: 'none', padding: '10px 15px', backgroundColor: '#3b3d3b', borderRadius: '5px' }}>Iniciar Sesión</Link>
                <Link to="/register" style={{ color: '#fff', textDecoration: 'none', padding: '10px 15px', backgroundColor: '#4CAF50', borderRadius: '5px' }}>Registrarse</Link>
            </div>
        </header>
    );
};

export default Header;
