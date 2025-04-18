import StartAccount from '../../components/StartAccount';
import './Welcome.css'

function Welcome() {
  return (
    <div className="app-start">
        {/*CALLING THE CARD COMPONENT*/}
      <StartAccount />
    </div>
  );
}

export default Welcome;