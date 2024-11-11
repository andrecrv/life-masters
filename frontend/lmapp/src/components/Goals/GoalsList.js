import React, { useState, useMemo } from "react";
import MyIcon from "../Icons/MyIcon";
import AddIcon from '@mui/icons-material/Add';

import List from '../List/List';
import TabButton from './TabButton';
import useList from '../../hooks/useList';
import '../../styles/Goals/goalsList.css';

const GoalsList = () => {

  const { mockList } = useList();
  const [goals, setGoals] = useState(mockList);
  const [activeTab, setActiveTab] = useState('All');
  const [text, setText] = useState(''); //Update the text for the new goal

  const handleChange = (e) => {
    //console.log(e.target.value);
    setText(e.target.value);
  }

  const addGoal = () => {
    // create a new goal object
    const newGoal = {
      id: goals.length + 1,
      text: text,
      complete: false
    };

    if (text !== "") {
      // add new goal to the list (array)
      setGoals([...goals, newGoal]);
      setText('');
      //console.log('goal added');
    }
  }

  const deleteGoal = (id) => {
    setGoals(goals.filter(goal => goal.id !== id));
  }

  const updateGoal = (id) => {
    setGoals(goals.map(goal => {
      return goal.id === id ? { ...goal, complete: !goal.complete } : { ...goal };
    }));
  }

  const editGoal = (id, itemText) => {
    setGoals(goals.map(goal => {
      return goal.id === id ? { ...goal, text: itemText } : { ...goal };
    }));
  }

  const filteredGoals = useMemo(() => {
    switch (activeTab) {
      case 'Pending':
        return goals.filter(goal => goal.complete === false);
      case 'Completed':
        return goals.filter(goal => goal.complete === true);
      default:
        return goals;
    }
  }, [activeTab, goals]);


  return (
    <div className="goals-body-container">
      <div className="goals-tabs">
        <div className="tabs-row">
          <TabButton text="All" onClick={() => setActiveTab('All')} active={activeTab === 'All'} />
          <TabButton text="Pending" onClick={() => setActiveTab('Pending')} active={activeTab === 'Pending'} />
          <TabButton text="Completed" onClick={() => setActiveTab('Completed')} active={activeTab === 'Completed'} />
        </div>
        <input
          type="text"
          className="input-login"
          placeholder="input text for the new goal"
          name="add-goal-textbox"
          onChange={handleChange}
        />
        <div className="plus-button">
          <MyIcon icon={AddIcon} size="20px" backgroundColor='lightgreen' color='white' onClick={addGoal} />
        </div>
      </div>
      <div className="goals-list-container">
        <div className="goals-container">
          <List list={filteredGoals} updateItem={updateGoal} editItem={editGoal} deleteItem={deleteGoal} />
        </div>
      </div>
    </div>
  );
};

export default GoalsList;