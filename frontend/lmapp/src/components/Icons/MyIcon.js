// MyIcon.js
import React from 'react';
import IconButton from '@mui/material/IconButton';

const MyIcon = ({ icon: IconComponent, color = 'defaultColor', backgroundColor = 'defaultBackgroundColor', onClick }) => {

  const buttonStyle = {
    backgroundColor: backgroundColor,
    color: color,
    fontSize: '40px',
    marginRight: '15px',
    marginBottom: '6px',
  };

  return (
    <IconButton style={buttonStyle} aria-label="Icon" onClick={onClick}>
      <IconComponent />
    </IconButton>
  );
};

export default MyIcon;
