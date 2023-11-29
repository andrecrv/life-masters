// RegisterForm.js

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function RegisterForm() {

  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
    confirmPassword: '',
  });

  const navigate = useNavigate();

  const handleCreateAccountButton = async () => {
    // USER INPUT LOGIC VERIFICATION HERE ...

    /*
    const userDto = {
      username: formData.username,
      email: formData.email,
      password: formData.password,
      // Add other fields as needed
    };
    */

    const userDto = {
      username: "userdto-react44",
      email: "userreactdto44@gmail.com",
      passwd: "userpwd44",
      // Add other fields as needed
    };

    const basicAuth = btoa('user:$2a$10$1iHtzX.r3uVfjgK.iVkuFee39NtkD//gKL9oYSnC9xZGRA8RGX.Bu') // Basic Authentication - server credentials

    try {
      // Send POST request to the Spring Boot backend
      await fetch('http://localhost:8080/api/create-user', {
        method: 'POST',
        headers: {
          'Authorization': 'Basic ' + basicAuth,
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(userDto),
        credentials: 'include',
        withCredentials: true,

      }).then(response => {
        if (response.ok) {
          // Handle success (you might want to redirect or show a success message)
          console.log('User created successfully!')
          console.log(response)
        }
      }).catch(error => {
        // Handle error (you might want to show an error message)
        console.log('Error creating user.')
        console.log('Error: ' + error)
      });

    } catch (error) {
      // Handle network or other errors
      console.error('try/catch error: ', error);
    }
  };

  const handleSignInButton = () => {
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
              value={formData.username}
              onChange={(e) => setFormData({ ...formData, username: e.target.value })}
            />
          </div>
          <div className="form-group">
            <input
              type="email"
              id="email"
              name="email"
              placeholder="Email"
              value={formData.email}
              onChange={(e) => setFormData({ ...formData, email: e.target.value })}
            />
          </div>
          <div className="form-group">
            <input
              type="password"
              id="password1"
              name="password1"
              placeholder="Password"
              value={formData.password}
              onChange={(e) => setFormData({ ...formData, password: e.target.value })}
            />
          </div>
          <div className="form-group">
            <input
              type="password"
              id="password2"
              name="password2"
              placeholder="Confirm Password"
              value={formData.confirmPassword}
              onChange={(e) => setFormData({ ...formData, confirmPassword: e.target.value })}
            />
          </div>
          <button type="button" onClick={handleCreateAccountButton}>
            Create Account
          </button>
          <div className="already-have-account">
            <p>
              Already have an account?{' '}
              <a className="underline" onClick={handleSignInButton}>
                Sign In
              </a>
            </p>
          </div>
        </form>
      </div>
    </div>
  );
}

export default RegisterForm;