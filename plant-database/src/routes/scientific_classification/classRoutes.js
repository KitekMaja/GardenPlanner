/* 
    Filename: classRoutes.js
    Description: This file sets up routes for the scientific classification class methods.
    Author: Maja Kitek
    Date: 2023-08-16
*/

const express = require('express');
const router = express.Router();
const classController = require('../../controllers/scientific_classification/classController');

// Define routes
router.get('/classes', classController.getAllClasses);
router.get('/classes/:id', classController.getClassById);
router.get('/classes/:name', classController.getClassByName);
router.post('/addClass', classController.createClass);

module.exports = router;