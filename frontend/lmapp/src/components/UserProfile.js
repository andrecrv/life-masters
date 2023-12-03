// UserProfile.js

import React from "react";


const UserProfile = ({ user }) => {

    return (
        <div className="profile-container" >
            <img src={user.icon} alt="Profile image" className="profile-icon" />
            <div className="username">{user.username}</div>
            <div className="user-title">{user.title}</div>
            <div className="user-level">Lvl. {user.lvl}</div>
        </div>
    );
};

export default UserProfile;