// TableHeader.js

import React from 'react';
import '../../styles/Goals/tabButton.css';

const TabButton = ({ text, onClick }) => {

    return (
        <button className="tab" onClick={onClick}>{text}</button>
    );
};

export default TabButton;