import React, { useState } from 'react';
import axios from 'axios';

function AddImageComponent({ miniature }) {

    const [formData, setFormData] = useState({
        image: '',
        miniatureId: miniature.id,
    });

    const handleImageUpload = (event) => {
        const file = event.target.files[0];
        const reader = new FileReader();

        reader.onload = () => {
            const base64String = reader.result.split(',')[1];
            setFormData((prevFormData) => ({
                ...prevFormData,
                image: base64String,
                miniatureId: miniature.id,
            }));
        };

        reader.readAsDataURL(file);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            await axios.post('http://localhost:8080/images', formData, {
                headers: { 'Content-Type': 'application/json' },
            });
        } catch (error) {
            console.error('Error adding data:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="file" accept="image/*" onChange={handleImageUpload} />
            <button type="submit">Upload Image</button>
        </form>
    );
}

export default AddImageComponent;