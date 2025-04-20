import IconButton from '@mui/material/IconButton';

const ActionButton = ({ icon: IconComponent, color = 'defaultColor', size, backgroundColor = 'defaultBackgroundColor', onClick }) => {

  const buttonStyle = {
    backgroundColor: backgroundColor,
    color: color
  };

  return (
    <IconButton style={buttonStyle} aria-label="Icon" onClick={onClick}>
      <IconComponent sx={{ fontSize: size }} />
    </IconButton>
  );
};

export default ActionButton;
