// ListItem.js

import { useState } from 'react';
import ActionButton from '../common/ActionButton';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import CheckIcon from '@mui/icons-material/Check';
import CloseIcon from '@mui/icons-material/Close';

import './list-item.css';


const ListItem = ({ item, updateItem, editItem, deleteItem }) => {

  const [text, setText] = useState(item.text);
  const [editable, setEditable] = useState(false);

  const editMode = () => {
    editable ? setEditable(false) : setEditable(true);
  }

  const saveEdit = () => {
    editItem(item.id, text);
    editMode();
  }

  const cancelEdit = () => {
    setText(item.text);
    editMode();
  }

  const changeText = (e) => {
    setText(e.target.value);
  }

  return (
    <div className="item-container">
      <div className={item.complete ? "checkbox-container-active" : "checkbox-container"}>
        {/*<input
          type="checkbox"
          className="checkbox"
          /*className={item.complete ? "check-btn active" : "check-btn"}*/
          /*onClick={() => updateItem(item.id)}
        />*/}
        <button
          className={item.complete ? "checkbox active" : "checkbox"}
          onClick={() => updateItem(item.id)}
        />
      </div>
      <div className="item-input-container">
        {editable ?
          <input
            type='text'
            name='item-input'
            className='item-input'
            value={text}
            onChange={changeText}
          />
          :
          <div className="item-text">
            {item.text}
          </div>
        }
      </div>
      <div className="edit-btn-container">
        {/* If item is editable (true), then render Save button, else render Edit button */}
        {editable ?
          <button name='save' className="save-btn" type="button" onClick={saveEdit} >
            <ActionButton
              name='save'
              icon={CheckIcon}
              size="1em"
              backgroundColor="none"
              color="white"
            />
          </button>
          :
          <button name='edit' className="edit-btn" type="button" onClick={editMode} >
            <ActionButton
              icon={EditIcon}
              size="1em"
              backgroundColor="none"
              color="white"
            />
          </button>
        }
      </div>
      <div className="delete-btn-container">
        {editable ?
          <button name='cancel' className="cancel-btn" type="button" onClick={cancelEdit} >
            <ActionButton
              name='cancel'
              icon={CloseIcon}
              size="1em"
              backgroundColor="none"
              color="white"
            />
          </button>
          :
          <button name='delete' className="del-btn" type="button" onClick={() => deleteItem(item.id)} >
            <ActionButton
              icon={DeleteIcon}
              size="1em"
              backgroundColor="none"
              color="white"
            />
          </button>
        }
      </div>
    </div>
  );
};

export default ListItem;