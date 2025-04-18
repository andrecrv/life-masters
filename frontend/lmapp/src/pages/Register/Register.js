import RegisterForm from '../../components/forms/RegisterForm';
import './Register.css'

function Register() {
  return (
    <div className="App">
        {/*CALLING THE CREATE ACCOUNT CARD COMPONENT*/}
      <RegisterForm />
    </div>
  );
}

export default Register;