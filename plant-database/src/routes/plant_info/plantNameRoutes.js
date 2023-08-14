/* 
    Filename: plantNameRoutes.js
    Description: This file sets up routes for the plant name methods.
    Author: Maja Kitek
    Date: 2023-06-15
*/

const express = require('express');
const router = express.Router();
const plantNameController = require('../../controllers/plant_info/plantNameController');

// Define routes
router.get('/plantNames', plantNameController.getAllPlantNames);
router.get('/plantNames/plantId', plantNameController.getPlantNamesByPlantId);
router.get('/plantNames/nameId', plantNameController.getPlantNameInfo);
router.post('/plantNames/createPlantName', plantNameController.createPlantName);
router.put('/plantNames/updatePlantName', plantNameController.updatePlantName);

module.exports = router;
