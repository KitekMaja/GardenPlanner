/* 
    Filename: classController.js
    Description: This file is on the business logic layer of the app and it includes logic to work with scientific classification classes.
    Author: Maja Kitek
    Date: 2023-08-16
*/

const Joi = require('joi');

const classQuery = require('../../persistence/scientific_classification/class');

const successMessages = require('../../utils/successMessages');
const errorMessages = require('../../utils/errorMessages');
const statusCode = require('../../utils/statusCodes');

const classSchema = Joi.object({
    class_name: Joi.string().required()
});

exports.getAllClasses = async (req, res) => 
{
    try 
    {
        const classes = await classQuery.getClasses();
        res.status(statusCode.HTTP_OK).json(classes);
    } 
    catch (error) 
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};

exports.getClassByName = async (req, res) => 
{
    try
    {
        const { class_name } = req.params;
        const { error, value } = Joi.string().validate(class_name);  
        if (error)
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_QUERY_PARAMETER + " = " + error});
        }
        
        const plantClass = await classQuery.getClassByName(value);
        if (!plantClass) 
        {
            return res.status(statusCode.HTTP_NOT_FOUND).json({ message: value + errorMessages.NOT_FOUND_ERROR });
        }
        res.status(statusCode.HTTP_OK).json(plantClass);
    }
    catch (error)
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};

exports.getClassById = async (req, res) =>
{
    try
    {
        const { class_id } = req.params;
        const { error, value } = Joi.integer().validate(class_id);
        if (error)
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_QUERY_PARAMETER + " = " + error});
        }

        const plantClass = await classQuery.getClassById(value);
        if (!plantClass) 
        {
            return res.status(statusCode.HTTP_NOT_FOUND).json({ message: value + errorMessages.NOT_FOUND_ERROR });
        }
        res.status(statusCode.HTTP_OK).json(plantClass);
    }
    catch (error)
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};

exports.createClass = async (req, res) =>
{
    const body = req.body;
    try 
    {
        const { error, value } = classSchema.validate(body);     
        if (error) 
        {
            res.status(statusCode.HTTP_BAD_REQUEST).json({ message: errorMessages.INVALID_JSON + " = " + error });
        } 

        const { class_name } = value;
        const existingClass = await classQuery.getClassByName(class_name);
        if (existingClass) 
        {
            return res.status(statusCode.HTTP_CONFLICT).json({ message: errorMessages.PLANT_CLASSES + errorMessages.ALREADY_EXISTS });
        }
        const newClass = await classQuery.createClass(value);
        res.status(statusCode.HTTP_CREATED).json({ message: successMessages.CREATED_SUCCESSFULLY, class: newClass });    
        
    } 
    catch (error) 
    {
        res.status(statusCode.HTTP_INTERNAL_SERVER_ERROR).json({ message: error });
    }
};