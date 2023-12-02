// DashNav.js -> Dashboard Navigation

import React from 'react';
//import fetchData from '../utils/api';
//import useAuth from '../hooks/useAuth';
import '../styles/dashNav.css';
import Menu from './Menu';

const DashNav = () => {

    const buttonList = [
        { text: 'Todo List' },
        { text: 'Mastery' },
        { text: 'Settings' },
        { text: 'Logout' },
        
    ];

    return (
        <div className="nav">
            <div className="nav-head">
                User Info
            </div>
            <Menu buttons={buttonList} />
        </div>
    );
}

export default DashNav;