// Import Express
const express = require('express');

// Create an instance of Express
const app = express();

const { Client } = require('pg');

const client = new Client({
  host: 'localhost',
  port: 5432,
  user: 'postgres',
  password: 'admin',
  database: 'plants',
});

client.connect()
  .then(() => console.log('Connected to PostgreSQL database'))
  .catch(err => console.error('Error connecting to PostgreSQL database', err));

// Define an endpoint
app.get('/', (req, res) => {
  res.send('Hello, world!');
});

// Start the server
app.listen(1000, () => {
  console.log('Server started on port 1000 - plantdb');
});