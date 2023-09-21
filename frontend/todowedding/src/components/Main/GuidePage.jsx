import React from 'react';
import { useParams } from 'react-router-dom';

//Guide Image
import Guide1 from "../../assets/images/Guide1.png";
import Guide2 from "../../assets/images/Guide2.png";
import Guide3 from "../../assets/images/Guide2.png";
import Guide4 from "../../assets/images/Guide2.png";
import Guide5 from "../../assets/images/Guide2.png";
const GuidePage = () => {
    const { id } = useParams();
    const images = [Guide1, Guide2, Guide3, Guide4, Guide5];

    return (
        <div>
        <img src={images[Number(id) - 1]} alt={`Image${id}`} />
    </div>
    );
};

export default GuidePage;