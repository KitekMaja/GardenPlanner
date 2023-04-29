/*
 * Filename: create_care_guide_table.sql
 * Description: Creates the 'care_guide' table in the 'plant' database
 * Author: Maja Kitek
 * Date: 2023-04-28
 */

 DROP TABLE IF EXISTS care_guide;

 CREATE TABLE IF NOT EXISTS care_guide (
    care_guide_id SERIAL PRIMARY KEY,
    water TEXT,
    fertilization TEXT NOT NULL,
    pruning TEXT,
    planting_time seasons [],
    harvest_time seasons [],
    propagation propagation_techniques [] NOT NULL,
    potting_suggestions TEXT
 );