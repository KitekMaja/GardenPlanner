/*
 * Filename: create_plant_propagation_table.sql
 * Description: Creates the 'plant_propagation' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE plant_propagation(
    propagation_id SERIAL PRIMARY KEY,
    fk_plant_id SERIAL NOT NULL,
    fk_propagation_technique SERIAL NOT NULL,
    CONSTRAINT fk_plant_id FOREIGN KEY (fk_plant_id) REFERENCES plant (plant_id) ON DELETE CASCADE, 
    CONSTRAINT fk_propagation_technique FOREIGN KEY (fk_propagation_technique) REFERENCES propagation_techniques (technique_id) ON DELETE CASCADE
);