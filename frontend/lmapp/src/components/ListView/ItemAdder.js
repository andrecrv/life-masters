import { useState } from 'react';
import AddIcon from '@mui/icons-material/Add';

import ActionButton from "../common/ActionButton";

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
        <div className="add-item-container">
            <div className="add-input-container">
                <input
                    type="text"
                    className="add-input"
                    placeholder="Add a new item..."
                    name="add-item-textbox"
                    value={text}
                    onChange={handleChange}
                />
            </div>
            <div className="add-button-container">
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