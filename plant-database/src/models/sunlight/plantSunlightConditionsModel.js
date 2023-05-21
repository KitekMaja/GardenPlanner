const sequelize = require('../../../db');

const PlantSunlightConditions = sequelize.define(
    'PlantSunlightConditions', {},
    { tableName: 'plant_sunlight_conditions', timestamps:false }
);

module.exports = PlantSunlightConditions;