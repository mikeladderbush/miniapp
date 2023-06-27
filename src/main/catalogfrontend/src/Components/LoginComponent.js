import React, { useState } from 'react';
import axios from 'axios';

function LoginComponent() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleLogin = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post('http://localhost:8080/login', {
        username,
        password,
      });

      // Assuming the response contains a token
      const token = response.data.token;

      // Store the token in local storage or any other secure storage mechanism
      localStorage.setItem('token', token);

      // Redirect the user to the desired page or update the UI accordingly
      // For example, you can navigate to a dashboard page
      // history.push('/dashboard');
    } catch (error) {
      console.error('Login failed:', error);
    }
  };

  return (
    <form onSubmit={handleLogin}>
      <div>
        <label>Username:</label>
        <input type="text" value={username} onChange={handleUsernameChange} />
      </div>
      <div>
        <label>Password:</label>
        <input type="password" value={password} onChange={handlePasswordChange} />
      </div>
      <button type="submit">Login</button>
    </form>
  );
}

export default LoginComponent;
