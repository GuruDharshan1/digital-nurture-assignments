
import React from 'react';

function BookDetails() {
  const books = [
    { id: 1, title: "React Explained", author: "Zac Gordon" },
    { id: 2, title: "Learning JavaScript", author: "Ethan Brown" }
  ];

  return (
    <div>
      <h3>Book Details</h3>
      <ul>
        {books.map(book => (
          <li key={book.id}>{book.title} - {book.author}</li>
        ))}
      </ul>
    </div>
  );
}

export default BookDetails;
