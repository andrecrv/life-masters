import React, { useState } from "react";
import AllGoals from './AllGoals';
import PendingGoals from './PendingGoals';
import CompletedGoals from './CompletedGoals';
import TabButton from './TabButton';
import MyIcon from "../Icons/MyIcon";
import AddIcon from '@mui/icons-material/Add';
import CreateGoal from './CreateGoal';
import useList from '../../hooks/useList';
import '../../styles/Goals/goalsLayout.css';

const GoalsLayout = () => {
  const [activeTab, setActiveTab] = useState('All');
  const [selectedGoal, setSelectGoal] = useState(null);
  const { listData } = useList();

  const renderView = () => {
    switch (activeTab) {
      case 'All':
        return <AllGoals listData={listData} />;
      case 'Pending':
        // filter items with a pending status
        const pendingItems = listData.filter(item => item.status === 'pending');
        return <PendingGoals listData={pendingItems} />;
      case 'Completed':
        // filter items with a completed status
        const completedItems = listData.filter(item => item.status === 'completed');
        return <CompletedGoals listData={completedItems} />;
      case 'Create':
        return <CreateGoal />;
      default:
        return null;
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
        {renderView()}
      </div>
    </div>
  );
};

export default GoalsLayout;