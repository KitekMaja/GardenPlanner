const sequelize = require('../../../db');

const PlantSoil = sequelize.define(
    'PlantSoil', {},
    { tableName: 'plant_soil', timestamps:false }
);

module.exports = PlantSoil;