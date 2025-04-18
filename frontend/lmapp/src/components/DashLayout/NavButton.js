import styles from './NavButton.module.scss';

const NavButton = ({ text, icon, active, onClick }) => {

    const buttonStyle = active ? `${styles.navButton} ${styles.active}` : `${styles.navButton}`;

    return (
        <button type="button" className={buttonStyle} onClick={onClick} >
            {icon && <span>{icon}</span>}
            <span className={styles['navButton__label']}>{text}</span>
        </button>
    );
}

export default NavButton;