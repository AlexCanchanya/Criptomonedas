import React, { useEffect, useState } from 'react';
import axios from 'axios';


const Criptomonedas = () => {
    const [criptomonedas, setCriptomonedas] = useState([]);

    useEffect(() => {
        const fetchCriptomonedas = async () => {
            try {
                const response = await axios.get('http://localhost:8070/api/criptomonedas');

                const uniqueCriptomonedas = response.data.reduce((acc, current) => {
                    const x = acc.find(item => item.simbolo === current.simbolo);
                    if (!x) {
                        return acc.concat([current]);
                    } else {
                        return acc;
                    }
                }, []);

                const sortedCriptomonedas = uniqueCriptomonedas.sort((a, b) => {
                    if (a.nombre < b.nombre) return -1;
                    if (a.nombre > b.nombre) return 1;
                    return 0;
                });

                setCriptomonedas(sortedCriptomonedas);
            } catch (error) {
                console.error('Error al obtener las criptomonedas:', error);
            }
        };

        fetchCriptomonedas();
    }, []);




    return (
        <div>
            <div style={{
                backgroundColor: '#181a20', 
                border: '2px solid #9d9ea3', 
                borderRadius: '8px',
                boxShadow: '0 2px 10px rgba(0, 0, 0, 0.1)',
                padding: '10px',
                marginBottom: '20px',
                marginLeft: '345px',
                marginRight: '345px'

            }}>
                <p style={{ fontSize: '20px', textAlign: 'left' }}>
                    Principales tokens por capitalización de mercado
                    
                </p>
                <p style={{ fontSize: '15px', textAlign: 'left' }}>
                Obtén una instantánea completa de todas las criptomonedas disponibles en COINGEKO. Esta página muestra los últimos precios, el volumen de trading y las capitalizaciones de mercado de todas las criptomonedas en COINGEKO. Los usuarios pueden acceder rápidamente a información clave sobre estos activos digitales y a la página de trading desde aquí.                    
                </p>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Volumen actual</th>
                        <th>Cap. de Mercado</th>
                    </tr>
                </thead>
                <tbody>
                    {criptomonedas.map(crypto => (
                        <tr key={crypto.crypto_id}>
                            <td>
                                <span style={{ fontWeight: 'bold', textTransform: 'uppercase' }}>
                                    {crypto.simbolo}
                                </span>
                                <span style={{ color: '#9d9ea3' }}> {}
                                    {crypto.nombre}
                                </span>
                            </td>
                            <td>${crypto.precio_actual.toLocaleString()}</td>
                            <td>${crypto.circulacion_actual.toLocaleString()}</td>
                            <td>${crypto.capitalizacion_de_mercado.toLocaleString()}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default Criptomonedas;
