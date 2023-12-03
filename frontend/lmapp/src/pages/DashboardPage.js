// DashboardPage.js

import React from 'react';

import '../styles/dashboardPage.css';
import DashNav from '../components/DashNav';

function DashboardPage() {
    return (
        <div>
            {/*CALLING THE NAVIGATION MENU*/}
            <DashNav />
        </div>
    );
}

export default DashboardPage;