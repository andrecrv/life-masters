import React, { useState } from "react";
import AllGoals from './AllGoals';
import PendingGoals from './PendingGoals';
import CompletedGoals from './CompletedGoals';
import TabButton from './TabButton';
import MyIcon from "../Icons/MyIcon";
import AddIcon from '@mui/icons-material/Add';
import CreateGoal from './CreateGoal';

const GoalsLayout = () => {
  const [activeTab, setActiveTab] = useState("all");
  const [selectedGoal, setSelectGoal] = useState(null);

  const renderView = () => {
    switch (activeTab) {
      case 'all':
        return <AllGoals />;
      case 'pending':
        return <PendingGoals />;
      case 'completed':
        return <CompletedGoals />;
      case 'create':
        return <CreateGoal />;
      default:
        return null;
    }
  };

  return (
    <div className="goals-body-container">
      <div className="goals-tabs">
        <TabButton text="All" onClick={() => setActiveTab('all')} />
        <TabButton text="Pending" onClick={() => setActiveTab('pending')} />
        <TabButton text="Completed" onClick={() => setActiveTab('completed')} />
        <MyIcon className="plus-button" icon={AddIcon} backgroundColor='white' color='green' onClick={() => setActiveTab('create')} />
      </div>
      <div className="goals-body">
        {renderView()}
      </div>
    </div>
  );
};

export default GoalsLayout;