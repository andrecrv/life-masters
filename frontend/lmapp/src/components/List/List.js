import EditableItem from '../EditableItem/EditableItem';
import styles from './List.module.scss';

const List = ({ list, updateItem, editItem, deleteItem }) => {

    return (
        <div className={styles.list}>
            {list.map(item => (
                <EditableItem
                    key={item.id}
                    item={item}
                    updateItem={updateItem}
                    editItem={editItem}
                    deleteItem={deleteItem}
                />
            ))}
        </div>
    );
};

export default List;