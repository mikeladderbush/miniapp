import React, { useState, useEffect } from 'react';
import axios from 'axios';

function DisplayImageComponent() {
  const [imageData, setImageData] = useState('');

  useEffect(() => {
    fetchImageData();
  }, []);

  const fetchImageData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/images'); // Replace with your API endpoint
      const { image } = response.data;

      setImageData(image);
    } catch (error) {
      console.error('Error fetching image data:', error);
    }
  };

  const decodeBase64 = (base64String) => {
    const decodedData = window.atob(base64String);
    return decodedData;
  };

  return (
    <div>
      {imageData && (
        <img
          src={`data:image/jpeg;base64,${decodeBase64(imageData)}`}
          alt="Image"
        />
      )}
    </div>
  );
}

export default DisplayImageComponent;
