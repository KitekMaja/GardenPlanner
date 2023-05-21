/* 
    Filename: habitat.js
    Description: This file is on the persistence layer of the app and it includes 
                 queries to insert or get data from databse.
    Author: Maja Kitek
    Date: 2023-05-21
*/

const { Habitat } = require('../../models/plant_info/habitatModel');
const errorMessages = require('../../utils/errorMessages');

async function getHabitats()
{
    try
    {
        const habitats = await Habitat.findAll();
        return habitats.map((habitat) => habitat.toJSON());
    }
    catch (error)
    {
        throw new Error(errorMessages.RETURN_ERROR + errorMessages.HABITATS);
    }
};

async function createHabitat(habitatData)
{
    try
    {
        const habitat = await Habitat.create(habitatData);
        return habitat.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.CREATE_ERROR + errorMessages.HABITAT);
    }
};

async function getHabitatByName(habitatName)
{
    try
    {
        const habitat = await habitat.findOne({
            where: { name: habitatName },
            returning: true
        });
        return habitat.toJSON();
    }
    catch(error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.HABITAT);
    }
};

async function getHabitatById(habitatId)
{
    try
    {
        const habitat = await Habitat.findByPk(habitatId);
        return habitat.toJSON();
    }
    catch (error)
    {
        throw new Error (errorMessages.RETURN_ERROR + errorMessages.HABITAT);
    }
};

module.exports = {
    createHabitat,
    getHabitats,
    getHabitatById,
    getHabitatByName
};