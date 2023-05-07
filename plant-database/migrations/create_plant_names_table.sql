/*
 * Filename: create_plant_names_table.sql
 * Description: Creates the 'plant_names' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE plant_names(
    plant_name_id SERIAL PRIMARY KEY,
    name VARCHAR (100) NOT NULL,
    story TEXT,
    fk_plant_id SERIAL NOT NULL,
    CONSTRAINT fk_plant_id FOREIGN KEY (fk_plant_id) REFERENCES plant (plant_id) ON DELETE CASCADE
);