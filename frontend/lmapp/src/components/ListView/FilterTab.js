import React from 'react';
import '../../styles/ListView/filter-tab.css';

const FilterTab = ({ text, onClick, active }) => {

    const styling = active ? 'tab active' : 'tab';

    return (
        <button className={styling} onClick={onClick}>{text}</button>
    );
};

export default FilterTab;