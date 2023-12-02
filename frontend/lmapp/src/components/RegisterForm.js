// RegisterForm.js

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import fetchData from '../utils/api';

function RegisterForm() {

  const [formData, setFormData] = useState({
    username: '',
    email: '',
    passwd: '',
    confirmPasswd: '',
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
      passwd: formData.passwd,
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
            id="passwd"
            className="input-register"
            name="passwd"
            placeholder="password"
            value={formData.passwd || ''}
            onChange={(e) => handleInput(e.target.name, e.target.value)}
          />
          <input
            type="password"
            id="confirmPasswd"
            className="input-register"
            name="confirmPasswd"
            placeholder="confirm password"
            value={formData.confirmPasswd || ''}
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