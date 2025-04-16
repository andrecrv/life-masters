import React, { useState } from 'react';

import '../styles/dashboardPage.css';
import DashNav from '../components/DashNav/DashNav';
import DashView from '../components/DashView';
import Tasks from '../components/Tasks/Tasks';

function DashboardPage() {
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

export default DashboardPage;