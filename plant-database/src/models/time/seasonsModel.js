const sequelize = require('../../../db');

const Seasons = sequelize.define(
    'Seasons', {},
    { tableName: 'seasons', timestamps:false }
);

module.exports = Seasons;