import { useState } from 'react';
import AddIcon from '@mui/icons-material/Add';

import ActionButton from "../common/ActionButton";
import styles from './ItemAdder.module.scss';

const ItemAdder = ({ addItem }) => {
    const [text, setText] = useState('');

    const handleChange = (e) => {
        setText(e.target.value);
    }

    const handleGoal = () => {
        addItem(text);
        setText('');
    }

    return (
        <div className={styles.itemAdder}>
            <div className={styles.itemAdder__textbox}>
                <input
                    type="text"
                    className={styles.itemAdder__textbox__input}
                    placeholder="Add a new item..."
                    name="add-item-textbox"
                    value={text}
                    onChange={handleChange}
                />
            </div>
            <div className={`${styles['itemAdder__button']}`}>
                <ActionButton
                    icon={AddIcon}
                    size="20px"
                    backgroundColor='#42ff91'
                    color='white'
                    onClick={handleGoal}
                />
            </div>
        </div>
    );
};

export default ItemAdder;