import React, { useState } from 'react';
import axios from 'axios';

function AddImageComponent({ miniature }) {

    const [formData, setFormData] = useState({
        id: '',
        image: '',
        miniature_id: miniature.id,
    });

    const handleImageUpload = (event) => {
        const file = event.target.files[0];
        const reader = new FileReader();

        reader.onload = () => {
            const base64String = reader.result.split(',')[1];
            setFormData((prevFormData) => ({
                ...prevFormData,
                id: miniature.id,
                image: base64String,
                miniature_id: miniature.id,
            }));
        };

        reader.readAsDataURL(file);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            console.log(formData);
            const response = await axios.post('http://localhost:8080/images', formData, {
                headers: { 'Content-Type': 'application/json' },
            });
            console.log(response);
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