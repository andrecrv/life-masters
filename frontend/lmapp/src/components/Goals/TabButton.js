// TableHeader.js

import React from 'react';
import '../../styles/Goals/tabButton.css';

const TabButton = ({ text, onClick, active }) => {

    const styling = active ? 'tab active' : 'tab';

    return (
        <button className={styling} onClick={onClick}>{text}</button>
    );
};

export default TabButton;