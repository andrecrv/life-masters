// Guide.js

import React from 'react';
import DynamicHeader from '../DynamicHeader';
import GuideLayout from './GuidedLayout';
import GuideIcon from '@mui/icons-material/CloudUploadSharp';
import '../../styles/Guide/guide.css'

const Guide = () => {
    return (
        <div className='main-container'>
            <DynamicHeader icon={GuideIcon} title={"Guide"}/>
            <GuideLayout />
        </div>
    );
};

export default Guide;