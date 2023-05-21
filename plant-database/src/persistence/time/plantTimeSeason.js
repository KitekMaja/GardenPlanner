/* 
    Filename: plantTimeSeason.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-21
*/

const { PlantTimeSeason } = require('../../models/time/plantTimeSeasonModel');
const errorMessages = require('../../utils/errorMessages');

async function getPlantTimeSeasons()
{
    try
    {
        const plantTimeSeasons = await PlantTimeSeason.findAll();
        return plantTimeSeasons.map((plantTimeSeason) => plantTimeSeason.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.SEASONS);
    }
};

async function createPlantTimeSeason(plantTimeSeasonData)
{
    try
    {
        const plantTimeSeason = await PlantTimeSeason.create(plantTimeSeasonData);
        return plantTimeSeason.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.PLANT  + errorMessages.SEASON);
    }
};

async function getPlantTimeSeasonById(plantTimeSeasonId)
{
    try
    {
        const plantTimeSeason = await PlantTimeSeason.findByPk(plantTimeSeasonId);
        return plantTimeSeason.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT  + errorMessages.SEASON);
    }
};

async function updatePlantTimeSeason(plantTimeSeasonId, updates)
{
    try
    {
        const[plantTimeSeason, [updatedPlantTimeSeason]] = await PlantTimeSeason.update(updates, {
            where: {plantTimeSeason_id: plantTimeSeasonId},
            returning: true
        });
        return updatedPlantTimeSeason.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.PLANT  + errorMessages.SEASON);
    }
};

async function getTimeByPlantId(plantId)
{
    try
    {
        const times = await PlantTimeSeason.findAll({
            where: {fk_plant_id: plantId},
            returning: true
          });
        return times.map((time) => time.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.TIMES);
    }
};

async function getPlantsByTimeId(timeId)
{
    try
    {
        const plants = await PlantTimeSeason.findAll({
            where: {fk_plant_time: timeId},
            returning: true
          });
        return plants.map((plant) => plant.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANTS);
    }
};

async function getPlantSeasonTimes(seasonId, timeId)
{
    try
    {
        const plants = await PlantTimeSeason.findAll({
            where: {
                fk_plant_time: timeId,
                fk_season_id: seasonId
            },
            returning: true
          });
        return plants.map((plant) => plant.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANTS);
    }
};

module.exports = {
    createPlantTimeSeason,
    getPlantTimeSeasonById,
    getPlantTimeSeasons,
    updatePlantTimeSeason,
    getPlantSeasonTimes,
    getTimeByPlantId,
    getPlantsByTimeId
};