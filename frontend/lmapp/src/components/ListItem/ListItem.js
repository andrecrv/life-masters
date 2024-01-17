// ListItem.js

import React, { useState } from 'react';
import useList from '../../hooks/useList';
import './list-item.css';

const ListItem = ({ key, item }) => {

    const { changeStatus } = useList();
    const [buttonClass, setButtonClass] = useState('check-btn');
    const [status, setStatus] = useState('pending');

    const handleClick = () => {
        if (buttonClass === 'check-btn') {
            setButtonClass('check-btn active');
            // change the item's status
            setStatus('completed');
            //changeStatus(key, status);
        } else {
            setButtonClass('check-btn');
            setStatus('pending');
            //changeStatus(key, status);
        }
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