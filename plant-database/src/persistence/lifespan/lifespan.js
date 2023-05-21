/* 
    Filename: lifespan.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-11
*/

const { Lifespan } = require('../../models/lifespan/lifespanModel');
const errorMessages = require('../../utils/errorMessages');

async function getLifespans()
{
    try
    {
        const lifespans = await Lifespan.findAll();
        return lifespans.map((lifespan) => lifespan.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.LIFESPAN);
    }
};

async function createLifespan(lifespanData)
{
    try
    {
        const lifespan = await Lifespan.create(lifespanData);
        return lifespan.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.CREATE_ERROR + errorMessages.LIFESPAN);
    }
};

async function getLifespanByName(lifespanName)
{
    try
    {
        const lifespan = await Lifespan.findOne({
            where: { name: lifespanName},
            returning: true
        });
        lifespan.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.LIFESPAN);
    }
};

async function getLifespanById(lifespanId)
{
    try
    {
        const lifespan = await Lifespan.findByPk(lifespanId);
        return lifespan.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.LIFESPAN);
    }
};

async function updateLifespan(lifespanId, updates)
{
    try
    {
        const[lifespan, [updatedLifespan]] = await Lifespan.update(updates, {
            where: {lifespan_id: lifespanId},
            returning: true
        });
        return updatedLifespan.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.LIFESPAN);
    }
};

module.exports = {
    getLifespanById,
    getLifespanByName,
    getLifespans,
    createLifespan,
    updateLifespan
};