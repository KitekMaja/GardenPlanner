/* 
    Filename: plantPropagations.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-21
*/

const { Propagation } = require('../../models/propagation/plantPropagationModel');
const errorMessages = require('../../utils/errorMessages');

async function getPropagations()
{
    try
    {
        const propagations = await Propagation.findAll();
        return propagations.map((propagation) => propagation.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.TECHNIQUES);
    }
};

async function createPropagation(propagationData)
{
    try
    {
        const propagation = await Propagation.create(propagationData);
        return propagation.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.PLANT + errorMessages.TECHNIQUE);
    }
};

async function getPropagationById(propagationId)
{
    try
    {
        const propagation = await Propagation.findByPk(propagationId);
        return propagation.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT + errorMessages.TECHNIQUE);
    }
};

async function updatePropagation(propagationId, updates)
{
    try
    {
        const[propagation, [updatedPropagation]] = await Propagation.update(updates, {
            where: {propagation_id: propagationId},
            returning: true
        });
        return updatedPropagation.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.PLANT + errorMessages.TECHNIQUE);
    }
};

module.exports = {
    createPropagation,
    getPropagationById,
    getPropagations,
    updatePropagation
};