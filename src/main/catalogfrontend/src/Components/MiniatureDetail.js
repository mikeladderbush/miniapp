import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {  useSearchParams } from "react-router-dom"

function MiniatureDetail() {
    const [queryParameters] = useSearchParams()
    const id = queryParameters.get("id")
    const [miniature, setMiniature] = useState(null);

    useEffect(() => {
        axios
            .get(`http://localhost:8080/miniatures/${id}`)
            .then((response) => {
                setMiniature(response.data);
                console.log(response.data);
            })
            .catch((error) => {
                console.error('Error fetching miniature:', error);
            });
    });

    return (
        <div>
            <h2>Miniature Detail</h2>
            <p>ID: {miniature.id}</p>
            <p>Name: {miniature.name}</p>
            <p>Scale: {miniature.scale}</p>
            <p>Progress: {miniature.progress}</p>
            <p>Image: <img src={miniature.image} alt="Miniature" /></p>
        </div>
    );
}

export default MiniatureDetail;
