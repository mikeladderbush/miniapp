import React, { useState, useEffect } from 'react';
import axios from 'axios';

function DisplayImageComponent({ miniature }) {
  const [images, setImages] = useState([]);

  useEffect(() => {
    createImage();
  }, [miniature]);

  const createImage = async () => {
    axios.get(`http://localhost:8080/images`)
      .then(response => {
        setImages(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  };

  const filteredImages = images.filter((image) => image.miniatureId === miniature);
  const imageDataString = filteredImages.map((image) => `data:image/jpeg;charset=utf-8;base64,${image.image}`);

  return (
    <div>
      <h2>Images:</h2>
      {filteredImages.length > 0 ? (
        <ul>
          {filteredImages
            .map((image) => {
              <li key={image.id}>
                <img
                  src={imageDataString}
                  alt="not loading..."
                  style={{ width: '100%', height: 'auto' }}
                />
              </li>
            })}
        </ul>
      ) : (
        <p>Loading image...</p>
      )}
    </div>
  );
}



export default DisplayImageComponent;
