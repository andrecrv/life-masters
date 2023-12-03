// DashNav.js -> Dashboard Navigation

import React from 'react';
//import fetchData from '../utils/api';
//import useAuth from '../hooks/useAuth';
import '../styles/dashNav.css';
import Menu from './Menu';
import UserProfile from './UserProfile';

const DashNav = () => {

    const userDao = {
        icon: '/resources/icons/icon8.jpg',
        username: 'user_not_found',
        title: 'Unfoundable',
        lvl: '+9999',
    }

    const buttonList = [
        { text: 'Overview' },
        { text: 'Todo List' },
        { text: 'Goals' },
        { text: 'Challenges' },
        { text: 'Knowledge' },
        { text: 'Guide' },
        { text: 'Friends' },
        { text: 'Achievements' },
        { text: 'Settings' },
        { text: 'Logout' },
    ];

    return (
        <div className="nav">
            <UserProfile user={userDao} />
            <Menu buttons={buttonList} />
        </div>
    );
}

export default DashNav;