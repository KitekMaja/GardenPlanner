const sequelize = require('../../db');

const PropagationTechniques = sequelize.define(
    'PropagationTechniques', {},
    { tableName: 'propagation_techniques', timestamps:false }
);

module.exports = PropagationTechniques;