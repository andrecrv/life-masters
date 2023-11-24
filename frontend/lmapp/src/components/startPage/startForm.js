// startPage/startForm.js
import React from 'react';

function StartForm() {

  let username = "HolyDonutDude";
  let level = "1";
  let title = "Novice Wanderer I";


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
          <h5>{username}</h5>

          {/* Level Field */}
          <h5>Level {level}</h5>

          {/* Player Title Field */}
          <h5>{title}</h5>

          {/* Start Game Button */}
          <button type="button">Start Game</button>
        </form>
      </div>
    </div>
  );
}

export default StartForm;