const sequelize = require('../../../db');

const Phylum = sequelize.define(
    'Phylum', {},
    { tableName: 'phylum', timestamps:false }
);

module.exports = Phylum;