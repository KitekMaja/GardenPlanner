const sequelize = require('../../../db');

const Plant = sequelize.define(
    'Plant', {},
    { tableName: 'plant', timestamps:false }
);

module.exports = Plant;