import React from 'react';
import FlagIcon from '@mui/icons-material/Flag';
import MyIcon from '../Icons/MyIcon';
import '../../styles/Goals/goalsHeader.css';

const GoalsHeader = () => {
    return (
        <div className='header-container'>
            <div className="header-title">
                <MyIcon icon={FlagIcon} size="36px" color="white" />
                GOALS
            </div>
        </div>
    );
};

export default GoalsHeader;