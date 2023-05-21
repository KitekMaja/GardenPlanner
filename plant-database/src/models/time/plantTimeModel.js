const sequelize = require('../../../db');

const PlantTime = sequelize.define(
    'PlantTime', {},
    { tableName: 'plant_time', timestamps:false }
);

module.exports = PlantTime;