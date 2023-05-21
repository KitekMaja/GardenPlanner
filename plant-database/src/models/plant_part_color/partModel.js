const sequelize = require('../../../db');

const Part = sequelize.define(
    'Part', {},
    { tableName: 'plant_part', timestamps:false }
);

module.exports = Part;