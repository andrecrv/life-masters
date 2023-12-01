// useAuth.js
import { useState } from 'react';

const useAuth = () => {
  const [user, setUser] = useState(null);

  const login = (userData) => {
    localStorage.setItem('userData', JSON.stringify(userData));
    setUser(userData);
  };

  const logout = () => {
    localStorage.removeItem('userData');
    setUser(null);
  };

  return { user, login, logout };
};

export default useAuth;