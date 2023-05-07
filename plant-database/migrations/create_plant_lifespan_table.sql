/*
 * Filename: create_plant_lifespan_table.sql
 * Description: Creates the 'plant_lifespan' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE plant_lifespan(
    plant_lifespan_id SERIAL PRIMARY KEY,
    fk_plant_id SERIAL NOT NULL,
    fk_lifespan_id SERIAL NOT NULL,
    CONSTRAINT fk_plant_id FOREIGN KEY (fk_plant_id) REFERENCES plant (plant_id) ON DELETE CASCADE, 
    CONSTRAINT fk_lifespan_id FOREIGN KEY (fk_lifespan_id) REFERENCES lifespan (lifespan_id) ON DELETE CASCADE
);