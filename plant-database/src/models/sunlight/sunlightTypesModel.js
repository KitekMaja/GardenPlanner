const sequelize = require('../../../db');

const SunlightTypesModel = sequelize.define(
    'SunlightTypesModel', {},
    { tableName: 'sunlight_types', timestamps:false }
);

module.exports = SunlightTypesModel;