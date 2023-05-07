/*
 * Filename: create_plant_sunlight_conditions_table.sql
 * Description: Creates the 'plant_sunlight_conditions' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE plant_sunlight_conditions(
    plant_sunlight_conditions_id SERIAL PRIMARY KEY,
    fk_plant_id SERIAL NOT NULL,
    fk_sunlight_id SERIAL NOT NULL,
    CONSTRAINT fk_plant_id FOREIGN KEY (fk_plant_id) REFERENCES plant (plant_id) ON DELETE CASCADE, 
    CONSTRAINT fk_sunlight_id FOREIGN KEY (fk_sunlight_id) REFERENCES sunlight_types (sunlight_id) ON DELETE CASCADE
);