import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import fetchData from '../../utils/api';
import styles from './RegisterForm.module.scss';

function RegisterForm() {
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
    confirmPassword: '',
  });

  const navigate = useNavigate();

  // Handles input changes by setting a new value to the specified property (name)
  const handleInput = (name, value) => {
    setFormData((formData) => ({
      ...formData,
      [name]: value,
    }));
  };

  const handleRegistration = async (e) => {
    e.preventDefault();
    // Creates a UserDTO with the current formData state
    const userDto = {
      username: formData.username,
      email: formData.email,
      password: formData.password,
      // Add other fields as needed
    };

    // Fetch request
    const response = await fetchData('api/users', 'POST', userDto);

    if (response.error) {
      alert(response.message);
    } else {
      alert("User created successfully!")
      goToLoginPage();
    }
  };

  const goToLoginPage = () => {
    navigate('/signin');
  };

  return (
    <div className={styles.registerCard}>
      <div className={styles.appLogo}>
        <img className={styles.appLogo__icon} src="logo192.png" alt="Logo" />
        <h1 className={styles.appLogo__text}>Fill out some info</h1>
      </div>
      <form className={styles.form}>
        <input
          type="text"
          id="username"
          className={styles.form__input}
          name="username"
          placeholder="username"
          value={formData.username || ''}
          onChange={(e) => handleInput(e.target.name, e.target.value)}
        />
        <input
          type="email"
          id="email"
          className={styles.form__input}
          name="email"
          placeholder="email"
          value={formData.email || ''}
          onChange={(e) => handleInput(e.target.name, e.target.value)}
        />
        <input
          type="password"
          id="password"
          className={styles.form__input}
          name="password"
          placeholder="password"
          value={formData.password || ''}
          onChange={(e) => handleInput(e.target.name, e.target.value)}
        />
        <input
          type="password"
          id="confirmPassword"
          className={styles.form__input}
          name="confirmPassword"
          placeholder="confirm password"
          value={formData.confirmPassword || ''}
          onChange={(e) => handleInput(e.target.name, e.target.value)}
        />
        <button type="submit" className={styles.form__button} onClick={handleRegistration}>
          Create Account
        </button>
      </form>
      <div className={styles.loginLink}>
        <span>Already have an account?&nbsp;</span>
        <a onClick={goToLoginPage}>Sign In</a>
      </div>
    </div>
  );
}

export default RegisterForm;