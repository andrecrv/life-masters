// Guide.js

import React from 'react';
import '../../styles/Guide/guide.css'
import DynamicHeader from '../DynamicHeader';
import GuideIcon from '@mui/icons-material/CloudUploadSharp';


const Guide = () => {
    return (
        <div className='guide-container'>
            <DynamicHeader icon={GuideIcon} title={"Guide"}/>
        </div>
    );
};

export default Guide;