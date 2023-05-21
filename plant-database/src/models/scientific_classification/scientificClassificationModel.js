const sequelize = require('../../../db');

const ScientificClassification = sequelize.define(
    'ScientificClassification', {},
    { tableName: 'scientific_classification', timestamps:false }
);

module.exports = ScientificClassification;