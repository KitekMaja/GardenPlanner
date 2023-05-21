/* 
    Filename: habitatController.js
    Description: This file is on the business logic layer of the app and it includes 
                 logic to work with habitats.
    Author: Maja Kitek
    Date: 2023-05-22
*/

const Joi = require('joi');

const habitatQuery = require('../../persistence/plant_info/habitat');

const successMessages = require('../../utils/successMessages');
const errorMessages = require('../../utils/errorMessages');
const statusCode = require('../../utils/statusCodes');

const habitatSchema = Joi.object({
    name: Joi.string().required()
});

exports.getAllHabitats = async (req, res) =>
{
    try
    {
        const habitats = await habitatQuery.getHabitats();
        res.status(statusCode.HTTP_OK).json(habitats);
    }
    catch(error)
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};

exports.getHabitatByName = async (req, res) =>
{
    try
    {
        const { habitat_name } = req.params;
        const { error, value } = Joi.string().validate(habitat_name);
        if(error)
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_QUERY_PARAMETER + " = " + error});
        }

        const habitat = await habitatQuery.getHabitatByName(value);
        if (!habitat) 
        {
            return res.status(statusCode.HTTP_NOT_FOUND).json({ message: value + errorMessages.NOT_FOUND_ERROR });
        }
        res.status(statusCode.HTTP_OK).json(habitat);
    }
    catch(error)
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};

exports.getHabitatById = async (req, res) =>
{
    try
    {
        const { habitat_id } = req.params;
        const { error, value } = Joi.integer().validate(habitat_id);
        if(error)
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_QUERY_PARAMETER + " = " + error});
        }

        const habitat = await habitatQuery.getHabitatById(value);
        if (!habitat) 
        {
            return res.status(statusCode.HTTP_NOT_FOUND).json({ message: value + errorMessages.NOT_FOUND_ERROR });
        }
        res.status(statusCode.HTTP_OK).json(habitat);
    }
    catch(error)
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};

exports.createHabitat = async (req, res) =>
{
    const { habitat_name } = req.body;
    try
    {
        const { error, value } = habitatSchema.validate(habitat_name);
        if (error)
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_JSON  + " = " + error });
        }

        const existingHabitat = await habitatQuery.getHabitatByName(value);
        if (existingHabitat) 
        {
            return res.status(statusCode.HTTP_CONFLICT).json({ message: errorMessages.HABITAT + errorMessages.ALREADY_EXISTS });
        }
        const newHabitat = await habitatQuery.createHabitat(value);
        res.status(statusCode.HTTP_CREATED).json({ message: successMessages.CREATED_SUCCESSFULLY, habitat: newHabitat});
    }
    catch(error)
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};