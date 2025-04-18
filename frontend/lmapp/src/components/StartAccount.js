import { useNavigate } from 'react-router-dom';

// Retrieving user data from localStorage
const storedUserData = localStorage.getItem('userData');
// Parsing the stored data back into a JavaScript object
const userData = JSON.parse(storedUserData);

function StartAccount() {

  const navigate = useNavigate();

  const goToDashboardPage = () => {
    navigate('/dashboard');
  };

  return (
    <div>
      <div className="card-start">
        <img src="/resources/icons/icon8.jpg" alt="Icon" className="icon-start" />
        <div className="user-info">
          <p className='username'>{userData.username}</p>
          <p className='title'>{userData.title}</p>
          <p className='level'>Lvl. {userData.level}</p>
        </div>
      </div>
      <button className="button-start" onClick={goToDashboardPage}>Start Game</button>
    </div>

  );
}

export default StartAccount;