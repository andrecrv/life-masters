import React from 'react';
import FlagIcon from '@mui/icons-material/Flag';

import DynamicHeader from '../DynamicHeader';
import '../../styles/Goals/goalsHeader.css';

const GoalsHeader = () => {
    return (
        <div className='header-container'>
            <div className="header-title">
                <DynamicHeader icon={FlagIcon} title={"Goals"}/>
            </div>
        </div>
    );
};

export default GoalsHeader;