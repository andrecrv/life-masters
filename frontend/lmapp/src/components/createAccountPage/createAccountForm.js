// CreateAccountPage/createAccountForm.js
import React from 'react';
import { useNavigate } from 'react-router-dom';

function CreateAccountForm() {

  const navigate = useNavigate();

  const handleCreateAccountButton = () => {
    //USER INPUT LOGIC VERFICATION HERE ...
    navigate('/create-account');
  }

  const handleSignInButton = () => {
    navigate('/homepage');
  }


  return (
    <div className="card">
        <div className="start-form">
            {/*<img src={logo} alt="Logo" className="logo" /> - LOGO*/}
            <h1>Life Masters</h1>
            {/*START FORM FIELDS*/}
            <form>
              <div className="form-group">
                {/*USERNAME FIELD*/}
                <input type="text" id="username" name="username" placeholder='Username' />
              </div>
              <div className="form-group">
                {/*EMAIL FIELD*/}
                <input type="email" id="email" name="email" placeholder='Email'/>
              </div>
              <div className="form-group">
                {/*PASSWORD FIELD*/}
                <input type="password" id="password2" name="password1" placeholder='Password'/>
              </div>
              <div className="form-group">
                {/*PASSWORD FIELD*/}
                <input type="password" id="password" name="password2" placeholder='Confirm Password'/>
              </div>
              <button type='button'>Create Account</button>
              <div className="already-have-account">
                <p>
                  {/*SIGN IN REDIRECT*/}
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