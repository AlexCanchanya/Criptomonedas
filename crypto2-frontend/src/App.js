// src/App.js

import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import CriptomonedasList from './Componentes/CriptomonedasList';
import Page1 from './Componentes/Page1';
import Header from './Componentes/Header';

import './App.css';

const App = () => {
  return (
    <Router>
      <div>
        <Header />
        <Routes>
          <Route path="/page1" element={<Page1 />} />
          <Route path="/cripto" element={<CriptomonedasList />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;

