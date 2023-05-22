import React from 'react';
import SearchComponent from './SearchComponent';
import AddDataComponent from './AddDataComponent';
import PrintToFile from './PrintToFile';


function MyComponent() {

  return (
    <div>
      <h1>My Miniature Catalog</h1>
      <p>this is my website to keep track of my miniatures!</p>
      <p>search a mini!</p>
      <SearchComponent />
      <AddDataComponent />
      <PrintToFile />
    </div>
  );
}

export default MyComponent;