
import React, { useEffect, useState } from 'react';
import GitClient from './GitClient';

function App() {
  const [repos, setRepos] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const data = await GitClient.getRepositories("techiesyed");
      setRepos(data);
    };
    fetchData();
  }, []);

  return (
    <div style={{ fontFamily: "Arial", padding: "20px" }}>
      <h2>GitHub Repositories</h2>
      <ul>
        {repos.map((repo, index) => (
          <li key={index}>{repo}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
