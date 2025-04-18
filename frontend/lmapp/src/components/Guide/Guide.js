import GuideIcon from '@mui/icons-material/CloudUploadSharp';

import DynamicHeader from '../common/DynamicHeader';
import GuideLayout from './GuideLayout';
import './Guide.css'

const Guide = () => {
    return (
        <div className='main-container'>
            <DynamicHeader icon={GuideIcon} title={"Guide"} />
            <GuideLayout />
        </div>
    );
};

export default Guide;