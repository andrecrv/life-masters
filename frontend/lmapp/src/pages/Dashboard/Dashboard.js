import { useState } from 'react';

import DashNav from '../../components/DashLayout/DashNav';
import DashView from '../../components/DashLayout/DashView';
import Tasks from '../../components/Tasks/Tasks';
import styles from './Dashboard.module.scss';

function Dashboard() {
    const [view, setView] = useState(<Tasks />);

    const updateView = (newView) => {
        setView(newView);
    }

    return (
        <div className={styles.dashboard}>
            <DashNav handleView={updateView} />
            <DashView view={view} />
        </div>
    );
}

export default Dashboard;