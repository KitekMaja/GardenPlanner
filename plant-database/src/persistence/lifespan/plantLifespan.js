/* 
    Filename: plantLifespan.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-11
*/

const { PlantLifespan } = require('../../models/lifespan/plantLifespanModel');
const errorMessages = require('../../utils/errorMessages');

async function getPlantLifespans()
{
    try
    {
        const lifespans = await PlantLifespan.findAll();
        return lifespans.map((lifespan) => lifespan.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.LIFESPAN);
    }
};

async function createPlantLifespan(lifespanData)
{
    try
    {
        const lifespan = await PlantLifespan.create(lifespanData);
        return lifespan.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.CREATE_ERROR + errorMessages.PLANT + errorMessages.LIFESPAN);
    }
};

async function getPlantLifespanById(lifespanId)
{
    try
    {
        const lifespan = await PlantLifespan.findByPk(lifespanId);
        return lifespan.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.LIFESPAN);
    }
};

async function updatePlantLifespan(lifespanId, updates)
{
    try
    {
        const[lifespan, [updatedLifespan]] = await PlantLifespan.update(updates, {
            where: {plant_lifespan_id: lifespanId},
            returning: true
        });
        return updatedLifespan.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.PLANT + errorMessages.LIFESPAN);
    }
};

module.exports = {
    getPlantLifespanById,
    getPlantLifespans,
    createPlantLifespan,
    updatePlantLifespan
};