import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import SearchComponent from './Components/SearchComponent';
import AddDataComponent from './Components/AddDataComponent';
import PrintToFile from './Components/PrintToFile';
import MiniatureDetail from './Components/MiniatureDetail';

function MyComponent() {

  return (
    <Router>
      <Routes>
        <Route path="" element={<MainRoute />} />
        <Route path="/miniatures/:id" component={MiniatureDetail} />
      </Routes>
    </Router>
  );
}

function MainRoute() {
  return (
    <>
      <h1>My Miniature Catalog</h1>
      <p>this is my website to keep track of my miniatures</p>
      <SearchComponent />
      <AddDataComponent />
      <PrintToFile />
    </>
  );
}

export default MyComponent;

