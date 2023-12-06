// ButtonView.js

import React from 'react';
import '../../styles/Guide/buttonView.css';

const ButtonView = ({ text, onClick, active, className }) => {
    const styling = active ? `tab ${className} active` : `tab ${className}`;

    return (
        <button className={styling} onClick={onClick}>{text}</button>
    );
};

export default ButtonView;
