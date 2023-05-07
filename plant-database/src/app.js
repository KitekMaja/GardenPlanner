// Import Express
const express = require('express');
const dotenv = require('dotenv');
const path = require('path');

const { Sequelize } = require('sequelize');
const { Client } = require('pg');

// Create an instance of Express
const app = express();

// use .env file where database login data is stored
dotenv.config({ path: path.resolve(__dirname, 'config/environments', '.env') });

// create DB connection
const sequelize = new Sequelize(
  process.env.DB_NAME,
  process.env.DB_USER,
  process.env.DB_PASSWORD,
  {
    host: process.env.DB_HOST,
    port: process.env.DB_PORT,
    dialect: 'postgres',
    dialectOptions: {
      ssl: {
        rejectUnauthorized: false
      }
    }
  }
);

// Define an endpoint
app.get('/', (req, res) => {
  res.send('Hello, world!');
});

// Start the server
app.listen(1000, () => {
  console.log('Server started on port 1000 - plantdb');
});