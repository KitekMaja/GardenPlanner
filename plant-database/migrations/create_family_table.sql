/*
 * Filename: create_family_table.sql
 * Description: Creates the 'family' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */
 
CREATE TABLE family(
    family_id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL
);