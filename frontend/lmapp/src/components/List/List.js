import EditableItem from '../EditableItem/EditableItem';
import styles from './List.module.scss';

const List = ({ items, itemType, updateItem, editItem, deleteItem }) => {

    const listStyle = `${styles.list} ${items.length > 0 ? '' : styles['list--empty']}`

    return (
        <div className={listStyle}>
            {items.length === 0 ? (
                <span>No {itemType}s yet. Ready for your first quest?</span>
            ) : (
                items.map(item => (
                    <EditableItem
                        key={item.id}
                        item={item}
                        updateItem={updateItem}
                        editItem={editItem}
                        deleteItem={deleteItem}
                    />
                ))
            )}
        </div>
    );
};

export default List;