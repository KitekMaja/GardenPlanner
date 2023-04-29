/*
 * Filename: create_plant_characteristics_table.sql
 * Description: Creates the 'plant_characteristics' table in the 'plant' database
 * Author: Maja Kitek
 * Date: 2023-04-28
 */

 DROP TABLE IF EXISTS plant_characteristics;

 CREATE TABLE IF NOT EXISTS plant_characteristics (
    characteristics_id SERIAL PRIMARY KEY,
    plant_type VARCHAR (50) [],
    life_span VARCHAR (50) [],
    bloom_time seasons [],
    plant_height NUMERIC NOT NULL,
    spread NUMERIC,
    flower_size REAL,
    habitat VARCHAR (50),
    flower_color VARCHAR (50) [] NOT NULL,
    leaf_color VARCHAR (50) [] NOT NULL,
    fruit_color VARCHAR (50) [],
    stem_color VARCHAR (50) [] NOT NULL
 );