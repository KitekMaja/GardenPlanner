/*
 * Filename: create_plant_types_table.sql
 * Description: Creates the 'plant_types' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE plant_types(
    plant_types_id SERIAL PRIMARY KEY,
    fk_plant_id SERIAL NOT NULL,
    fk_plant_type_id SERIAL NOT NULL,
    CONSTRAINT fk_plant_id FOREIGN KEY (fk_plant_id) REFERENCES plant (plant_id) ON DELETE CASCADE, 
    CONSTRAINT fk_plant_type_id FOREIGN KEY (fk_plant_type_id) REFERENCES plant_type (plant_type_id) ON DELETE CASCADE
);