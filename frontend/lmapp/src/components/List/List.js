// List.js

import React from 'react';
import './list-style.css';
import ListItem from '../ListItem/ListItem';
import SimpleBar from 'simplebar-react';

const List = ({ items }) => {

    return (
        <div className="list-container">
            {/*<SimpleBar forceVisible="y"
                autoHide={false}
                style={{
                    maxHeight: 300,
                }} >*/}

            {items.map((item, index) => (
                <ListItem key={index} item={item} />
            ))}

            {/*</SimpleBar> */}
        </div>
    );
};

export default List;