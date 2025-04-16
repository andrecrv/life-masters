// Goals.js

import React from 'react';
import FlagIcon from '@mui/icons-material/Flag';

import ListView from '../ListView/ListView';
import useList from '../../hooks/useList';
import '../../styles/Goals/goals.css';

const Goals = () => {
    const { mockList } = useList();

    return (
        <div className='main-container'>
            <ListView data={mockList} headerIcon={FlagIcon} header="Goals" />
        </div>
    );
};

export default Goals;