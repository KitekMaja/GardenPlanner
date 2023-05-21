const sequelize = require('../../../db');

const Habitat = sequelize.define(
    'Habitat', {},
    { tableName: 'habitat', timestamps:false }
);

module.exports = Habitat;