// ListItem.js

import React, { useState } from 'react';
import './list-item.css';

const ListItem = ({ item }) => {

    const [buttonClass, setButtonClass] = useState('check-btn');

    const handleClick = () => {
        buttonClass === 'check-btn' ? setButtonClass('check-btn active') : setButtonClass('check-btn');
    };

    return (
        <div className="item-container">
            <div className="check-btn-container">
                <button
                    className={buttonClass}
                    type="checkbox"
                    onClick={handleClick}
                />
            </div>
            <div className="text-container">
                {item.text}
            </div>
            <div className="edit-btn-container">
                <button className="btn edit-btn" type="button" >Edit</button>
            </div>
            <div className="delete-btn-container">
                <button className="btn del-btn" type="button" >Delete</button>
            </div>
        </div>
    );
};

export default ListItem;