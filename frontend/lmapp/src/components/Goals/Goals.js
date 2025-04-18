import FlagIcon from '@mui/icons-material/Flag';

import ListView from '../ListView/ListView';
import useMockData from '../../hooks/useMockData';
import './Goals.css';

const Goals = () => {
    const { mockGoals } = useMockData();

    return (
        <div className='main-container'>
            <ListView data={mockGoals} headerIcon={FlagIcon} header="Goals" />
        </div>
    );
};

export default Goals;