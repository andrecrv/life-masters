import styles from './UserProfile.module.scss';

const UserProfile = ({ user, icon }) => {

    return (
        <div className={styles.profile} >
            <img className={styles.profile__icon} src={icon} alt="User profile" />
            <div className={styles.profile__username}>{user.username}</div>
            <div className={styles.profile__title}>{user.title}</div>
            <div className={styles.profile__level}>Lvl. {user.level}</div>
        </div>
    );
};

export default UserProfile;