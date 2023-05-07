
const dotenv = require('dotenv');
const path = require('path');

const { Sequelize } = require('sequelize');

// use .env file where database login data is stored
dotenv.config({ path: path.resolve(__dirname, '../config/environments', '.env') });


const sequelize = new Sequelize({
  dialect: 'postgres',
  host: process.env.DB_HOST,
  port: process.env.DB_PORT,
  username: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_NAME,
  ssl: {
    rejectUnauthorized: false
  }
});

module.exports = sequelize;