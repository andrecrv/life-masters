// AllGoals.js

import React from 'react';
import '../../styles/Goals/goals-view.css';
import ListItem from '../ListItem/ListItem';

const AllGoals = () => {
    return (
        <div className="goals-container">
            <ListItem text="Complete a daily task" />
        </div>
    );
};

export default AllGoals;