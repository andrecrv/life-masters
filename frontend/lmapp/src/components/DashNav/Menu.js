import React, { useState } from 'react';
/*import { NavigationOutlined } from '@mui/icons-material';*/

import { useNavigate } from 'react-router-dom';
import MenuButton from './MenuButton';
// import Overview from '../Overview/Overview';
import Tasks from '../Tasks/Tasks';
import Goals from '../Goals/Goals';
// import Challenges from '../Challenges/Challenges';
// import Knowledge from '../Knowledge/Knowledge';
import Guide from '../Guide/Guide';
// import Friends from '../Friends/Friends';
// import Achievements from '../Achievements/Achievements';
// import Settings from '../Settings/Settings';
import Logout from '../Logout/Logout';
import useAuth from '../../hooks/useAuth';

const Menu = ({ buttons, handleView }) => {
    const [activeButton, setActiveButton] = useState(buttons[0].text);
    const navigate = useNavigate();
    const { logout } = useAuth();

    // Map other button texts to their corresponding components
    const componentMapping = {
        // 'Overview': Overview,
        'Tasks': Tasks,
        'Goals': Goals,
        // 'Challenges': Challenges,
        // 'Knowledge': Knowledge,
        'Guide': Guide,
        // 'Friends': Friends,
        // 'Achievements': Achievements,
        // 'Settings': Settings,
        'Logout': Logout
    };

    const handleLogout = () => {
        logout();
        navigate('/signin');
    }

    const handleButtonClick = (text) => {
        setActiveButton(text);
        if (text === 'Logout') {
            handleLogout();
        } else {
            handleView(componentMapping[text]);
        }
    };

    return (
        <div className="menu-container">
            {buttons.map((button) => (
                <MenuButton
                    key={button.text}
                    icon={button.icon}
                    text={button.text}
                    active={activeButton === button.text}
                    onClick={() => handleButtonClick(button.text)}
                />
            ))}
        </div>
    );
};

export default Menu;