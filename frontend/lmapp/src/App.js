// App.js

import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import StartPage from './pages/startPage';
import DashboardPage from './pages/DashboardPage';

function App() {

  return (
    <Router>
      <div className="app">
        {/* POSSIBLE ROUTES */}
        <Routes>
          <Route path='/signin' index element={<LoginPage />} />
          <Route path='/signup' element={<RegisterPage />} />
          <Route path='/start' element={<StartPage />} />
          <Route path='/dashboard' element={<DashboardPage />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;