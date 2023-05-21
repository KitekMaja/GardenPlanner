const sequelize = require('../../../db');

const PlantOrder = sequelize.define(
    'PlantOrder', {},
    { tableName: 'plant_order', timestamps:false }
);

module.exports = PlantOrder;