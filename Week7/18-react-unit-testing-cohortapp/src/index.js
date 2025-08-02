
import React from 'react';
import ReactDOM from 'react-dom/client';
import CohortDetails from './components/CohortDetails';
import { CohortData } from './Cohort';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <div>
    {CohortData.map(cohort => (
      <CohortDetails key={cohort.code} cohort={cohort} />
    ))}
  </div>
);
