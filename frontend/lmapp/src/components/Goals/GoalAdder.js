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
        <>
            <div>
                <input
                    type="text"
                    /*className="input-login"*/
                    placeholder="insert text here for a new goal"
                    name="add-goal-textbox"
                    value={text}
                    onChange={handleChange}
                />
            </div>
            <div className="plus-button">
                <ActionButton
                    icon={AddIcon}
                    size="20px"
                    backgroundColor='lightgreen'
                    color='white'
                    onClick={handleGoal}
                />
            </div>
        </>
    );
};

export default GoalAdder;