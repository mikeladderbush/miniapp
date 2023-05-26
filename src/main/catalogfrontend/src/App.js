import React from 'react';
import SearchComponent from './Components/SearchComponent';
import AddDataComponent from './Components/AddDataComponent';
import PrintToFile from './Components/PrintToFile';

function MyComponent() {

  return (
    <div>
      <h1>My Miniature Catalog</h1>
      <p>this is my website to keep track of my miniatures</p>
      <SearchComponent />
      <AddDataComponent />
      <PrintToFile />
    </div>
  );
}

export default MyComponent;