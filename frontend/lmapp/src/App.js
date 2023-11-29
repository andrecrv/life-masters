// App.js

import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import StartPage from './pages/StartPage';

function App() {
  return (
    <Router>
      <div className="App">
        {/* POSSIBLE ROUTES */}
        <Routes>
          <Route path='/signin' index element={<LoginPage/>} />
          <Route path='/signup' element= {<RegisterPage/>}/>
          <Route path='/start' element= {<StartPage/>}/>
        </Routes>
      </div>
</Router>
  );
}

export default App;