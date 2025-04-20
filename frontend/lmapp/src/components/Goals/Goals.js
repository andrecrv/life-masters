import Flag from '@mui/icons-material/Flag';

import DynamicHeader from '../common/DynamicHeader';
import ListView from '../ListView/ListView';
import useMockData from '../../hooks/useMockData';

const Goals = () => {
    const { mockGoals } = useMockData();

    return (
        <>
            <DynamicHeader icon={Flag} title={"Goals"} />
            <ListView data={mockGoals} />
        </>
    );
};

export default Goals;