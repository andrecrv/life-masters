import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function CreateAccountForm() {
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
      username: "user",
      password: "user",
      email: "user@gmail.com",
      level:"1",
      title: "title 1"
      // Add other fields as needed
    };

    try {
      // Send POST request to the Spring Boot backend
      const response = await fetch('http://localhost:8081/create-user', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(userDto),
        credentials: 'include',
      });

      if (response.ok) {
        // Handle success (you might want to redirect or show a success message)
        console.log('User created successfully');
        navigate('/homepage'); // Redirect to homepage after successful creation
      } else {
        // Handle error (you might want to show an error message)
        console.error('Error creating user');
      }
    } catch (error) {
      // Handle network or other errors
      console.error('Error:', error);
    }
  };

  const handleSignInButton = () => {
    navigate('/homepage');
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

export default CreateAccountForm;
