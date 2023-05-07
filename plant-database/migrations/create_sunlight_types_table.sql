/*
 * Filename: create_sunlight_types_table.sql
 * Description: Creates the 'sunlight_types' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE sunlight_types(
    sunlight_id SERIAL PRIMARY KEY,
    intensity VARCHAR (50) NOT NULL
);