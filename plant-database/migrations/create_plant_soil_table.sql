/*
 * Filename: create_plant_soil_table.sql
 * Description: Creates the 'plant_soil' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE plant_soil(
    plant_soil_id SERIAL PRIMARY KEY,
    fk_plant_id SERIAL NOT NULL,
    fk_soil_id SERIAL NOT NULL,
    CONSTRAINT fk_plant_id FOREIGN KEY (fk_plant_id) REFERENCES plant (plant_id) ON DELETE CASCADE, 
    CONSTRAINT fk_soil_id FOREIGN KEY (fk_soil_id) REFERENCES soil_types (soil_id) ON DELETE CASCADE
);