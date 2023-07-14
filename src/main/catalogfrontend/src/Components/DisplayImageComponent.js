import React, { useState, useEffect } from 'react';
import axios from 'axios';

function DisplayImageComponent({ miniature }) {
  const [images, setImages] = useState([]);

  useEffect(() => {
    createImages();
  }, [miniature]);

  const createImages = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/api/miniatures/${miniature.id}/images`);
      setImages(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div>
      <h2>Images:</h2>
      {images.map((image) => (
        <img key={image.imageId} src={`data:image/*;base64,${image.url}`} alt="Miniature" />
      ))}
    </div>
  );
}

export default DisplayImageComponent;
