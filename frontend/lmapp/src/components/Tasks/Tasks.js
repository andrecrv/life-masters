import Assignment from '@mui/icons-material/Assignment';

import DynamicHeader from '../common/DynamicHeader';
import ListView from '../ListView/ListView';
import useMockData from '../../hooks/useMockData';

const Tasks = () => {
    const { mockTasks } = useMockData();

    return (
        <>
            <DynamicHeader icon={Assignment} title={"Tasks"} />
            <ListView data={mockTasks} />
        </>
    );
};

export default Tasks;