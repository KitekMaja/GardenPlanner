/* 
    Filename: plantHardinessZone.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-11
*/

const { PlantHardinessZone } = require('../../models/hardiness_zones/plantHardinessZoneModel');
const errorMessages = require('../../utils/errorMessages');

async function getPlantZones()
{
    try
    {
        const zones = await PlantHardinessZone.findAll();
        return zones.map((zone) => zone.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.ZONES);
    }
};

async function createPlantZone(plantZoneData)
{
    try
    {
        const zone = await PlantHardinessZone.create(plantZoneData);
        return zone.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.CREATE_ERROR + errorMessages.PLANT + errorMessages.ZONE);
    }
};

async function getPlantZoneById(plantZoneId)
{
    try
    {
        const zone = await PlantHardinessZone.findByPk(plantZoneId);
        return zone.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.ZONE);
    }
};

async function updatePlantZone(plantZoneId, updates)
{
    try
    {
        const[zone, [updatedPlantZone]] = await PlantHardinessZone.update(updates, {
            where: {plant_zone_id: plantZoneId},
            returning: true
        });
        return updatedPlantZone.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.PLANT + errorMessages.ZONE);
    }
};

module.exports = {
    getPlantZoneById,
    getPlantZones,
    createPlantZone,
    updatePlantZone
};