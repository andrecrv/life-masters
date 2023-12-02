// LoginPage.js

import React from 'react';
import LoginForm from '../components/LoginForm';
import '../styles/loginPage.css'

function LoginPage() {
  return (
    <div>
        {/*CALLING THE CARD COMPONENT*/}
      <LoginForm/>
    </div>
  );
}

export default LoginPage;