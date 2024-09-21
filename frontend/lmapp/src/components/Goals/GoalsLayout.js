import React, { useState } from "react";
import List from '../List/List';
import TabButton from './TabButton';
import MyIcon from "../Icons/MyIcon";
import AddIcon from '@mui/icons-material/Add';
import useList from '../../hooks/useList';
import '../../styles/Goals/goalsLayout.css';

const GoalsLayout = () => {

  const { mockList } = useList();
  const [list, setList] = useState(mockList);
  const [activeTab, setActiveTab] = useState('All');

  const updateList = (id) => {
    setList(list.map(goal => {
      return goal.id === id ? { ...goal, complete: !goal.complete } : { ...goal };
    }));
  }

  const getList = () => {
    switch (activeTab) {
      case 'Pending':
        return list.filter(goal => goal.complete === false);
      case 'Completed':
        return list.filter(goal => goal.complete === true);
      default:
        return list;
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
        <div className="plus-button">
          <MyIcon icon={AddIcon} size="20px" backgroundColor='lightgreen' color='white' onClick={() => setActiveTab('Create')} />
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