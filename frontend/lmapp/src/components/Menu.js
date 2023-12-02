// Menu.js

import React, { useState } from 'react';
import MenuButton from './MenuButton';

const Menu = ({ buttons }) => {
    const [activeButton, setActiveButton] = useState(buttons[0].text);

    const handleButtonClick = (text) => {
        setActiveButton(text);
    };

    return (
        <div className="menu-container">
            {buttons.map((button) => (
                <MenuButton
                    key={button.text}
                    text={button.text}
                    active={activeButton === button.text}
                    onClick={() => handleButtonClick(button.text)}
                />
            ))}
        </div>
    );
};

export default Menu;