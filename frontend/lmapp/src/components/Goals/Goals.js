// Goals.js

import React from 'react';

import GoalsList from './GoalsList';
import useList from '../../hooks/useList';
import '../../styles/Goals/goals.css';

const Goals = () => {
    const { mockList } = useList();

    return (
        <div className='main-container'>
            <GoalsList data={mockList} />
        </div>
    );
};

export default Goals;