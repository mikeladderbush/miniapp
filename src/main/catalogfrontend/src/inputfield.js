import React, { useState } from 'react';

function InputField() {
  const [value, setValue] = useState('');

  function handleChange(event) {
    setValue(event.target.value);
  }

  return (
    <div>
      <input type="text" value={value} onChange={handleChange} />
      <p>The value you entered is: {value}</p>
    </div>
  );
}

export default InputField;