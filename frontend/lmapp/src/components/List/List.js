// List.js

import React from 'react';
import './list-style.css';
import ListItem from '../ListItem/ListItem';
//import SimpleBar from 'simplebar-react';

const List = ({ list, updateList }) => {

    return (
        <div className="list-container">
            {/*<SimpleBar forceVisible="y"
                autoHide={false}
                style={{
                    maxHeight: 300,
                }} >*/}

            {list.map(item => (
                <ListItem key={item.id} id={item.id} text={item.text} isCompleted={item.complete} updateItem={updateList} />
            ))}

            {/*</SimpleBar> */}
        </div>
    );
};

export default List;