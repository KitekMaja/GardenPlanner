const sequelize = require('../../../db');

const PlantLifespan = sequelize.define(
    'PlantLifespan', {},
    { tableName: 'plant_lifespan', timestamps:false }
);

module.exports = PlantLifespan;