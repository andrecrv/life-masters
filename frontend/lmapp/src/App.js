import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './pages/homePage';
import StartPage from './pages/startPage';
import CreateAccountPage from './pages/createAccountPage';

function App() {
  return (
    <Router>
      <div className="App">
        {/* POSSIBLE ROUTES */}
        <Routes>
          <Route path='/signin' index element={<HomePage/>} />
          <Route path='/signup' element= {<CreateAccountPage/>}/>
          <Route path='/start' element= {<StartPage/>}/>
          
        </Routes>
      </div>
</Router>
  );
}

export default App;