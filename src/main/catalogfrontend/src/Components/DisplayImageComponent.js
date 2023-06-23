import React, { useState, useEffect } from 'react';
import axios from 'axios';

function DisplayImageComponent({ miniature }) {
  const [images, setImages] = useState([]);

  useEffect(() => {
    createImage();
  }, [miniature]);

  const createImage = async () => {
    axios.get(`http://localhost:8080/miniatures/${miniature.id}`)
      .then(response => {
        console.log(response.data.images);
        setImages(response.data.images);
      })
      .catch(error => {
        console.log(error);
      });
  };

  const convertImage = (image) => {
    const convertedImage = {
      ...image,
      image: `data:image/jpeg;charset=utf-8;base64,${miniature.image}`,
    };
    return convertImage;
  }

  return (
    <div>
      <h2>Images:</h2>
    </div>
  );
}



export default DisplayImageComponent;
