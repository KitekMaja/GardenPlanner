/* 
    Filename: plantRoutes.js
    Description: This file sets up routes for the plant methods.
    Author: Maja Kitek
    Date: 2023-05-10
*/

const express = require('express');
const router = express.Router();
const plantController = require('../../controllers/plant_info/plantController');

// Define routes
router.get('/plants', plantController.getAllPlants);
router.post('/addPlant', plantController.createPlant);
router.get('/plants/:id', plantController.getPlantByName);
router.put('/updatePlant/:id', plantController.updatePlant);

module.exports = router;
