/* 
    Filename: family.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-11
*/

const { Family } = require('../../models/scientific_classification/familyModel');
const errorMessages = require('../../utils/errorMessages');

async function getFamilies()
{
    try
    {
        const families = await Family.findAll();
        return families.map((family) => family.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.FAMILIES);
    }
};

async function createFamily(familyData)
{
    try
    {
        const family = await Family.create(familyData);
        return family.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.FAMILY);
    }
};

async function getFamilyByName(familyName)
{
    try
    {
        const family = await Family.findOne({
            where: { name: familyName },
            returning: true
        });
        return family.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.FAMILY);
    }
};

async function getFamilyById(familyId)
{
    try
    {
        const family = await Family.findByPk(familyId);
        return family.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.FAMILY);
    }
};

async function updateFamily(familyId, updates)
{
    try
    {
        const[family, [updatedFamily]] = await Family.update(updates, {
            where: {family_id: familyId},
            returning: true
        });
        return updatedFamily.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.FAMILY);
    }
};

module.exports = {
    getFamilies,
    getFamilyById,
    getFamilyByName,
    createFamily,
    updateFamily
};