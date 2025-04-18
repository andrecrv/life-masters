import EditableItem from '../EditableItem/EditableItem';
import './List.css';

const List = ({ list, updateItem, editItem, deleteItem }) => {

    return (
        <div className="list-container">
            {list.map(item => (
                <EditableItem key={item.id} item={item} updateItem={updateItem} editItem={editItem} deleteItem={deleteItem} />
            ))}
        </div>
    );
};

export default List;