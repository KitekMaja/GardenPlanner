const sequelize = require('../../../db');

const SoilTypes = sequelize.define(
    'SoilTypes', {},
    { tableName: 'soil_types', timestamps:false }
);

module.exports = SoilTypes;