import { useNavigate } from 'react-router-dom';
import Assignment from '@mui/icons-material/Assignment';
import Flag from '@mui/icons-material/Flag';
import Info from '@mui/icons-material/Info';
import Settings from '@mui/icons-material/Settings';
import Logout from '@mui/icons-material/Logout';

import Nav from './Nav';
import UserProfile from './UserProfile';
import UtilityButton from '../common/UtilityButton/UtilityButton';
//import fetchData from '../utils/api';
import { useAuth } from '../../context/AuthContext';
import styles from './DashNav.module.scss';

const DashNav = ({ handleView }) => {
    const navigate = useNavigate();
    const { user, logout } = useAuth();

    const userIcon = '/resources/icons/icon8.jpg';
    
    // const userDao = {
    //     username: 'user_not_found',
    //     title: 'Unfoundable',
    //     level: '+9999',
    // }

    const buttonList = [
        // { text: 'Overview' },
        { text: 'Tasks', icon: <Assignment /> },
        { text: 'Goals', icon: <Flag /> },
        // { text: 'Challenges' },
        // { text: 'Knowledge' },
        { text: 'Guide', icon: <Info /> },
        // { text: 'Friends' },
        // { text: 'Achievements' },
    ];

    const handleLogout = () => {
        // TODO: Add confirmation modal later
        logout();
        navigate('/signin');
    }

    return (
        <div className={styles.dashNav}>
            <UserProfile user={user} icon={userIcon} />
            <Nav buttons={buttonList} handleView={handleView} />

            <div className={styles.dashNav__utils}>
                <span className={styles.dashNav__utils__button}>
                    <UtilityButton icon={Settings} />
                </span>
                <span className={styles.dashNav__utils__button}>
                    <UtilityButton icon={Logout} onClick={handleLogout} />
                </span>
            </div>
        </div>
    );
}

export default DashNav;