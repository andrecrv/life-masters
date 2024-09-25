import React, { useState } from "react";
import List from '../List/List';
import TabButton from './TabButton';
import MyIcon from "../Icons/MyIcon";
import AddIcon from '@mui/icons-material/Add';
import useList from '../../hooks/useList';
import '../../styles/Goals/goalsLayout.css';

const GoalsLayout = () => {

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

  const updateList = (id) => {
    setGoals(goals.map(goal => {
      return goal.id === id ? { ...goal, complete: !goal.complete } : { ...goal };
    }));
  }

  const getList = () => {
    switch (activeTab) {
      case 'Pending':
        return goals.filter(goal => goal.complete === false);
      case 'Completed':
        return goals.filter(goal => goal.complete === true);
      default:
        return goals;
    }
  };

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
          <List list={getList()} updateList={updateList} />
        </div>
      </div>
    </div>
  );
};

export default GoalsLayout;