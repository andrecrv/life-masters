import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';

import { AuthProvider } from './context/AuthContext';
import ProtectedRoute from './auth/ProtectedRoute';
import Login from './pages/Login/Login';
import Register from './pages/Register/Register';
import Welcome from './pages/Welcome/Welcome';
import Dashboard from './pages/Dashboard/Dashboard';
import './styles/global.scss';

const App = () => {

  return (
    <AuthProvider>
      <Router>
        <div className="app">
          <Routes>
            <Route path='/' element={<Navigate replace to='/signin' />} />
            <Route path='/signin' element={<Login />} />
            <Route path='/signup' element={<Register />} />
            <Route path='/welcome'
              element={
                <ProtectedRoute>
                  <Welcome />
                </ProtectedRoute>
              }
            />
            <Route path='/dashboard'
              element={
                <ProtectedRoute>
                  <Dashboard />
                </ProtectedRoute>
              }
            />
          </Routes>
        </div>
      </Router>
    </AuthProvider>
  );
}

export default App;