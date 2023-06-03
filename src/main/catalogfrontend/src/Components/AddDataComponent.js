import React, { useState, useEffect } from 'react';
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

    async function urlGeneration() {

        try {
            const response = await axios.get('http://localhost:8080/miniatures');
            const miniatures = response.data;
            miniatures.sort((a, b) => b.id - a.id);
            const newMiniatureId = miniatures[0].id;
            const url = `http://localhost:3000/miniatures/${newMiniatureId}`;
            console.log(url);
            return url;
        } catch (error) {
            console.error('Error fetching miniatures:', error);
        }
    }

    useEffect(() => {
        const setDefaultUrl = async () => {
          const url = await urlGeneration();
          setFormData((prevState) => ({ ...prevState, page: url }));
        };
    
        setDefaultUrl();
      }, []);

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const response = await axios.post('http://localhost:8080/miniatures', data);
            console.log(response.data);
            const url = await urlGeneration();
            setFormData((prevState) => ({ ...prevState, page: url }));
        } catch (error) {
            console.error('Error adding data:', error);
        }
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