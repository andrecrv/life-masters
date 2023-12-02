// StartPage.js

import React from 'react';
import StartAccount from '../components/StartAccount';
import '../styles/startPage.css'

function StartPage() {
  return (
    <div className="app-start">
        {/*CALLING THE CARD COMPONENT*/}
      <StartAccount />
    </div>
  );
}

export default StartPage;