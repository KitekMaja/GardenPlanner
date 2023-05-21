const sequelize = require('../../../db');

const PlantTimeSeason = sequelize.define(
    'PlantTimeSeason', {},
    { tableName: 'plant_time_season', timestamps:false }
);

module.exports = PlantTimeSeason;