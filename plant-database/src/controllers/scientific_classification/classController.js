/* 
    Filename: classController.js
    Description: This file is on the business logic layer of the app and it includes 
                 logic to work with classes.
    Author: Maja Kitek
    Date: 2023-05-10
*/

const Joi = require('joi');

const classQuery = require('../../persistence/scientific_classification/');

const successMessages = require('../../utils/successMessages');
const errorMessages = require('../../utils/errorMessages');
const statusCode = require('../../utils/statusCodes');