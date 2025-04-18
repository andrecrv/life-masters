import './DashNav.css'; // modulate style here

const MenuButton = ({ text, icon, active, onClick }) => {

    const btnClassName = active ? "menu-btn active" : "menu-btn";

    return (
        <button type="button" className={btnClassName} onClick={onClick} >
            {icon && <span>{icon}</span>}
            <span className="label">{text}</span>
        </button>
    );
}

export default MenuButton;