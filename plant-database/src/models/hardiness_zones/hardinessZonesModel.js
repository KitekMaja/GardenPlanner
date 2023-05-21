const sequelize = require('../../../db');

const HardinessZones = sequelize.define(
    'HardinessZones', {},
    { tableName: 'hardiness_zones', timestamps:false }
);

module.exports = HardinessZones;