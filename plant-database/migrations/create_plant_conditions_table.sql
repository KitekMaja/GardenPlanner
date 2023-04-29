/*
 * Filename: create_plant_conditions_table.sql
 * Description: Creates the 'plant_conditions' table in the 'plant' database
 * Author: Maja Kitek
 * Date: 2023-04-28
 */

 DROP TABLE IF EXISTS plant_conditions;

 CREATE TABLE IF NOT EXISTS plant_conditions (
    conditions_id SERIAL PRIMARY KEY,
    difficulty_rating TEXT,
    sunlight sunlight_types [] NOT NULL,
    hardiness_zone [] NUMERIC NOT NULL,
    soil soil_types []
 );