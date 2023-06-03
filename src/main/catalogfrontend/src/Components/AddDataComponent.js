import React, { useState } from 'react';
import axios from 'axios';

function AddDataComponent() {
    const [data, setFormData] = useState({
        name: '',
        page: '',
        scale: '',
        progress: '',
    });

    const handleInputChange = (event) => {
        setFormData({ ...data, [event.target.name]: event.target.value });
    };

    const handleSubmit = (event) => {
        event.preventDefault();

        axios
            .post('http://localhost:8080/miniatures', data)
            .then((response) => {
                console.log(response.data);
                const newMiniatureId = response.data.id + 1;
                const url = `http://localhost:3000/miniatures/${newMiniatureId}`;
                setFormData({ name: '', page: url, scale: '', progress: '' });
            })
            .catch((error) => {
                console.error('Error adding data:', error);
            });

    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                name="name"
                value={data.name || ''}
                onChange={handleInputChange}
                placeholder="Name"
            />
            <input
                type="text"
                name="scale"
                value={data.scale || ''}
                onChange={handleInputChange}
                placeholder="Scale"
            />
            <input
                type="text"
                name="progress"
                value={data.progress || ''}
                onChange={handleInputChange}
                placeholder="Progress"
            />
            <button type="submit" >Add Data</button>
        </form>
    );
}

export default AddDataComponent;