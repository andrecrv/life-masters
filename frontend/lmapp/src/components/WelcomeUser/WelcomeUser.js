import { useNavigate } from 'react-router-dom';

import styles from './WelcomeUser.module.scss';

// Retrieving user data from localStorage
const storedUserData = localStorage.getItem('userData');
// Parsing the stored data back into a JavaScript object
const userData = JSON.parse(storedUserData);

function WelcomeUser() {

  const navigate = useNavigate();

  const goToDashboardPage = () => {
    navigate('/dashboard');
  };

  return (
    <div className={styles.welcomePage}>
      <div className={styles.welcomeCard}>
        <img src="/resources/icons/icon8.jpg" className={styles.welcomeCard__icon} alt="Icon" />
        <div className={styles.userInfo}>
          <p className={styles.userInfo__username}>{userData.username}</p>
          <p>{userData.title}</p>
          <p>Lvl. {userData.level}</p>
        </div>
      </div>
      <button className={styles.startButton} onClick={goToDashboardPage}>Start Game</button>
    </div>

  );
}

export default WelcomeUser;