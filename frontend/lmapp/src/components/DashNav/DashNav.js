// DashNav.js -> Dashboard Navigation

import React from 'react';
//import fetchData from '../utils/api';
//import useAuth from '../hooks/useAuth';
import '../../styles/DashNav/dashNav.css';
import Menu from './Menu';
import UserProfile from './UserProfile';

// Retrieving user data from localStorage
const storedUserData = localStorage.getItem('userData');
// Parsing the stored data back into a JavaScript object
const userData = JSON.parse(storedUserData);

const DashNav = ({ handleView }) => {

    const userIcon = '/resources/icons/icon8.jpg';
    const userDao = {
        username: 'user_not_found',
        title: 'Unfoundable',
        level: '+9999',
    }

    const user = userData ? userData : userDao;

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
            <UserProfile user={user} icon={userIcon} />
            <Menu buttons={buttonList} handleView={handleView} />
        </div>
    );
}

export default DashNav;