// ListItem.js

import React, { /*useState*/ } from 'react';
import './list-item.css';

const ListItem = ({ item, updateItem, deleteItem }) => {

  return (
    <div className="item-container">
      <div className="check-btn-container">
        <button
          className={item.complete ? "check-btn active" : "check-btn"}
          type="checkbox"
          onClick={() => updateItem(item.id)}
        />
      </div>
      <div className="text-container">
        {item.text}
      </div>
      <div className="edit-btn-container">
        <button className="btn edit-btn" type="button" >Edit</button>
      </div>
      <div className="delete-btn-container">
        <button className="btn del-btn" type="button" onClick={() => deleteItem(item.id)} >Delete</button>
      </div>
    </div>
  );
};

export default ListItem;