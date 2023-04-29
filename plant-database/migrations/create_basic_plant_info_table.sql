/*
 * Filename: create_basic_plant_info_table.sql
 * Description: Creates the 'basic_plant_info' table in the 'plant' database
 * Author: Maja Kitek
 * Date: 2023-04-28
 */

 DROP TABLE IF EXISTS basic_plant_info;

 CREATE TABLE IF NOT EXISTS basic_plant_info (
    plant_id SERIAL PRIMARY KEY,
    botanical_name VARCHAR (100) NOT NULL,
    known_as VARCHAR (100) [],
    species VARCHAR (100) NOT NULL,
    description TEXT NOT NULL,
    poisonous BOOLEAN NOT NULL,
    name_story TEXT [],
    interesting_facts TEXT [],
    symbolism TEXT
 );