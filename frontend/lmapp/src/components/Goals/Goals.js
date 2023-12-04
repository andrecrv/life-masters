// Goals.js

import React from 'react';
import '../../styles/Goals/goals.css';
import GoalsHeader from './GoalsHeader';
import GoalsLayout from './GoalsLayout';


const Goals = () => {
    return (
        <div className='main-container'>
            <GoalsHeader />
            <GoalsLayout />
        </div>
    );
};

export default Goals;