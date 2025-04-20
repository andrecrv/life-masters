import styles from './DashView.module.scss';

const DashView = ({ view }) => {

    return (
        <div className={styles.dashView}>
            <div className={styles.dashView__card}>
                {view}
            </div>
        </div>
    );
};

export default DashView;