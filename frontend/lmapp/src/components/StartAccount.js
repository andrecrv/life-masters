// StartAccount.js

import React from 'react';

function StartAccount() {

  // Retrieving user data from localStorage
  const storedUserData = localStorage.getItem('userData');

  // Parsing the stored data back into a JavaScript object
  const userData = JSON.parse(storedUserData);

  //
  return (
    <div>
      <div className="card-start">
          <img src="/resources/icons/icon8.jpg" alt="Icon" className="icon-start" />
          <div className="user-info">
            <p className='username'>{userData.username}</p>
            <p className='title'>{userData.title}</p>
            <p className='level'>Lvl. {userData.lvl}</p>
        </div>
      </div>
      <button className="button-start">Start Game</button>
    </div>

  );
}

export default StartAccount;