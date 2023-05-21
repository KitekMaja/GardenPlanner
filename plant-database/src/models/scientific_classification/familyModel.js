const sequelize = require('../../../db');

const Family = sequelize.define(
    'Family', {},
    { tableName: 'family', timestamps:false }
);

module.exports = Family;