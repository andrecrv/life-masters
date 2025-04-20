import styles from './SectionButton.module.scss';

const SectionButton = ({ text, onClick, active }) => {
    // const styling = active ? `tab ${styles.sectionButton} active` : `tab ${styles.sectionButton}`;

    return (
        <button className={styles.sectionButton} onClick={onClick}>
            {text}
        </button>
    );
};

export default SectionButton;
