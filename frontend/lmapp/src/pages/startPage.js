// startPage.js
import React from 'react';
import StartForm from '../components/startPage/startForm';
import '../style/startPage.css'

function StartPage() {
  return (
    <div className="App">
        {/*CALLING THE CARD COMPONENT*/}
      <StartForm />
    </div>
  );
}

export default StartPage;