import { useState } from 'react';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import CheckIcon from '@mui/icons-material/Check';
import CloseIcon from '@mui/icons-material/Close';

import ActionButton from '../common/ActionButton';
import styles from './EditableItem.module.scss';


const EditableItem = ({ item, updateItem, editItem, deleteItem }) => {
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

  const handleCheckbox = () => {
    updateItem(item.id);
  }
  /*item.complete ? `${styles['item__toggle--active']}` : `${styles['item__toggle']}`}*/
  return (
    <div className={styles.item}>
      <div className={`${styles.item__toggle} ${item.complete && styles['item__toggle--active']}`} onClick={handleCheckbox}>
        <button className={`${styles.item__toggle__checkbox} ${item.complete && styles['item__toggle__checkbox--active']}`}
        />
      </div>
      <div className={styles.item__textbox}>
        {editable ?
          <input
            type='text'
            name='item-input'
            className={styles.item__textbox__input}
            value={text}
            onChange={changeText}
          />
          :
          <div className={styles.item__textbox__label}>
            {item.text}
          </div>
        }
      </div>
      <div className={styles.item__firstButton}>
        {/* If item is editable (true), then render Save button, else render Edit button */}
        <button
          name={editable ? 'save-button' : 'edit-button'}
          className={editable ? styles['item__firstButton--save'] : styles['item__firstButton--edit']}
          type="button"
          onClick={editable ? saveEdit : editMode}
        >
          <ActionButton
            icon={editable ? CheckIcon : EditIcon}
            size="1em"
            backgroundColor="none"
            color="white"
          />
        </button>
      </div>
      <div className={styles.item__secondButton}>
        <button
          name={editable ? 'cancel-button' : 'delete-button'}
          className={editable ? styles['item__secondButton--cancel'] : styles['item__secondButton--delete']}
          type="button"
          onClick={editable ? cancelEdit : () => deleteItem(item.id)}
        >
          <ActionButton
            icon={editable ? CloseIcon : DeleteIcon}
            size="1em"
            backgroundColor="none"
            color="white"
          />
        </button>
      </div>
    </div >
  );
};

export default EditableItem;