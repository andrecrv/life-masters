//useList.js

import React from 'react';


const useList = () => {

    const mockList = [
        { id: 1, text: 'Complete a daily task', complete: true },
        { id: 2, text: 'Complete at least 4 tasks in a day', complete: true },
        { id: 3, text: 'Complete 10 tasks in a week', complete: true },
        { id: 4, text: 'Complete at least 8 tasks in a day', complete: true },
        { id: 5, text: 'Complete 15 tasks in a week', complete: false },
        { id: 6, text: 'Complete at least 12 tasks within a week', complete: false },
        { id: 7, text: 'Complete 20 tasks within 3 week', complete: false },
        { id: 8, text: 'Complete at least 2 tasks in a day', complete: false },
        { id: 9, text: 'Complete 25 tasks within 3 week', complete: false },
        { id: 10, text: 'Complete at least 10 tasks in a week', complete: false },
        { id: 11, text: 'Complete 30 tasks within a month', complete: false }
    ];

    return { mockList };
};

export default useList;