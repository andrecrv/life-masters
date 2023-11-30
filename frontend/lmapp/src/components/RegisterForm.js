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
    <div className="card">
      <div className="start-form">
        <h1>Life Masters</h1>
        <form>
          <div className="form-group">
            <input
              type="text"
              id="username"
              name="username"
              placeholder="Username"
              value={formData.username || ''}
              onChange={(e) => handleInput(e.target.name, e.target.value)}
            />
          </div>
          <div className="form-group">
            <input
              type="email"
              id="email"
              name="email"
              placeholder="Email"
              value={formData.email || ''}
              onChange={(e) => handleInput(e.target.name, e.target.value)}
            />
          </div>
          <div className="form-group">
            <input
              type="password"
              id="passwd"
              name="passwd"
              placeholder="Password"
              value={formData.passwd || ''}
              onChange={(e) => handleInput(e.target.name, e.target.value)}
            />
          </div>
          <div className="form-group">
            <input
              type="password"
              id="confirmPasswd"
              name="confirmPasswd"
              placeholder="Confirm Password"
              value={formData.confirmPasswd || ''}
              onChange={(e) => handleInput(e.target.name, e.target.value)}
            />
          </div>
          <button type="button" onClick={handleRegistration}>
            Create Account
          </button>
          <div className="already-have-account">
            <p>
              Already have an account?{' '}
              <a className="underline" onClick={goToLoginPage}>
                Sign In
              </a>
            </p>
          </div>
          {/* Display current form data for testing - <pre> for preformatting text */}
          <pre>{JSON.stringify(formData, null, 2)}</pre>
        </form>
      </div>

    </div>
  );
}

export default RegisterForm;