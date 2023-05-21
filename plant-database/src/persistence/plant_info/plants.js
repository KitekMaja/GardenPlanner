/* 
    Filename: plants.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-07
*/

const { Plant } = require('../../models/plant_info/plantModel');
const errorMessages = require('../../utils/errorMessages');

async function getPlants()
{
    try
    {
        const plants = await Plant.findAll();
        return plants.map((plant) => plant.toJSON()); 
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANTS);
    }
}

async function createPlant(plantData)
{
    try
    {
        const plant = await Plant.create(plantData);
        return plant.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.CREATE_ERROR + errorMessages.PLANT);
    }
}

async function getPlant(plantName)
{
    try
    {
        const plant = await Plant.findOne({
            where: { botanical_name: plantName},
            returning: true
          });
        return plant.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANT);
    }
}

async function updatePlant(plantName, updates)
{
    try
    {
        const[plant, [updatedPlant]] = await Plant.update(updates, {
            where: {botanical_name: plantName},
            returning: true
        }); 
        return updatedPlant.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.PLANT);
    }
}

module.exports = {
    createPlant,
    updatePlant,
    getPlant,
    getPlants
};