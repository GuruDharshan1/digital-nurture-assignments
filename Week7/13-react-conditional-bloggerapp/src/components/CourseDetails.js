
import React from 'react';

function CourseDetails() {
  const isEnrolled = true;

  return (
    <div>
      <h3>Course Details</h3>
      {isEnrolled ? (
        <p>You are enrolled in this course.</p>
      ) : (
        <p>Please enroll to access course content.</p>
      )}
    </div>
  );
}

export default CourseDetails;
