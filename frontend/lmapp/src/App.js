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
          <Route path='/homepage' index element={<HomePage/>} />
          <Route path='/start' element= {<StartPage/>}/>
          <Route path='/new-account' element= {<CreateAccountPage/>}/>
        </Routes>
      </div>
</Router>
  );
}

export default App;