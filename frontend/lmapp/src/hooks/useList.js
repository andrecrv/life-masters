//useList.js

import React, { useState } from 'react';

const useList = () => {

    const changeStatus = (index, itemStatus) => {
        listData[index].status = itemStatus;
        console.log(index + ': ' + itemStatus);
    };

    const listData = [
        { text: 'Complete a daily task', status: 'pending', },
        { text: 'Complete at least 4 tasks in a day', status: 'completed', },
        { text: 'Complete 10 tasks in a week', status: 'pending', },
        { text: 'Complete at least 8 tasks in a day', status: 'completed', },
        { text: 'Complete 15 tasks in a week', status: 'pending', },
        { text: 'Complete at least 12 tasks within a week', status: 'pending', },
        { text: 'Complete 20 tasks within 3 week', status: 'pending', },
        { text: 'Complete at least 2 tasks in a day', status: 'pending', },
        { text: 'Complete 25 tasks within 3 week', status: 'pending', },
        { text: 'Complete at least 10 tasks in a week', status: 'pending', },
        { text: 'Complete 30 tasks within a month', status: 'pending', },
    ];

    return { listData, changeStatus };
};

export default useList;