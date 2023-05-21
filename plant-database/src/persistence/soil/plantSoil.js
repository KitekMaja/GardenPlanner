/* 
    Filename: plantSoil.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-11
*/

const { PlantSoil } = require('../../models/soil/plantSoilModel');
const errorMessages = require('../../utils/errorMessages');

async function getPlantSoils()
{
    try
    {
        const soils = await PlantSoil.findAll();
        return soils.map((soil) => soil.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.SOIL_TYPES);
    }
};

async function createSoil(soilData)
{
    try
    {
        const soil = await PlantSoil.create(soilData);
        return soil.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.PLANT + errorMessages.SOIL_TYPE);
    }
};

async function getSoilByName(soilName)
{
    try
    {
        const soil = await PlantSoil.findOne({
            where: { name: soilName },
            returning: true
        });
        return soil.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.SOIL_TYPE);
    }
};

async function getSoilyById(soilId)
{
    try
    {
        const soil = await PlantSoil.findByPk(soilId);
        return soil.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.SOIL_TYPE);
    }
};

async function updateSoil(soilId, updates)
{
    try
    {
        const[soil, [updatedSoil]] = await PlantSoil.update(updates, {
            where: {soil_id: soilId},
            returning: true
        });
        return updatedSoil.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.PLANT + errorMessages.SOIL_TYPE);
    }
};

module.exports = {
    getPlantSoils,
    getSoilByName,
    getSoilyById,
    createSoil,
    updateSoil
};