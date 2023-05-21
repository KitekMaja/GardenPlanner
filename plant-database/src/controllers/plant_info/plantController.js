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
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
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
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_QUERY_PARAMETER + " = " + error});
        }
        
        const plant = await plantQuery.getPlant(value);
        if (!plant) 
        {
            return res.status(statusCode.HTTP_NOT_FOUND).json({ message: value + errorMessages.NOT_FOUND_ERROR });
        }
        res.status(statusCode.HTTP_OK).json(plant);
    }
    catch (error)
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};

exports.getPlantsByClassification = async (req, res) =>
{
    try
    {
        const { classification_id } = req.params;
        const { error, value } = Joi.integer().validate(classification_id);
        if (error)
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_QUERY_PARAMETER + " = " + error});
        }

        const plants = await plantQuery.getPlantsByClassificationId(value);
        if (!plants) 
        {
            return res.status(statusCode.HTTP_NOT_FOUND).json({ message: value + errorMessages.NOT_FOUND_ERROR });
        }
        res.status(statusCode.HTTP_OK).json(plants);
    }
    catch (error)
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};

exports.getPlantsByHabitat = async (req, res) =>
{
    try
    {
        const { habitat_id } = req.params;
        const { error, value } = Joi.integer().validate(habitat_id);
        if (error)
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_QUERY_PARAMETER + " = " + error});
        }

        const plants = await plantQuery.getPlantsByHabitatId(value);
        if (!plants)
        {
            return res.status(statusCode.HTTP_NOT_FOUND).json({ message: value + errorMessages.NOT_FOUND_ERROR });
        }
        res.status(HTTP_OK).json(plants);
    }
    catch (error)
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error});
    }
};

exports.createPlant = async (req, res) =>
{
    const body = req.body;
    try 
    {
        const { error, value } = plantSchema.validate(body);     
        if (error) 
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_JSON + " = " + error });
        } 

        const { botanical_name } = value;
        const existingPlant = await plantQuery.getPlant(botanical_name);
        if (existingPlant) 
        {
            return res.status(statusCode.HTTP_CONFLICT).json({ message: errorMessages.PLANT + errorMessages.ALREADY_EXISTS });
        }
        const newPlant = await plantQuery.createPlant(value);
        res.status(statusCode.HTTP_CREATED).json({ message: successMessages.CREATED_SUCCESSFULLY, plant: newPlant });    
        
    } 
    catch (error) 
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};

exports.updatePlant = async (req, res) => 
{
    const body = req.body;
    try 
    {
        const { error, value } = plantSchema.validate(body);     
        if (error) 
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_JSON + " = " + error });
        } 

        const { botanical_name } = value;
        const updatePlant = await plantQuery.updatePlant(botanical_name, value);
        if (!updatePlant) 
        {
            return res.status(statusCode.HTTP_NOT_FOUND).json({ message: botanical_name + errorMessages.NOT_FOUND_ERROR });
        }
        res.status(statusCode.HTTP_OK).json({ message: successMessages.UPDATED_SUCCESFULLY, plant: updatePlant });
    } 
    catch (error) 
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};