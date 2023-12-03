// RegisterForm.js

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import fetchData from '../utils/api';

function RegisterForm() {

  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
    confirmPassword: '',
  });

  const navigate = useNavigate();

  // Handles input changes by setting a new value to the specified property (name)
  const handleInput = (name, value) => {
    setFormData((formData) => ({
      ...formData,
      [name]: value,
    }));
  };

  const handleRegistration = async () => {
    // Creates a UserDTO with the current formData state
    const userDto = {
      username: formData.username,
      email: formData.email,
      password: formData.password,
      // Add other fields as needed
    };

    /*
    const userDto = {
      username: "userdto-fetchapi",
      email: "user.fetchapi@gmail.com",
      passwd: "userpwdapi",
      // Add other fields as needed
    };
    */

    // Fetch request
    fetchData('api/create-user', 'POST', userDto);
    navigate('/signin');
  };

  const goToLoginPage = () => {
    navigate('/signin');
  };

  return (
    <div className="register-card">
      <div className="register-form">
        <div className="register-logo">
          <img src="logo192.png" alt="Logo" className="register-img" />
          <h1 className="form-title">Fill out some info</h1>
        </div>
        <form className="form-group-register">
          <input
            type="text"
            id="username"
            className="input-register"
            name="username"
            placeholder="username"
            value={formData.username || ''}
            onChange={(e) => handleInput(e.target.name, e.target.value)}
          />
          <input
            type="email"
            id="email"
            className="input-register"
            name="email"
            placeholder="email"
            value={formData.email || ''}
            onChange={(e) => handleInput(e.target.name, e.target.value)}
          />
          <input
            type="password"
            id="password"
            className="input-register"
            name="password"
            placeholder="password"
            value={formData.password || ''}
            onChange={(e) => handleInput(e.target.name, e.target.value)}
          />
          <input
            type="password"
            id="confirmPassword"
            className="input-register"
            name="confirmPassword"
            placeholder="confirm password"
            value={formData.confirmPassword || ''}
            onChange={(e) => handleInput(e.target.name, e.target.value)}
          />
          <button type="button" className="register-button" onClick={handleRegistration}>
            Create Account
          </button>
        </form>
        <div className="already-have-account">
          Already have an account?{' '}
          <a className="underline" onClick={goToLoginPage}>
            Sign In
          </a>
        </div>
      </div>
    </div>
  );
}

export default RegisterForm;