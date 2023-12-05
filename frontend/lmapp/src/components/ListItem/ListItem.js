// ListItem.js

import React from 'react';
import './list-item.css';

const ListItem = ({ text }) => {

    return (
        <div className="item-container">
            <div className="check-btn-container">
                <button className="btn check-btn" type="button" ></button>
            </div>
            <div className="text-container">
                {text}
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