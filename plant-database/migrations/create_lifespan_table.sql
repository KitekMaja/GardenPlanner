/*
 * Filename: create_lifespan_table.sql
 * Description: Creates the 'lifespan' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE lifespan(
    lifespan_id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL
);