import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import { useParams } from "react-router-dom";
import AddImageComponent from './AddImageComponent';
import DisplayImageComponent from './DisplayImageComponent';

function MiniatureDetail() {

  const { id } = useParams();
  const [miniature, setMiniature] = useState(null);
  const [updatedData, setUpdatedData] = useState({});

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/user/miniatures/${id}`)
      .then((response) => {
        setMiniature(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error('Error fetching miniature:', error);
      });
  }, [id]);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setUpdatedData({ ...updatedData, [name]: value });
  };

  const handleUpdate = () => {
    const updatedMiniature = { ...miniature, ...updatedData };

    axios.put(`http://localhost:8080/api/user/miniatures/${id}`, updatedMiniature)
      .then((response) => {
        console.log("Miniature updated:", response.data);
        setMiniature(response.data);
      })
      .catch((error) => {
        console.error('Error updating miniature:', error);
      })
  };

  if (!miniature) {
    return <div>Loading...</div>
  }

  return (
    <div>
      <h2>Miniature Detail</h2>
      <p>ID: {miniature.id}</p>
      <p>
        Name:
        <input
          type="text"
          name="name"
          value={updatedData.miniature_name || miniature.miniature_name}
          onChange={handleInputChange}
        />
      </p>
      <p>
        Scale:
        <input
          type="text"
          name="scale"
          value={updatedData.scale || miniature.scale}
          onChange={handleInputChange}
        />
      </p>
      <p>
        Progress:
        <input
          type="text"
          name="progress"
          value={updatedData.progress || miniature.progress}
          onChange={handleInputChange}
        />
      </p>
      <div>
        <AddImageComponent miniature={miniature} />
      </div>
      <button onClick={handleUpdate}>Update</button>
      <Link to={`/miniatures`}>
        <button>Go Back to Menu</button>
      </Link>
      <DisplayImageComponent miniature={miniature} />
    </div>
  );
}

export default MiniatureDetail;
