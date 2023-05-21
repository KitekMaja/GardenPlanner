const sequelize = require('../../../db');

const PlantPropagation = sequelize.define(
    'PlantPropagation', {},
    { tableName: 'plant_propagation', timestamps:false }
);

module.exports = PlantPropagation;