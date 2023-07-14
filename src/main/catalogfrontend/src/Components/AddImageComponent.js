import React, { useState } from 'react';
import axios from 'axios';

function AddImageComponent({ miniature }) {

    const [imageData, setImageData] = useState(null);

    const handleImageUpload = (event) => {
        const file = event.target.files[0];
        const reader = new FileReader();

        reader.onload = () => {
            const base64String = reader.result.split(',')[1];
            setImageData(base64String);
        };

        reader.readAsDataURL(file);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            await axios.post(`http://localhost:8080/api/miniatures/${miniature.id}/images`, imageData, {
                headers: { 'Content-Type': 'application/json' },
            });
            setImageData(null);
        } catch (error) {
            console.error('Error adding data:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="file" accept="image/*" onChange={handleImageUpload} />
            <button type="submit" disabled={!imageData}>Upload Image</button>
        </form>
    );
}

export default AddImageComponent;