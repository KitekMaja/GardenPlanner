/* 
    Filename: soil.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-11
*/

const { Soil } = require('../../models/soil/soilTypesModel');
const errorMessages = require('../../utils/errorMessages');

async function getSoils()
{
    try
    {
        const soils = await Soil.findAll();
        return soils.map((soil) => soil.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.SOIL_TYPES);
    }
};

async function createSoil(soilData)
{
    try
    {
        const soil = await Soil.create(soilData);
        return soil.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.SOIL_TYPE);
    }
};

async function getSoilByName(soilName)
{
    try
    {
        const soil = await Soil.findOne({
            where: { name: soilName },
            returning: true
        });
        return soil.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.SOIL_TYPE);
    }
};

async function getSoilById(soilId)
{
    try
    {
        const soil = await Soil.findByPk(soilId);
        return soil.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.SOIL_TYPE);
    }
};

async function updateSoil(soilId, updates)
{
    try
    {
        const[soil, [updatedSoil]] = await Soil.update(updates, {
            where: {soil_id: soilId},
            returning: true
        });
        return updatedSoil.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.SOIL_TYPE);
    }
};

module.exports = {
    getSoilById,
    getSoilByName,
    getSoils,
    createSoil,
    updateSoil
};