import AssignmentIcon from '@mui/icons-material/Assignment';

import ListView from '../ListView/ListView';
import useMockData from '../../hooks/useMockData';

const Tasks = () => {
    const { mockTasks } = useMockData();

    return (
        <div className='main-container'>
            <ListView data={mockTasks} headerIcon={AssignmentIcon} header="Tasks" />
        </div>
    );
};

export default Tasks;