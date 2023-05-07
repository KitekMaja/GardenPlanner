// Import Express
const express = require('express');

// Create an instance of Express
const app = express();

// Define an endpoint
app.get('/', (req, res) => {
  res.send('Hello, world!');
});

// Start the server
app.listen(1000, () => {
  console.log('Server started on port 1000 - plantdb');
});