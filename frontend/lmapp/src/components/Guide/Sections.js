import SectionButton from "./SectionButton";
import styles from './Sections.module.scss';

const Sections = ({ setActiveComponent, activeComponent }) => {
  return (
    <div className={styles.sections}>
      <SectionButton text={"Introduction"} onClick={() => setActiveComponent('Introduction')} active={activeComponent === 'Introduction'} />
      <SectionButton text={"Features"} onClick={() => setActiveComponent('Features')} active={activeComponent === 'Features'} />
      <SectionButton text={"Ranking System"} onClick={() => setActiveComponent('RankingSystem')} active={activeComponent === 'RankingSystem'} />
      <SectionButton text={"Feedback & Support"} onClick={() => setActiveComponent('FeedbackSupport')} active={activeComponent === 'FeedbackSupport'} />
      <SectionButton text={"Q&A"} onClick={() => setActiveComponent('Q&A')} active={activeComponent === 'Q&A'} />
    </div>
  );
};

export default Sections;
