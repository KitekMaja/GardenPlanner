const sequelize = require('../../../db');

const Class = sequelize.define(
    'Class', {},
    { tableName: 'class', timestamps:false }
);

module.exports = Class;