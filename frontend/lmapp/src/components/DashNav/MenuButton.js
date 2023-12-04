// MenuButton.js

import React from 'react';
import '../../styles/DashNav/dashNav.css';

const MenuButton = (props) => {

    const btnClassName = props.active ? "menu-btn active" : "menu-btn";

    return (
        <button type="button" className={btnClassName} onClick={props.onClick} >
            {props.text}
        </button>
    );
}

export default MenuButton;