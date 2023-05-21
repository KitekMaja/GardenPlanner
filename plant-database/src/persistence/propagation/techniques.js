/* 
    Filename: techniques.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-21
*/

const { Technique } = require('../../models/propagation/propagationTechniquesModel');
const errorMessages = require('../../utils/errorMessages');

async function getTechniques()
{
    try
    {
        const techniques = await Technique.findAll();
        return techniques.map((technique) => technique.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.TECHNIQUES);
    }
};

async function createTechnique(techniqueData)
{
    try
    {
        const technique = await Technique.create(techniqueData);
        return technique.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.TECHNIQUE);
    }
};

async function getTechniqueByName(techniqueName)
{
    try
    {
        const technique = await Technique.findOne({
            where: { name: techniqueName },
            returning: true
        });
        return technique.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.TECHNIQUE);
    }
};

async function getTechniqueById(techniqueId)
{
    try
    {
        const technique = await Technique.findByPk(techniqueId);
        return technique.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.TECHNIQUE);
    }
};

async function updateTechnique(techniqueId, updates)
{
    try
    {
        const[technique, [updatedTechnique]] = await Technique.update(updates, {
            where: {technique_id: techniqueId},
            returning: true
        });
        return updatedTechnique.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.TECHNIQUE);
    }
};

module.exports = {
    createTechnique,
    getTechniqueById,
    getTechniqueByName,
    getTechniques,
    updateTechnique
};