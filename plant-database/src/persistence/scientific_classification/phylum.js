/* 
    Filename: phylum.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-10
*/

const { Phylum } = require('../../models/scientific_classification/phylumModel');
const errorMessages = require('../../utils/errorMessages');

async function getPhylums()
{
    try
    {
        const phylums = await Phylum.findAll();
        return phylums.map((phylum) => phylum.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PHYLUMS);
    }
};

async function createPhylum(phylumData)
{
    try
    {
        const phylum = await Phylum.create(phylumData);
        return phylum.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.PHYLUM);
    }
};

async function getPhylumByName(phylumName)
{
    try
    {
        const phylum = await Phylum.findOne({
            where: { name: phylumName },
            returning: true
        });
        return phylum.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PHYLUM);
    }
};

async function getPhylumById(phylumId)
{
    try
    {
        const phylum = await Phylum.findByPk(phylumId);
        return phylum.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PHYLUM);
    }
};

async function updatePhylum(phylumId, updates)
{
    try
    {
        const[phylum, [updatedPhylum]] = await Phylum.update(updates, {
            where: {phylum_id: phylumId},
            returning: true
        });
        return updatedPhylum.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.PHYLUM);
    }
};

module.exports = {
    getPhylumById,
    getPhylumByName,
    getPhylums,
    createPhylum,
    updatePhylum
    
};