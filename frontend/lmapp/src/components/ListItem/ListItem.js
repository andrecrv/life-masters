// ListItem.js

import { useState } from 'react';
import './list-item.css';

const ListItem = ({ item, updateItem, editItem, deleteItem }) => {

  const [text, setText] = useState(item.text);
  const [editable, setEditable] = useState(false);

  const editMode = () => {
    editable ? setEditable(false) : setEditable(true);
  }

  const handleEdit = (e) => {
    if (e.target.name === 'save') {
      editItem(item.id, text);
    } else if (e.target.name === 'cancel') {
      setText(item.text);
    }
    editMode();
  }

  const changeText = (e) => {
    setText(e.target.value);
  }

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
        {editable ?
          <input type='text' name='input-edit' value={text} onChange={changeText} />
          :
          item.text
        }
      </div>
      <div className="edit-btn-container">
        {/* If item is editable (true), then render Save button, else render Edit button */}
        {editable ?
          <button name='save' className="btn save-btn" type="button" onClick={handleEdit} >Save</button>
          :
          <button name='edit' className="btn edit-btn" type="button" onClick={editMode} >Edit</button>
        }
      </div>
      <div className="delete-btn-container">
        {editable ?
          <button name='cancel' className="btn cancel-btn" type="button" onClick={handleEdit} >Cancel</button>
          :
          <button name='delete' className="btn del-btn" type="button" onClick={() => deleteItem(item.id)} >Delete</button>
        }
      </div>
    </div>
  );
};

export default ListItem;