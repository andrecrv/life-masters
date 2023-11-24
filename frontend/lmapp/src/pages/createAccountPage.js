// createAccoutnPage.js
import React from 'react';
import CreateAccountForm from '../components/createAccountPage/createAccountForm';
import '../style/createAccountPage.css'

function StartPage() {
  return (
    <div className="App">
        {/*CALLING THE CREATE ACCOUNT CARD COMPONENT*/}
      <CreateAccountForm />
    </div>
  );
}

export default StartPage;