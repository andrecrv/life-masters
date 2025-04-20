import { useState } from "react";

import Introduction from './Introduction';
import Sections from "./Sections";
import styles from './GuideLayout.module.scss';

const GuideLayout = () => {
    const [activeComponent, setActiveComponent] = useState(null);

    const renderView = () => {
        switch (activeComponent) {
            case 'Introduction':
                return <Introduction />;
            case 'Features':
                return //<Features />;
            case 'RankingSystem':
                return //<RankingSystem />;
            case 'FeedbackSupport':
                return //<FeedbackSupport />;
            case 'Q&A':
                return //<QA />;  
            default:
                return null;
        }
    };

    return (
        <div className={styles.guide}>
            <Sections setActiveComponent={setActiveComponent} />
            {renderView()}
        </div>
    );
};

export default GuideLayout;