import PropTypes from 'prop-types';
import ActionButton from './ActionButton';
import styles from './DynamicHeader.module.scss';

const DynamicHeader = ({ icon: Icon, title, iconSize = '36px', iconColor = 'white' }) => {
    return (
        <div className={styles.header}>
            <div className={styles.header__title}>
                <span><ActionButton icon={Icon} size={iconSize} color={iconColor} /></span>
                <span>{title}</span>
            </div>
        </div>
    );
};

DynamicHeader.propTypes = {
    icon: PropTypes.elementType.isRequired, // Icon component
    title: PropTypes.string.isRequired,     // Title text
    iconSize: PropTypes.string,             // Size of the icon
    iconColor: PropTypes.string,            // Color of the icon
};

export default DynamicHeader;