/* 
    Filename: plantNameController.js
    Description: This file is on the business logic layer of the app and it includes 
                 logic to work with plants.
    Author: Maja Kitek
    Date: 2023-06-11
*/

const Joi = require('joi');

const plantNameQuery = require('../../persistence/plant_info/plantNames');

const successMessages = require('../../utils/successMessages');
const errorMessages = require('../../utils/errorMessages');
const statusCode = require('../../utils/statusCodes');

const plantNameSchema = Joi.object({
    name: Joi.string().required(),
    story: Joi.string(),
    fk_plant_id: Joi.integer().required()
});

exports.getAllPlantNames = async (req, res) =>
{
    try 
    {
        const names = await plantNameQuery.getPlantNames();
        res.status(statusCode.HTTP_OK).json(names);
    } 
    catch (error) 
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};

exports.createPlantName = async (req, res) =>
{
    const body = req.body;
    try 
    {
        const { error, value } = plantNameSchema.validate(body);     
        if (error) 
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_JSON + " = " + error });
        } 

        const { plantName } = value;
        const existingPlantName = await plantNameQuery.getPlantName(plantName);
        if (existingPlantName) 
        {
            return res.status(statusCode.HTTP_CONFLICT).json({ message: errorMessages.PLANT_NAME + errorMessages.ALREADY_EXISTS });
        }
        const newPlant = await plantNameQuery.createPlantName(value);
        res.status(statusCode.HTTP_CREATED).json({ message: successMessages.CREATED_SUCCESSFULLY, plantName: newPlant });    
        
    } 
    catch (error) 
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};

exports.updatePlantName = async (req, res) =>
{
    const body = req.body;
    try 
    {
        const { error, value } = plantNameSchema.validate(body);     
        if (error) 
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_JSON + " = " + error });
        } 

        const { plant_name } = value;
        const updatePlant = await plantNameQuery.getPlantName();
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

exports.getPlantNamesByPlantId = async (req, res) =>
{
    try
    {
        const { plant_id } = req.params;
        const { error, value } = Joi.number().validate(plant_id);  
        if (error)
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_QUERY_PARAMETER + " = " + error});
        }
        
        const plants = await plantNameQuery.getPlantNames(value);
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

exports.getPlantNameInfo = async (req, res) =>
{
    try 
    {
        const { plant_name } = req.params;
        const { error, value } = Joi.string().validate(plant_name);  
        if (error)
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_QUERY_PARAMETER + " = " + error});
        }
        const plant_info = await plantNameQuery.getPlantName(value);
        res.status(statusCode.HTTP_OK).json(plant_info);
    } 
    catch (error) 
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};