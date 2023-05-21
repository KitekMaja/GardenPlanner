const sequelize = require('../../../db');

const PlantNames = sequelize.define(
    'PlantNames', {},
    { tableName: 'plant_names', timestamps:false }
);

module.exports = PlantNames;