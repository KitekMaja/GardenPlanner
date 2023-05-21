const sequelize = require('../../../db');

const PlantHardinessZone = sequelize.define(
    'PlantHardinessZone', {},
    { tableName: 'plant_hardiness_zone', timestamps:false }
);

module.exports = PlantHardinessZone;