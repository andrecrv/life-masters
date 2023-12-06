// Buttons.js
import React from "react";
import ButtonView from "./ButtonView";

const Buttons = ({ setActiveComponent, activeComponent }) => {
  return (
    <div className="button-container">
      <ButtonView className="buttonView" text={"Introduction"}  onClick={() => setActiveComponent('Introduction')} active={activeComponent === 'Introduction'}/>
            <ButtonView className="buttonView" text={"Features"}  onClick={() => setActiveComponent('Features')} active={activeComponent === 'Features'}/>
            <ButtonView className="buttonView" text={"Ranking System"}  onClick={() => setActiveComponent('RankingSystem')} active={activeComponent === 'RankingSystem'}/>
            <ButtonView className="buttonView" text={"Feedback & Support"}  onClick={() => setActiveComponent('FeedbackSupport')} active={activeComponent === 'FeedbackSupport'}/>
            <ButtonView className="buttonView" text={"Q&A"}  onClick={() => setActiveComponent('Q&A')} active={activeComponent === 'Q&A'}/>    
    </div>
  );
};

export default Buttons;
