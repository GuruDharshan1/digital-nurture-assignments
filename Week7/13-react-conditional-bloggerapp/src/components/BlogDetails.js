
import React from 'react';

function BlogDetails() {
  const blogs = [
    { id: 1, title: "React Best Practices", date: "2023-12-01" },
    { id: 2, title: "Hooks vs Class Components", date: "2024-01-15" }
  ];

  return (
    <div>
      <h3>Blog Details</h3>
      <ul>
        {blogs.map(blog => (
          <li key={blog.id}>{blog.title} - {blog.date}</li>
        ))}
      </ul>
    </div>
  );
}

export default BlogDetails;
