// DashboardPage.js

import React, { useState } from 'react';

import '../styles/dashboardPage.css';
import DashNav from '../components/DashNav/DashNav';
import DashView from '../components/DashView';
import TodoList from '../components/ToDoList/TodoList';

function DashboardPage() {

    const [view, setView] = useState(<TodoList />);

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