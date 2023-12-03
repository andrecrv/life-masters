// LoginForm.js

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import fetchData from '../utils/api';
import useAuth from '../hooks/useAuth';
import '../styles/loginPage.css'

const LoginForm = () => {

  const navigate = useNavigate();
  const { login } = useAuth();

  const [formData, setFormData] = useState({
    username: '',
    password: '',
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const { username, password: password } = formData;

    // Fetch user
    const response = await fetchData(`api/username/${username}`);
    console.log('Response: ' + JSON.stringify(response));
    
    if (response !== null) {
      if (password === response.password) {
        alert('Authentication Successful');

        // Call the login function to set the user upon login
        login(response);

        //setUserData(response);
        navigate('/start');
      } else {
        
        alert('Password Incorrect');
      }
    } else {
      alert('Username does not exist!');
    }

  };

  const goToRegisterPage = () => {
    navigate('/signup');
  }

  return (
    <div className="login-card">
      <div className="login-form">
        <div className="login-logo">
          <img src="logo192.png" alt="Logo" className="login-img" />
          <h1 className="app-title">Life Masters</h1>
        </div>
        {/*LOGIN FORM FIELDS*/}
        <form className="form-group-login">
          {/*USERNAME FIELD*/}
          <input
            type="text"
            className="input-login"
            placeholder='username'
            id="username"
            name="username"
            value={formData.username}
            onChange={handleChange}
          />
          {/*PASSWORD FIELD*/}
          <input
            type="password"
            className="input-login"
            placeholder='password'
            id="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
          />
          <div className="forgot-password">
            {/*FORGOT PASSWORD FIELD*/}
            <a href="#">Forgot your password?</a>
          </div>
          {/*SIGN IN BUTTON*/}
          <button type="submit" className="login-button" onClick={handleSubmit}>Sign In</button>
        </form>
        <div className="new-to-life-masters">
          {/*NEW ACCOUNT REDIRECT*/}
          New to Life Masters?{' '}
          <a className="underline" onClick={goToRegisterPage}>
            Start Now
          </a>
        </div>
      </div>
    </div >
  );
}


export default LoginForm;

