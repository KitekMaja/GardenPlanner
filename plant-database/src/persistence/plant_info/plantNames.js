/* 
    Filename: plantNames.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-21
*/

const { PlantName } = require('../../models/plant_info/plantNamesModel');
const errorMessages = require('../../utils/errorMessages');

async function getAllPlantNames()
{
    try
    {
        const plantNames = await PlantName.findAll();
        return plantNames.map((plantName) => plantName.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANT_NAMES);
    }
};

async function createPlantName(plantNameData)
{
    try
    {
        const plantName = await PlantName.create(plantNameData);
        return plantName.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.PLANT_NAME);
    }
};

async function getPlantNameById(plantNameId)
{
    try
    {
        const plantName = await PlantName.findByPk(plantNameId);
        return plantName.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT_NAME);
    }
};

async function getPlantName(plantName)
{
    try
    {
        const name = await PlantName.findOne({
            where: { name: plantName },
            returning: true
        });
        return name.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT_NAME);
    }
};

async function updatePlantName(plantNameId, updates)
{
    try
    {
        const[plantName, [updatedPlantName]] = await PlantName.update(updates, {
            where: {plant_name_id: plantNameId},
            returning: true
        });
        return updatedPlantName.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.PLANT_NAME);
    }
};

async function getPlantNames(plant_id)
{
    try
    {
        const name = await PlantName.findAll({
            where: { plant_name_id: plant_id },
            returning: true
        });
        return name.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT_NAME);
    }
};

module.exports = {
    createPlantName,
    updatePlantName,
    getAllPlantNames,
    getPlantNameById,
    getPlantNames,
    getPlantName
};