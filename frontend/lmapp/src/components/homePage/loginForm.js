// homePage/loginForm.js
import React from 'react';
import {useNavigate} from 'react-router-dom';

function LoginForm() {

  const navigate = useNavigate();

  const handleSignInButton = () => {
    //USER INPUT LOGIC VERFICATION HERE ...
    navigate('/start');
  }

  const handleNewAccount = () => {
    navigate('/newAccount');
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
            <input type="text" id="username" name="username" placeholder='Username' />
          </div>
          <div className="form-group">
            {/*PASSWORD FIELD*/}
            <input type="password" id="password" name="password" placeholder='Password'/>
          </div>
          <div className="forgot-password">
            <p>
              {/*FORGOT PASSWORD FIELD*/}
              <a href="#">Forgot your password?</a>
            </p>
          </div>
          {/*SIGN IN BUTTON*/}
          <button type="submit" onClick={handleSignInButton}>Sign In</button>
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
