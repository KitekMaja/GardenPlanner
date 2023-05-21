/* 
    Filename: plantController.js
    Description: This file is on the business logic layer of the app and it includes 
                 logic to work with plants.
    Author: Maja Kitek
    Date: 2023-05-09
*/

const Joi = require('joi');

const plantQuery = require('../../persistence/plant_info/plants');

const successMessages = require('../../utils/successMessages');
const errorMessages = require('../../utils/errorMessages');
const statusCode = require('../../utils/statusCodes');

const plantSchema = Joi.object({
    botanical_name: Joi.string().required(),
    poisonous: Joi.boolean().required(),
    description: Joi.string().required(),
    min_plant_temperature: Joi.number(),
    max_plant_temperature: Joi.number(),
    interesting_fact: Joi.string(),
    symbolism: Joi.string(),
    plant_height: Joi.number(),
    spread: Joi.number(),
    flower_size: Joi.number(),
    watering_information: Joi.string(),
    fertilization_information: Joi.string(),
    pruning: Joi.string(),
    potting_suggestions: Joi.string(),
    difficulty_description: Joi.string(),
    fk_scientific_classification: Joi.integer().required(),
    fk_habitat_id: Joi.integer().required()
});

exports.getAllPlants = async (req, res) => 
{
    try 
    {
        const plants = await plantQuery.getPlants();
        res.status(statusCode.HTTP_OK).json(plants);
    } 
    catch (error) 
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ error: errorMessages.RETURN_ERROR + errorMessages.PLANTS});
    }
};

exports.createPlant = async (req, res) =>
{
    const { botanical_name, poisonous, description, 
        min_plant_temperature, max_plant_temperature, 
        interesting_fact, symbolism, plant_height, 
        spread, flower_size, watering_information, 
        fertilization_information, pruning, 
        potting_suggestions, difficulty_description, 
        fk_scientific_classification, fk_habitat_id } = req.body;

    try 
    {
        const { error, value } = plantSchema.validate(req.body);     
        if (error) 
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_JSON });
        } 
        else 
        {
            const existingPlant = await plantQuery.getPlant(botanical_name);
            if (existingPlant) 
            {
                return res.status(statusCode.HTTP_CONFLICT).json({ message: errorMessages.PLANT_ALREADY_EXISTS });
            }
            const newPlant = await plantQuery.createPlant(value);
            res.status(statusCode.HTTP_CREATED).json({ message: successMessages.CREATED_SUCCESSFULLY, plant: newPlant });    
        }
    } 
    catch (err) 
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: errorMessages.CREATE_ERROR + errorMessages.PLANT });
    }
};

exports.getPlantByName = async (req, res) => 
{
    try
    {
        const { botanical_name } = req.params;
        const { error, value } = Joi.string().validate(botanical_name);  
        if (error)
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_QUERY_PARAMETER });
        }
        else
        {
            const plant = await plantQuery.getPlant(botanical_name);
            if (!plant) 
            {
                return res.status(statusCode.HTTP_NOT_FOUND).json({ message: botanical_name + errorMessages.NOT_FOUND_ERROR });
            }
            res.status(statusCode.HTTP_OK).json(plant);
        }
    }
    catch (error)
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ error: errorMessages.RETURN_ERROR + errorMessages.PLANT});
    }
};

exports.updatePlant = async (req, res) => 
{
    const { botanical_name, poisonous, description, 
        min_plant_temperature, max_plant_temperature, 
        interesting_fact, symbolism, plant_height, 
        spread, flower_size, watering_information, 
        fertilization_information, pruning, 
        potting_suggestions, difficulty_description, 
        fk_scientific_classification, fk_habitat_id } = req.body;

    try 
    {
        const { error, value } = plantSchema.validate(req.body);     
        if (error) 
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_JSON });
        } 
        else 
        {
            const updatePlant = await plantQuery.updatePlant(botanical_name, value);
            if (!updatePlant) 
            {
                return res.status(statusCode.HTTP_NOT_FOUND).json({ message: botanical_name + errorMessages.NOT_FOUND_ERROR });
            }
            res.status(statusCode.HTTP_OK).json({ message: successMessages.UPDATED_SUCCESFULLY, plant: updatePlant });
        }
    } 
    catch (err) 
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: errorMessages.UPDATE_ERROR + errorMessages.PLANTS });
    }
};