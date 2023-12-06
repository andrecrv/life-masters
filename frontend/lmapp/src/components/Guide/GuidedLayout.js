import React, { useState } from "react";

import Introduction from './Introduction';
import Buttons from "./Buttons";
import '../../styles/Guide/guideLayout.css';


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
    <div className="guide-body-container">
        <Buttons setActiveComponent={setActiveComponent}/>
        {renderView()}
    </div>
  );
};

export default GuideLayout;