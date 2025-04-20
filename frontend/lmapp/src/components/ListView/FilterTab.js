import styles from './FilterTab.module.scss';

const FilterTab = ({ text, onClick, active }) => {

    const styling = `${styles.filterTab} ${active && styles.active}`;

    return (
        <button className={styling} onClick={onClick}>{text}</button>
    );
};

export default FilterTab;