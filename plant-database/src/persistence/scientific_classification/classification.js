/* 
    Filename: classification.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-11
*/

const { Classification } = require('../../models/scientific_classification/scientificClassificationModel');
const errorMessages = require('../../utils/errorMessages');

async function getClassifications()
{
    try
    {
        const classifications = await Classification.findAll();
        return classifications.map((classification) => classification.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.CLASSIFICATIONS);
    }
};

async function createClassification(classificationData)
{
    try
    {
        const classification = await Classification.create(classificationData);
        return classification.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.CLASSIFICATION);
    }
};

async function getClassificationByName(classificationName)
{
    try
    {
        const classification = await Classification.findOne({
            where: { name: classificationName },
            returning: true
        });
        return classification.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.CLASSIFICATION);
    }
};

async function getClassificationById(classificationId)
{
    try
    {
        const classification = await Classification.findByPk(classificationId);
        return classification.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.CLASSIFICATION);
    }
};

async function updateClassification(classificationId, updates)
{
    try
    {
        const[classification, [updatedClassification]] = await Classification.update(updates, {
            where: {classification_id: classificationId},
            returning: true
        });
        return updatedClassification.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.CLASSIFICATION);
    }
};

module.exports = {
    getClassificationById,
    getClassificationByName,
    getClassifications,
    createClassification,
    updateClassification
};