// Mock Data
const useMockData = () => {

    const mockTasks = [
        { id: 't1', text: 'Add new tasks to the Tasks list.', complete: true },
        { id: 't2', text: 'Create a css style for lists.', complete: false },
        { id: 't3', text: 'Create a new reusable UI for the list component.', complete: true }
    ];

    const mockGoals = [
        { id: 'g1', text: 'Complete a daily task', complete: true },
        { id: 'g2', text: 'Complete at least 4 tasks in a day', complete: true },
        { id: 'g3', text: 'Complete 10 tasks in a week', complete: true },
        { id: 'g4', text: 'Complete at least 8 tasks in a day', complete: true },
        { id: 'g5', text: 'Complete 15 tasks in a week', complete: false },
        { id: 'g6', text: 'Complete at least 12 tasks within a week', complete: false },
        { id: 'g7', text: 'Complete 20 tasks within 3 week', complete: false },
        { id: 'g8', text: 'Complete at least 2 tasks in a day', complete: false },
        { id: 'g9', text: 'Complete 25 tasks within 3 week', complete: false },
        { id: 'g10', text: 'Complete at least 10 tasks in a week', complete: false },
        { id: 'g11', text: 'Complete 30 tasks within a month', complete: false }
    ];

    return { mockTasks, mockGoals };
};

export default useMockData;