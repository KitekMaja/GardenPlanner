const sequelize = require('../../../db');

const Color = sequelize.define(
    'Color', {},
    { tableName: 'color', timestamps:false }
);

module.exports = Color;