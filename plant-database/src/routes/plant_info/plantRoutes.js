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
router.get('/plants/:plantName', plantController.getPlantByName);
router.get('/plants/classification/:classificationId', plantController.getPlantsByClassification);
router.get('/plants/habitat/:habitatId', plantController.getPlantsByHabitat);
router.post('/addPlant', plantController.createPlant);
router.put('/updatePlant/:plantName', plantController.updatePlant);

module.exports = router;
