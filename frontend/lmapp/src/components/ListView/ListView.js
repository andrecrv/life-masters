import { useState, useMemo, useEffect } from "react";

import List from '../List/List';
import FilterTab from "./FilterTab";
import ItemAdder from "./ItemAdder";
import styles from './ListView.module.scss';

const ListView = ({ data }) => {
    const [items, setItems] = useState(data);
    const [activeTab, setActiveTab] = useState('All');

    // Update items when data prop changes
    useEffect(() => {
        const sortedData = [...data].reverse();
        setItems(sortedData);
    }, [data]);

    const addItem = (text) => {
        // create a new item object
        const newItem = {
            id: items.length + 1,
            text: text,
            complete: false
        };

        if (text !== "") {
            // add new item to the list (array)
            setItems([newItem, ...items]);
            //console.log('item added');
        }
    }

    const editItem = (id, text) => {
        setItems(items.map(item => {
            return item.id === id ? { ...item, text: text } : { ...item };
        }));
    }

    const updateItem = (id) => {
        setItems(items.map(item => {
            return item.id === id ? { ...item, complete: !item.complete } : { ...item };
        }));
    }

    const deleteItem = (id) => {
        setItems(items.filter(item => item.id !== id));
    }

    const filteredItems = useMemo(() => {
        switch (activeTab) {
            case 'Pending':
                return items.filter(item => item.complete === false);
            case 'Completed':
                return items.filter(item => item.complete === true);
            default:
                return items;
        }
    }, [activeTab, items]);

    return (
        <>
            <div className={styles.listToolbar}>
                <div className={styles.listToolbar__filterTabs}>
                    <FilterTab text="All" onClick={() => setActiveTab('All')} active={activeTab === 'All'} />
                    <FilterTab text="Pending" onClick={() => setActiveTab('Pending')} active={activeTab === 'Pending'} />
                    <FilterTab text="Completed" onClick={() => setActiveTab('Completed')} active={activeTab === 'Completed'} />
                </div>
                <ItemAdder addItem={addItem} />
            </div>
            <div className={styles.list}>
                <div className={styles.list__itemList}>
                    <List list={filteredItems} updateItem={updateItem} editItem={editItem} deleteItem={deleteItem} />
                </div>
            </div>
        </>
    );
};

export default ListView;