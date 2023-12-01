// StartAccount.js

import React from 'react';

function StartAccount() {

  // Retrieving user data from localStorage
  const storedUserData = localStorage.getItem('userData');

  // Parsing the stored data back into a JavaScript object
  const userData = JSON.parse(storedUserData);

  return (
    <div className="card">
      <div className="start-form">
        <div className="logo-container">
          {/* Circular Logo */}
          <div className="logo"></div>
        </div>
        {/* Start Form Fields */}
        <form>
          {/* Username Field */}
          <h5>{userData.username}</h5>

          {/* Level Field */}
          <h5>Level {userData.lvl}</h5>

          {/* Player Title Field */}
          <h5>{userData.title}</h5>

          {/* Start Game Button */}
          <button type="button">Start Game</button>
        </form>
      </div>
    </div>
  );
}

export default StartAccount;