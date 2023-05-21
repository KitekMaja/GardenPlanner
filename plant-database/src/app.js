// Import Express
const express = require('express');

// Import routes
const plantRoute = require('../src/routes/plant_info/plantRoutes');

// Create an instance of Express
const app = express();

// Define an endpoint
app.get('/', (req, res) => {
  res.send('Hello, world!');
});

// Use routes

app.use('/plantAPI/v1/', plantRoute);

// Start the server
app.listen(1000, () => {
  console.log('Server started on port 1000 - plantdb');
});