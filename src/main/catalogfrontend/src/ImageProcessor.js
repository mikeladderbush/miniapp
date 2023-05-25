import React, { useState } from 'react';
import axios from 'axios';


const handleImageUpload = (file) => {
    const formData = new FormData();
    formData.append('image', file);

    axios.post('http://localhost:8080/miniatures/upload', formData, {
        headers: {
            'Content-Type': 'multipart/form-data',
        },
    })
        .then(response => {
            console.log(response);
        })
        .catch(error => {
            console.log(error);
        });
}

const ImageProcessor = () => {
    const handleFileChange = (event) => {
        const file = event.target.files[0];
        handleImageUpload(file);
    };

    return (
        <div>
            <input type="file" onChange={handleFileChange} />
            <button onClick={handleImageUpload}>Upload</button>
        </div>
    );

};




export default ImageProcessor;
