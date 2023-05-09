import React, { useState, useEffect } from 'react';
import axios from 'axios';

function MyComponent() {
  const [data, setData] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/miniatures')
      .then(response => {
        setData(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  return (
    <div>
      <h1>My Data</h1>
      <ul>
        {data.map(item => (
          <li key={item.id}>
            <h2>{item.name}</h2>
            <p>{item.scale}</p>
            <p>{item.progress}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default MyComponent;