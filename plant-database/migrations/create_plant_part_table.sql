/*
 * Filename: create_plant_part_table.sql
 * Description: Creates the 'plant_part' table in the 'plant' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE plant_part (
  plant_part_id SERIAL PRIMARY KEY,
  name VARCHAR (50) NOT NULL
);