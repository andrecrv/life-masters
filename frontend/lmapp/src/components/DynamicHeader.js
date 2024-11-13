import React from 'react';
import PropTypes from 'prop-types';
import ActionButton from './common/ActionButton';

const DynamicHeader = ({ icon: Icon, title, iconSize = '36px', iconColor = 'white' }) => {
    return (
        <div className='header-container'>
            <div className="header-title">
                <ActionButton icon={Icon} size={iconSize} color={iconColor} />
                {title}
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