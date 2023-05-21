/* 
    Filename: class.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-10
*/

const { PlantClass } = require('../../models/scientific_classification/classModel');
const errorMessages = require('../../utils/errorMessages');

async function getClasses()
{
    try
    {
        const classes = await PlantClass.findAll();
        return classes.map((plant_class) => plant_class.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PLANT_CLASS);
    }
};

async function createClass(classData)
{
    try
    {
        const plantClass = await PlantClass.create(classData);
        return plantClass.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.CREATE_ERROR + errorMessages.PLANT_CLASS);
    }
};

async function getClassByName(className)
{
    try
    {
        const plantClass = await PlantClass.findOne({
            where: { name: className},
            returning: true
        });
        plantClass.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT_CLASS);
    }
};

async function getClassById(classId)
{
    try
    {
        const plantClass = await PlantClass.findByPk(classId);
        return plantClass.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PLANT_CLASS);
    }
};

async function updateClass(classId, updates)
{
    try
    {
        const[plantClass, [updatedClass]] = await PlantClass.update(updates, {
            where: {class_id: classId},
            returning: true
        });
        return updatedClass.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.PLANT_CLASS);
    }
};

module.exports = {
    getClassById,
    getClassByName,
    getClasses,
    createClass,
    updateClass
};