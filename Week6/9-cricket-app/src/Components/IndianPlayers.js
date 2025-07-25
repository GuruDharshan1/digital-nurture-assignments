import React from 'react';

function IndianPlayers() {
  const T20players = ["Kohli", "Rohit"];
  const RanjiTrophyPlayers = ["Rahane", "Pujara"];
  const allPlayers = [...T20players, ...RanjiTrophyPlayers];

  const team = ["Dhoni", "Raina", "Bumrah", "Ashwin"];
  const [odd1, , odd2, ,] = team;
  const [, even1, , even2] = team;

  return (
    <div>
      <h2>Indian Players</h2>
      <p><strong>Odd Team Players:</strong> {odd1}, {odd2}</p>
      <p><strong>Even Team Players:</strong> {even1}, {even2}</p>
      <h3>All Players (Merged):</h3>
      <ul>
        {allPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
}

export default IndianPlayers;
