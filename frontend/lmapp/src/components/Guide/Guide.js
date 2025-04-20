import Info from '@mui/icons-material/Info';

import DynamicHeader from '../common/DynamicHeader';
import GuideLayout from './GuideLayout';

const Guide = () => {
    return (
        <>
            <DynamicHeader icon={Info} title={"Guide"} />
            <GuideLayout />
        </>
    );
};

export default Guide;