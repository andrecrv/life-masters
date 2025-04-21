import ActionButton from '../ActionButton';
import styles from './UtilityButton.module.scss';

const UtilityButton = ({ icon, onClick }) => {

    return (
        <button className={styles.button} onClick={onClick}>
            <ActionButton icon={icon} color="white" />
        </button>
    );

}

export default UtilityButton;