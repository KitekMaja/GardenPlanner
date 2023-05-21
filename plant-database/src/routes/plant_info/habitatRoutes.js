/* 
    Filename: habitatRoutes.js
    Description: This file sets up routes for the habitat methods.
    Author: Maja Kitek
    Date: 2023-05-22
*/

const express = require('express');
const router = express.Router();
const habitatController = require('../../controllers/plant_info/habitatController');

// Define routes
router.get('/habitats', habitatController.getAllHabitats);
router.get('/habitats/name/:habitatName', habitatController.getHabitatByName);
router.get('/habitats/id/:habitatId', habitatController.getHabitatById);
router.post('/addHabitat', habitatController.createHabitat);

module.exports = router;