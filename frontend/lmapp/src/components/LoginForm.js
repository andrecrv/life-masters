// LoginForm.js

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import fetchData from '../utils/api';
//import setUserData from '../utils/user';
import useAuth from '../hooks/useAuth';

const LoginForm = () => {

  const navigate = useNavigate();
  const { login } = useAuth();

  const [formData, setFormData] = useState({
    username: '',
    passwd: '',
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const { username, passwd } = formData;

    const response = await fetchData(`api/username/${username}`);

    if (response != null) {
      if (passwd == response.passwd) {
        alert('Authentication Succssesful');

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

  const handleNewAccount = () => {
    navigate('/signup');
  }

  return (
    <div className="card">
      <div className="login-form">
        {/*<img src={logo} alt="Logo" className="logo" /> - LOGO*/}
        <h1>Life Masters</h1>
        {/*LOGIN FORM FIELDS*/}
        <form>
          <div className="form-group">
            {/*USERNAME FIELD*/}
            <input type="text" id="username" name="username" value={formData.username} onChange={handleChange} placeholder='Username' />
          </div>
          <div className="form-group">
            {/*PASSWORD FIELD*/}
            <input type="password" id="password" name="passwd" value={formData.passwd} onChange={handleChange} placeholder='Password' />
          </div>
          <div className="forgot-password">
            <p>
              {/*FORGOT PASSWORD FIELD*/}
              <a href="#">Forgot your password?</a>
            </p>
          </div>
          {/*SIGN IN BUTTON*/}
          <button type="submit" onClick={handleSubmit}>Sign In</button>
          <div className="new-to-life-masters">
            <p>
              {/*NEW ACCOUNT REDIRECT*/}
              New to Life Masters?{' '}
              <a className="underline" onClick={handleNewAccount}>
                Start Now
              </a>
            </p>
          </div>
        </form>
      </div>
    </div>
  );
}


export default LoginForm;

