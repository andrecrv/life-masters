import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
/*import { NavigationOutlined } from '@mui/icons-material';*/

import NavButton from './NavButton';
// import Overview from '../Overview/Overview';
import Tasks from '../Tasks/Tasks';
import Goals from '../Goals/Goals';
// import Challenges from '../Challenges/Challenges';
// import Knowledge from '../Knowledge/Knowledge';
import Guide from '../Guide/Guide';
// import Friends from '../Friends/Friends';
// import Achievements from '../Achievements/Achievements';
import useAuth from '../../hooks/useAuth';
import styles from './Nav.module.scss';

const Nav = ({ buttons, handleView }) => {
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
    };

    const handleButtonClick = (text) => {
        setActiveButton(text);
        handleView(componentMapping[text]);
    };

    return (
        <div className={styles.nav}>
            {buttons.map((button) => (
                <NavButton
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

export default Nav;