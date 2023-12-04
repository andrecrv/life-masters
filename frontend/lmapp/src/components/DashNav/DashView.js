// PageView.js - Display todos, overview,...

import React from 'react';

const DashView = ({ view }) => {

    return (
        <div className="view-container">
            {/* Display the a view */}
            {view}
        </div>
    );
};

export default DashView;