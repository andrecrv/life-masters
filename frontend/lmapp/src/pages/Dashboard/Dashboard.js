import { useState } from 'react';

import DashNav from '../../components/DashLayout/DashNav';
import DashView from '../../components/DashLayout/DashView';
import Tasks from '../../components/Tasks/Tasks';
import './Dashboard.css';

function Dashboard() {
    const [view, setView] = useState(<Tasks />);

    const updateView = (newView) => {
        setView(newView);
    }

    return (
        <div className="page">
            {/*CALLING THE NAVIGATION MENU*/}
            <DashNav handleView={updateView} />
            <DashView view={view} />
        </div>
    );
}

export default Dashboard;