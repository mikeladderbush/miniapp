import React, { useState } from 'react';

function LoginComponent(){
    const [login, setLogin] = useState({
        userName:'', password:''
    });

    const handleInputChange = (event) => {
        setLogin({...login, [event.target.userName]: event.target.value});
    }
    const handleSubmit = (event) => {
        event.preventDefault();
        setLogin({userName: '', password: ''});
    };

    
  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Username"
        value={login.userName}
        onChange={handleInputChange}
      />
      <input
        type="password"
        placeholder="Password"
        value={login.password}
        onChange={handleInputChange}
      />
      <button type="submit">Login</button>
    </form>
  );
}

export default LoginComponent;