// homePage.js
import React from 'react';
import LoginForm from '../components/homePage/loginForm';
import '../style/homePage.css'

function HomePage() {
  return (
    <div className="App">
        {/*CALLING THE CARD COMPONENT*/}
      <LoginForm/>
    </div>
  );
}

export default HomePage;