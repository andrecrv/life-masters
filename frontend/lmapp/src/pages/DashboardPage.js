// DashboardPage.js

import React, { useState } from 'react';

import '../styles/DashNav/dashboardPage.css';
import DashNav from '../components/DashNav/DashNav';
import DashView from '../components/DashView';
import Overview from '../components/Overview/Overview';

function DashboardPage() {

    const [view, setView] = useState(<Overview />);

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