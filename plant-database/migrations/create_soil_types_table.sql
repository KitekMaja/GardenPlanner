/*
 * Filename: create_soil_types_table.sql
 * Description: Creates the 'soil_types' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE soil_types(
    soil_id SERIAL PRIMARY KEY,
    name VARCHAR (100) NOT NULL
);