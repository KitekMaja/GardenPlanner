/* 
    Filename: part.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-21
*/

const { Part } = require('../../models/plant_part_color/partModel');
const errorMessages = require('../../utils/errorMessages');

async function getParts()
{
    try
    {
        const parts = await Part.findAll();
        return parts.map((part) => part.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PARTS);
    }
};

async function createPart(partData)
{
    try
    {
        const part = await Part.create(partData);
        return part.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.PART);
    }
};

async function getPartByName(partName)
{
    try
    {
        const part = await Part.findOne({
            where: { name: partName },
            returning: true
        });
        return part.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PART);
    }
};

async function getPartById(partId)
{
    try
    {
        const part = await Part.findByPk(partId);
        return part.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PART);
    }
};

async function updatePart(partId, updates)
{
    try
    {
        const[part, [updatedPart]] = await Part.update(updates, {
            where: {plant_part_id: partId},
            returning: true
        });
        return updatedPart.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.PART);
    }
};

module.exports = {
    createPart,
    getParts,
    getPartByName,
    getPartById,
    updatePart
};