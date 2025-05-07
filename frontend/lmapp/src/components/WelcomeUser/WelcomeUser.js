import { useNavigate } from 'react-router-dom';

import styles from './WelcomeUser.module.scss';
import { useAuth } from '../../context/AuthContext';

function WelcomeUser() {
  const navigate = useNavigate();
  const { user } = useAuth();

  const goToDashboardPage = () => {
    navigate('/dashboard');
  };

  return (
    <div className={styles.welcomePage}>
      <div className={styles.welcomeCard}>
        <img src="/resources/icons/icon8.jpg" className={styles.welcomeCard__icon} alt="Icon" />
        <div className={styles.userInfo}>
          <p className={styles.userInfo__username}>{user.username}</p>
          <p>{user.title}</p>
          <p>Lvl. {user.level}</p>
        </div>
      </div>
      <button className={styles.startButton} onClick={goToDashboardPage}>Start Game</button>
    </div>

  );
}

export default WelcomeUser;