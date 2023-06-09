import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function SearchComponent() {
  const [searchQuery, setSearchQuery] = useState('');
  const [searchResults, setSearchResults] = useState([]);
  const [jsonData, setJsonData] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/miniatures')
      .then(response => {
        setJsonData(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  const handleSearch = (event) => {
    setSearchQuery(event.target.value);
  };

  const handleFormSubmit = event => {
    event.preventDefault();
    const results = jsonData.filter(item => {
      if (item.page.includes("http://localhost:3000/api/miniatures/1")) {
        return false;
      }
      return item.page && item.page.includes(searchQuery);
    });

    setSearchResults(results);
  };

  return (
    <div>
      <form onSubmit={handleFormSubmit}>
        <input
          type="text"
          value={searchQuery}
          onChange={handleSearch}
          placeholder="Search..."
        />
        <button type="submit">Search</button>
      </form>
      {searchResults.length > 0 && (
        <div>
          <h2>Search Results:</h2>
          <ul>
            {searchResults.map((result) => (
              <li key={result.id}>
                <Link to={`/miniatures/${result.miniature_id}`}>{result.page}</Link>
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
}

export default SearchComponent;
