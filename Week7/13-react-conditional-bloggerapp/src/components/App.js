
import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [view, setView] = useState("book");

  let content;
  if (view === "book") {
    content = <BookDetails />;
  } else if (view === "blog") {
    content = <BlogDetails />;
  } else if (view === "course") {
    content = <CourseDetails />;
  } else {
    content = <p>Select a valid view.</p>;
  }

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h2>Blogger App</h2>
      <button onClick={() => setView("book")}>Book</button>
      <button onClick={() => setView("blog")}>Blog</button>
      <button onClick={() => setView("course")}>Course</button>
      <div style={{ marginTop: "20px" }}>{content}</div>
    </div>
  );
}

export default App;
