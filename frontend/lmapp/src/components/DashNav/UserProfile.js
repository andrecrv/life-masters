// UserProfile.js

import React from "react";

const UserProfile = ({ user, icon }) => {

    return (
        <div className="profile-container" >
            <img src={icon} alt="User profile" className="profile-icon" />
            <div className="username">{user.username}</div>
            <div className="user-title">{user.title}</div>
            <div className="user-level">Lvl. {user.level}</div>
        </div>
    );
};

export default UserProfile;