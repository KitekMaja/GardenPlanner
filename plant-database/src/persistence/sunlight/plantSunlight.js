/* 
    Filename: plantSunlight.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-11
*/

const { PlantSunlight } = require('../../models/sunlight/plantSunlightConditionsModel');
const errorMessages = require('../../utils/errorMessages');

async function getSunlightConditions()
{
    try
    {
        const sunlightConditions = await PlantSunlight.findAll();
        return sunlightConditions.map((sunlightCondition) => sunlightCondition.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.SUNLIGHT_TYPES);
    }
};

async function createSunlightConditions(sunlightConditionData)
{
    try
    {
        const sunlightCondition = await PlantSunlight.create(sunlightConditionData);
        return sunlightCondition.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.PLANT + errorMessages.SUNLIGHT_TYPE);
    }
};

async function getSunlightConditionsById(sunlightId)
{
    try
    {
        const family = await PlantSunlight.findByPk(sunlightId);
        return family.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.SUNLIGHT_TYPE);
    }
};

async function updateSunlightConditions(sunlightId, updates)
{
    try
    {
        const[sunlightCondition, [updatedSunlightConditions]] = await PlantSunlight.update(updates, {
            where: {plant_sunlight_conditions_id: sunlightId},
            returning: true
        });
        return updatedSunlightConditions.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.PLANT + errorMessages.SUNLIGHT_TYPE);
    }
};

module.exports = {
    getSunlightConditions,
    getSunlightConditionsById,
    createSunlightConditions,
    updateSunlightConditions
};