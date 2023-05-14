import React from 'react';
import SearchComponent from './SearchComponent';
import AddDataComponent from './AddDataComponent';


function MyComponent() {

  return (
    <div>
      <h1>My Miniature Catalog</h1>
      <p>this is my website to keep track of my miniatures!</p>
      <p>search a mini!</p>
      <SearchComponent />
      <AddDataComponent />
    </div>
  );
}

export default MyComponent;