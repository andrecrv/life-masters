import React from 'react';
import Assignment from '@mui/icons-material/Assignment';
import Flag from '@mui/icons-material/Flag';
import Info from '@mui/icons-material/Info';
import Settings from '@mui/icons-material/Settings';
import Logout from '@mui/icons-material/Logout';

import Menu from './Menu';
import UserProfile from './UserProfile';
//import fetchData from '../utils/api';
//import useAuth from '../hooks/useAuth';
import '../../styles/DashNav/dashNav.css';

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
        // { text: 'Overview' },
        { text: 'Tasks', icon: <Assignment /> },
        { text: 'Goals', icon: <Flag /> },
        // { text: 'Challenges' },
        // { text: 'Knowledge' },
        { text: 'Guide', icon: <Info /> },
        // { text: 'Friends' },
        // { text: 'Achievements' },
        // { text: 'Settings' },
        { text: 'Logout', icon: <Logout /> },
    ];

    return (
        <div className="nav">
            <UserProfile user={user} icon={userIcon} />
            <Menu buttons={buttonList} handleView={handleView} />
        </div>
    );
}

export default DashNav;