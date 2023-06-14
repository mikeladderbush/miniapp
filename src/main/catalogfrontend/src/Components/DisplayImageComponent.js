import React, { useState, useEffect } from 'react';
import axios from 'axios';

function DisplayImageComponent() {
  const [imageUrl, setImageUrl] = useState('');

  useEffect(() => {
    createImage();
  }, []);

  const createImage = async () => {
    axios.get(`http://localhost:8080/images/20`)
      .then(response => {
        const imageUrl = `data:image/jpeg;charset=utf-8;base64,${response.data.image}`;
        setImageUrl(imageUrl);
      })
      .catch(error => {
        console.log(error);
      });
  }

  return (
    <div>
      <h2>Images:</h2>
      {imageUrl ? (
        <img
          src={imageUrl}
          alt="not loading..."
          style={{ width: '100%', height: 'auto' }}
        />
      ) : (
        <p>Loading image...</p>
      )}
    </div>
  );
}



export default DisplayImageComponent;
