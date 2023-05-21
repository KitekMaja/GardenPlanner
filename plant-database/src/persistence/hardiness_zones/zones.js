/* 
    Filename: zones.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-11
*/

const { Zones } = require('../../models/hardiness_zones/hardinessZonesModel');
const errorMessages = require('../../utils/errorMessages');

async function getZones()
{
    try
    {
        const zones = await Zones.findAll();
        return zones.map((zone) => zone.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.ZONES);
    }
};

async function createZone(zoneData)
{
    try
    {
        const zone = await Zones.create(zoneData);
        return zone.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.CREATE_ERROR + errorMessages.ZONE);
    }
};

async function getZoneById(zoneId)
{
    try
    {
        const zone = await Zones.findByPk(zoneId);
        return zone.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.ZONE);
    }
};

async function updateZone(zoneId, updates)
{
    try
    {
        const[zone, [updatedZone]] = await Zones.update(updates, {
            where: {zone_id: zoneId},
            returning: true
        });
        return updatedZone.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.ZONE);
    }
};

module.exports = {
    getZoneById,
    getZones,
    createZone,
    updateZone
};