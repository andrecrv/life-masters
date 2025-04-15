import { useState, useMemo } from "react";

import FlagIcon from '@mui/icons-material/Flag';

import DynamicHeader from "../DynamicHeader";
import List from '../List/List';
import TabButton from './TabButton';
import GoalAdder from "./GoalAdder";
import '../../styles/Goals/goalsList.css';
import '../../styles/Goals/goalsHeader.css';

const GoalsList = ({ data }) => {
  const [goals, setGoals] = useState(data);
  const [activeTab, setActiveTab] = useState('All');

  const addGoal = (text) => {
    // create a new goal object
    const newGoal = {
      id: goals.length + 1,
      text: text,
      complete: false
    };

    if (text !== "") {
      // add new goal to the list (array)
      setGoals([...goals, newGoal]);
      //console.log('goal added');
    }
  }

  const editGoal = (id, itemText) => {
    setGoals(goals.map(goal => {
      return goal.id === id ? { ...goal, text: itemText } : { ...goal };
    }));
  }

  const updateGoal = (id) => {
    setGoals(goals.map(goal => {
      return goal.id === id ? { ...goal, complete: !goal.complete } : { ...goal };
    }));
  }

  const deleteGoal = (id) => {
    setGoals(goals.filter(goal => goal.id !== id));
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
    <>
      <div className='header-container'>
        <div className="header-title">
          <DynamicHeader icon={FlagIcon} title={"Goals"} />
        </div>
      </div>
      <div className="goals-toolbar">
        <div className="filter-tabs">
          <TabButton text="All" onClick={() => setActiveTab('All')} active={activeTab === 'All'} />
          <TabButton text="Pending" onClick={() => setActiveTab('Pending')} active={activeTab === 'Pending'} />
          <TabButton text="Completed" onClick={() => setActiveTab('Completed')} active={activeTab === 'Completed'} />
        </div>
        <GoalAdder addGoal={addGoal} />
      </div>
      <div className="goals-list-container">
        <div className="goals-container">
          <List list={filteredGoals} updateItem={updateGoal} editItem={editGoal} deleteItem={deleteGoal} />
        </div>
      </div>
    </>
  );
};

export default GoalsList;