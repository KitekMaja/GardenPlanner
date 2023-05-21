const sequelize = require('../../../db');

const Lifespan = sequelize.define(
    'Lifespan', {},
    { tableName: 'lifespan', timestamps:false }
);

module.exports = Lifespan;