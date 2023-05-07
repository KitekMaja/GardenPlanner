/*
 * Filename: create_plant_time_table.sql
 * Description: Creates the 'plant_time' table in the 'plants' database - plant_time table stands for bloom time, plant time or harvest time
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE plant_time(
    plant_time_id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL
);