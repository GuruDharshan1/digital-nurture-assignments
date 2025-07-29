import React, { useState } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const toggleLogin = () => setIsLoggedIn(!isLoggedIn);

  return (
    <div style={{ padding: 20, fontFamily: 'Arial' }}>
      <h1>Ticket Booking App</h1>
      <button onClick={toggleLogin}>
        {isLoggedIn ? 'Logout' : 'Login'}
      </button>
      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;
