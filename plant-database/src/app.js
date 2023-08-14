// Import Express
const express = require('express');

// Import routes
const plantRoutes = require('../src/routes/plant_info/plantRoutes');
const habitatRoutes = require('../src/routes/plant_info/habitatRoutes');
const plantNameRoutes = require('../src/routes/plant_info/plantNameRoutes');

// Create an instance of Express
const app = express();

// Define an endpoint
app.get('/', (req, res) => {
  res.send('Hello, world!');
});

// Use routes
app.use('/plantAPI/v1/', plantRoutes);
app.use('/habitatAPI/v1/', habitatRoutes);
app.use('/plantNameAPI/v1/', plantNameRoutes);

// Start the server
app.listen(1000, () => {
  console.log('Server started on port 1000 - plantdb');
});