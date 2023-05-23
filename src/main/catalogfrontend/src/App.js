import React from 'react';
import SearchComponent from './SearchComponent';
import AddDataComponent from './AddDataComponent';
import PrintToFile from './PrintToFile';
import LoginComponent from './LoginComponent';


function MyComponent() {

  return (
    <div>
      <h1>My Miniature Catalog</h1>
      <p>this is my website to keep track of my miniatures!</p>
      <p>search a mini!</p>
      <SearchComponent />
      <AddDataComponent />
      <PrintToFile />
      <LoginComponent />
    </div>
  );
}

export default MyComponent;