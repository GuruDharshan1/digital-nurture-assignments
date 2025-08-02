import React, { useState } from 'react';

function Register() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: ''
  });

  const [errors, setErrors] = useState({});

  const validate = () => {
    let newErrors = {};
    if (formData.name.length < 5) {
      newErrors.name = 'Name should have at least 5 characters';
    }
    if (!formData.email.includes('@') || !formData.email.includes('.')) {
      newErrors.email = 'Email should contain "@" and "."';
    }
    if (formData.password.length < 8) {
      newErrors.password = 'Password should have at least 8 characters';
    }
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      alert('Registration Successful');
      setFormData({ name: '', email: '', password: '' });
      setErrors({});
    }
  };

  return (
    <div style={{ width: '300px', margin: 'auto' }}>
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name:</label><br />
          <input type="text" name="name" value={formData.name} onChange={handleChange} />
          <div style={{ color: 'red' }}>{errors.name}</div>
        </div>
        <div>
          <label>Email:</label><br />
          <input type="email" name="email" value={formData.email} onChange={handleChange} />
          <div style={{ color: 'red' }}>{errors.email}</div>
        </div>
        <div>
          <label>Password:</label><br />
          <input type="password" name="password" value={formData.password} onChange={handleChange} />
          <div style={{ color: 'red' }}>{errors.password}</div>
        </div>
        <br />
        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;
