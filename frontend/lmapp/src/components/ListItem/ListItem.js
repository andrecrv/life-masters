// ListItem.js

import React, { /*useState*/ } from 'react';
import './list-item.css';

const ListItem = ({ id, text, isCompleted, updateItem }) => {

  return (
    <div className="item-container">
      <div className="check-btn-container">
        <button
          className={isCompleted ? "check-btn active" : "check-btn"}
          type="checkbox"
          onClick={() => updateItem(id)}
        />
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