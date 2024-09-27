// Goals.js

import React from 'react';

import GoalsHeader from './GoalsHeader';
import GoalsList from './GoalsList';
import '../../styles/Goals/goals.css';

const Goals = () => {
    return (
        <div className='main-container'>
            <GoalsHeader />
            <GoalsList />
        </div>
    );
};

export default Goals;