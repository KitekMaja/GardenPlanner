/* 
    Filename: plantTime.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-21
*/

const { PlantTime } = require('../../models/time/plantTimeModel');
const errorMessages = require('../../utils/errorMessages');

async function getPlantTimes()
{
    try
    {
        const plantTimes = await PlantTime.findAll();
        return plantTimes.map((plantTime) => plantTime.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.TIMES);
    }
};

async function createPlantTime(plantTimeData)
{
    try
    {
        const plantTime = await PlantTime.create(plantTimeData);
        return plantTime.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.PLANT  + errorMessages.TIME);
    }
};

async function getPlantTimeById(plantTimeId)
{
    try
    {
        const plantTime = await PlantTime.findByPk(plantTimeId);
        return plantTime.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT  + errorMessages.TIME);
    }
};

async function updatePlantTime(plantTimeId, updates)
{
    try
    {
        const[plantTime, [updatedPlantTime]] = await PlantTime.update(updates, {
            where: {plant_time_id: plantTimeId},
            returning: true
        });
        return updatedPlantTime.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.PLANT  + errorMessages.TIME);
    }
};

module.exports = {
    createPlantTime,
    getPlantTimeById,
    getPlantTimes,
    updatePlantTime
};