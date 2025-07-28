import React from 'react';

function ListofPlayers() {
  const players = [
    { name: "Player1", score: 45 },
    { name: "Player2", score: 75 },
    { name: "Player3", score: 60 },
    { name: "Player4", score: 90 },
    { name: "Player5", score: 30 },
    { name: "Player6", score: 82 },
    { name: "Player7", score: 77 },
    { name: "Player8", score: 65 },
    { name: "Player9", score: 50 },
    { name: "Player10", score: 88 },
    { name: "Player11", score: 40 }
  ];

  const filteredPlayers = players.filter(player => player.score >= 70);

  return (
    <div>
      <h2>Top Scoring Players (Score >= 70)</h2>
      <ul>
        {filteredPlayers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;
