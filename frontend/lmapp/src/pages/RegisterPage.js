// RegisterPage.js

import React from 'react';
import RegisterForm from '../components/RegisterForm';
import '../styles/registerPage.css'

function RegisterPage() {
  return (
    <div className="App">
        {/*CALLING THE CREATE ACCOUNT CARD COMPONENT*/}
      <RegisterForm />
    </div>
  );
}

export default RegisterPage;