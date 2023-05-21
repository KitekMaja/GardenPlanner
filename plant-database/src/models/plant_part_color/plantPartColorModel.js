const sequelize = require('../../../db');

const PlantPartColor = sequelize.define(
    'PlantPartColor', {},
    { tableName: 'plant_part_color', timestamps:false }
);

module.exports = PlantPartColor;