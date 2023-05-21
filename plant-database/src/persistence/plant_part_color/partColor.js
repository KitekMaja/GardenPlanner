/* 
    Filename: family.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-11
*/

const { PartColor } = require('../../models/plant_part_color/plantPartColorModel');
const errorMessages = require('../../utils/errorMessages');

async function getPartColors()
{
    try
    {
        const partColors = await PartColor.findAll();
        return partColors.map((partColor) => partColor.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PARTS + errorMessages.COLORS);
    }
};

async function createPartColor(partColorData)
{
    try
    {
        const partColor = await PartColor.create(partColorData);
        return partColor.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.PART + errorMessages.COLOR);
    }
};

async function getPartColorById(partColorId)
{
    try
    {
        const partColor = await PartColor.findByPk(partColorId);
        return partColor.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.PART + errorMessages.COLOR);
    }
};

async function updatePartColor(partColorId, updates)
{
    try
    {
        const[partColor, [updatedPartColor]] = await PartColor.update(updates, {
            where: {part_color_id: partColorId},
            returning: true
        });
        return updatedPartColor.toJSON();
    }
    catch (error)
    {
        throw new Error(errorMessages.UPDATE_ERROR + errorMessages.PART + errorMessages.COLOR);
    }
};

async function getColoredParts(colorId, partId)
{
    try
    {
        const partColors = await PartColor.findAll({
            where: {
                fk_color_id: colorId,
                fk_plant_part_id: partId
            },
            returning: true
          });
        return partColors.map((part) => part.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.PART + errorMessages.COLOR);
    }
};

module.exports = {
    getPartColorById,
    getPartColors,
    createPartColor,
    updatePartColor,
    getColoredParts
};