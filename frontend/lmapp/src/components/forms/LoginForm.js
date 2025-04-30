import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import fetchData from '../../utils/api';
import useAuth from '../../hooks/useAuth';
import styles from './LoginForm.module.scss';

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
        navigate('/welcome');
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
    <div className={styles.loginCard}>
      <div className={styles.appLogo}>
        <img className={styles.appLogo__icon} src="logo192.png" alt="Logo" />
        <h1 className={styles.appLogo__text}>LifeMasters</h1>
      </div>
      {/*LOGIN FORM FIELDS*/}
      <form className={styles.form}>
        {/*USERNAME FIELD*/}
        <input
          type="text"
          className={styles.form__input}
          placeholder='username'
          id="username"
          name="username"
          value={formData.username}
          onChange={handleChange}
        />
        {/*PASSWORD FIELD*/}
        <input
          type="password"
          className={styles.form__input}
          placeholder='password'
          id="password"
          name="password"
          value={formData.password}
          onChange={handleChange}
        />
        <div className={styles.form__forgot}>
          {/*FORGOT PASSWORD FIELD*/}
          <a href="#">Forgot your password?</a>
        </div>
        {/*SIGN IN BUTTON*/}
        <button type="submit" className={styles.form__button} onClick={handleSubmit}>Sign In</button>
      </form>
      <div className={styles.registerLink}>
        {/*NEW ACCOUNT REDIRECT*/}
        <span>New to Life Masters?&nbsp;</span>
        <a onClick={goToRegisterPage}>Sign Up</a>
      </div>
    </div >
  );
}


export default LoginForm;

