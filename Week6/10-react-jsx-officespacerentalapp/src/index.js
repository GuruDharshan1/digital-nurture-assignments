
import React from 'react';
import ReactDOM from 'react-dom/client';

const offices = [
  {
    id: 1,
    name: "Tech Park One",
    rent: 45000,
    address: "Plot 21, Whitefield, Bangalore",
    image: "https://via.placeholder.com/300x200?text=Office+1"
  },
  {
    id: 2,
    name: "Downtown Tower",
    rent: 85000,
    address: "Sector 44, Gurgaon",
    image: "https://via.placeholder.com/300x200?text=Office+2"
  },
  {
    id: 3,
    name: "Startup Hub",
    rent: 60000,
    address: "Baner, Pune",
    image: "https://via.placeholder.com/300x200?text=Office+3"
  }
];

const App = () => {
  return (
    <div style={{ fontFamily: "Arial", padding: "20px" }}>
      <h1>Office Space Rental Listings</h1>
      {offices.map(office => (
        <div key={office.id} style={{
          border: "1px solid #ccc",
          marginBottom: "20px",
          padding: "10px",
          borderRadius: "5px"
        }}>
          <img src={office.image} alt={office.name} style={{ width: "100%", maxWidth: "300px" }} />
          <h2>{office.name}</h2>
          <p><strong>Address:</strong> {office.address}</p>
          <p style={{ color: office.rent > 60000 ? "green" : "red" }}>
            <strong>Rent:</strong> ₹{office.rent}
          </p>
        </div>
      ))}
    </div>
  );
};

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
