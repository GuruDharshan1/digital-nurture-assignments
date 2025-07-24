
import React from 'react';
import CohortDetails from './components/CohortDetails';

function App() {
  return (
    <div>
      <CohortDetails name="React Bootcamp" status="ongoing" />
      <CohortDetails name="Java Spring Boot" status="completed" />
    </div>
  );
}

export default App;
