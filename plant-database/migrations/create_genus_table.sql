/*
 * Filename: create_genus_table.sql
 * Description: Creates the 'genus' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE genus(
    genus_id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL
);