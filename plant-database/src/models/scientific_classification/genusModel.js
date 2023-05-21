const sequelize = require('../../../db');

const Genus = sequelize.define(
    'Genus', {},
    { tableName: 'genus', timestamps:false }
);

module.exports = Genus;