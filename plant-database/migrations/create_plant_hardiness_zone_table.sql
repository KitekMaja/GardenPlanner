/*
 * Filename: create_plant_hardiness_zone_table.sql
 * Description: Creates the 'plant_hardiness_zone' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE plant_hardiness_zone(
    plant_hardiness_zone_id SERIAL PRIMARY KEY,
    fk_plant_id SERIAL NOT NULL,
    fk_hardiness_zone SERIAL NOT NULL,
    CONSTRAINT fk_plant_id FOREIGN KEY (fk_plant_id) REFERENCES plant (plant_id) ON DELETE CASCADE, 
    CONSTRAINT fk_hardiness_zone FOREIGN KEY (fk_hardiness_zone) REFERENCES hardiness_zones (zone_id) ON DELETE CASCADE
);