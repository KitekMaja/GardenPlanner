/*
 * Filename: create_plant_time_season_table.sql
 * Description: Creates the 'create_plant_time_season_table' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE plant_time_season(
    plant_time_id SERIAL PRIMARY KEY,
    fk_plant_id SERIAL NOT NULL,
    fk_season_id SERIAL NOT NULL,
    fk_plant_time SERIAL NOT NULL,
    CONSTRAINT fk_plant_id FOREIGN KEY (fk_plant_id) REFERENCES plant (plant_id) ON DELETE CASCADE, 
    CONSTRAINT fk_season_id FOREIGN KEY (fk_season_id) REFERENCES seasons (season_id) ON DELETE CASCADE,
    CONSTRAINT fk_plant_time FOREIGN KEY (fk_plant_time) REFERENCES plant_time (plant_time_id) ON DELETE CASCADE
);