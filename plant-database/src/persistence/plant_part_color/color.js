/* 
    Filename: color.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-11
*/

const { Color } = require('../../models/plant_part_color/colorModel');
const errorMessages = require('../../utils/errorMessages');

async function getColors()
{
    try
    {
        const colors = await Color.findAll();
        return colors.map((color) => color.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.COLORS);
    }
};

async function createColor(colorData)
{
    try
    {
        const color = await Color.create(colorData);
        return color.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.COLOR);
    }
};

async function getColorByName(colorName)
{
    try
    {
        const color = await Color.findOne({
            where: { name: colorName },
            returning: true
        });
        return color.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.COLOR);
    }
};

async function getColorById(colorId)
{
    try
    {
        const color = await Color.findByPk(colorId);
        return color.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.COLOR);
    }
};

async function updateColor(colorId, updates)
{
    try
    {
        const[color, [updatedColor]] = await Color.update(updates, {
            where: {color_id: colorId},
            returning: true
        });
        return updatedColor.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.COLOR);
    }
};

module.exports = {
    createColor,
    updateColor,
    getColorById,
    getColorByName,
    getColors
};