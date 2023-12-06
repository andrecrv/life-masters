// AllGoals.js

import React from 'react';
import '../../styles/Goals/goals-view.css';
import List from '../List/List';

const AllGoals = ({ listData }) => {
    return (
        <div className="goals-container">
            <List items={listData} />
        </div>
    );
};

export default AllGoals;