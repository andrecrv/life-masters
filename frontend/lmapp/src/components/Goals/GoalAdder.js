// Add Goal Controller

import { useState } from 'react';
import ActionButton from "../common/ActionButton";
import AddIcon from '@mui/icons-material/Add';

const GoalAdder = ({ addGoal }) => {

    const [text, setText] = useState('');

    const handleChange = (e) => {
        setText(e.target.value);
    }

    const handleGoal = () => {
        addGoal(text);
        setText('');
    }

    return (
        <div className="add-goal-container">
            <div className="add-input-container">
                <input
                    type="text"
                    className="add-input"
                    placeholder="Add a new goal..."
                    name="add-goal-textbox"
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

export default GoalAdder;