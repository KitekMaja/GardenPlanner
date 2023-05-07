/*
 * Filename: create_plant_type_table.sql
 * Description: Creates the 'plant_type' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE plant_type(
    plant_type_id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL
);