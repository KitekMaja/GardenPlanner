/* 
    Filename: genus.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-10
*/

const { Genus } = require('../../models/scientific_classification/genusModel');
const errorMessages = require('../../utils/errorMessages');

async function getGenuses()
{
    try
    {
        const genuses = await Genus.findAll();
        return genuses.map((genus) => genus.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.GENUS);
    }
};

async function createGenus(genusData)
{
    try
    {
        const genus = await Genus.create(genusData);
        return genus.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.GENUS);
    }
};

async function getGenusByName(genusName)
{
    try
    {
        const genus = await Genus.findOne({
            where: { name: genusName },
            returning: true
        });
        return genus.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.GENUS);
    }
};

async function getGenusById(genusId)
{
    try
    {
        const genus = await Genus.findByPk(genusId);
        return genus.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.GENUS);
    }
};

async function updateGenus(genusId, updates)
{
    try
    {
        const[genus, [updatedGenus]] = await Genus.update(updates, {
            where: {genus_id: genusId},
            returning: true
        });
        return updatedGenus.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.GENUS);
    }
};

module.exports = {
    getGenusById,
    getGenusByName,
    getGenuses,
    createGenus,
    updateGenus
};