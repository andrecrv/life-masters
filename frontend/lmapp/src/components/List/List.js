// List.js

import React from 'react';

import ListItem from '../ListItem/ListItem';
import './list-style.css';

const List = ({ list, updateItem, deleteItem }) => {

    return (
        <div className="list-container">
            {list.map(item => (
                <ListItem key={item.id} item={item} updateItem={updateItem} deleteItem={deleteItem} />
            ))}
        </div>
    );
};

export default List;