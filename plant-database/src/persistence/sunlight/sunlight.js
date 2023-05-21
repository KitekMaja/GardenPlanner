/* 
    Filename: sunlight.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-11
*/

const { Sunlight } = require('../../models/sunlight/');
const errorMessages = require('../../utils/errorMessages');

async function getSunlightTypes()
{
    try
    {
        const sunlightTypes = await Sunlight.findAll();
        return sunlightTypes.map((sunlight) => sunlight.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.SUNLIGHT_TYPES);
    }
};

async function createSunlightType(sunlightData)
{
    try
    {
        const sunlight = await Sunlight.create(sunlightData);
        return sunlight.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.SUNLIGHT_TYPE);
    }
};

async function getSunlightTypeByName(sunlightName)
{
    try
    {
        const sunlight = await Sunlight.findOne({
            where: { intensity: sunlightName },
            returning: true
        });
        return sunlight.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.SUNLIGHT_TYPE);
    }
};

async function getSunlightTypeById(sunlightId)
{
    try
    {
        const sunlight = await Sunlight.findByPk(sunlightId);
        return sunlight.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.SUNLIGHT_TYPE);
    }
};

async function updateSunlightType(sunlightId, updates)
{
    try
    {
        const[family, [updatedFamily]] = await Sunlight.update(updates, {
            where: {sunlight_id: sunlightId},
            returning: true
        });
        return updatedFamily.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.SUNLIGHT_TYPE);
    }
};

module.exports = {
    getSunlightTypeById,
    getSunlightTypeByName,
    getSunlightTypes,
    createSunlightType,
    updateSunlightType
};