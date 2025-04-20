import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';

import Login from './pages/Login/Login';
import Register from './pages/Register/Register';
import Welcome from './pages/Welcome/Welcome';
import Dashboard from './pages/Dashboard/Dashboard';
import './styles/global.scss';

const App = () => {

  return (
    <Router>
      <div className="app">
        <Routes>
          <Route path='/' element={<Navigate replace to='/signin' />} />
          <Route path='/signin' index element={<Login />} />
          <Route path='/signup' element={<Register />} />
          <Route path='/welcome' element={<Welcome />} />
          <Route path='/dashboard' element={<Dashboard />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;