/*
 * Filename: create_plant_table.sql
 * Description: Creates the 'plant' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-04-28
 */
 
CREATE TABLE plant (
   plant_id SERIAL PRIMARY KEY ,
   botanical_name VARCHAR (100) NOT NULL,
   poisonous BOOLEAN NOT NULL,
   description TEXT NOT NULL,
   min_plant_temperature REAL,
   max_plant_temperature REAL,
   interesting_fact TEXT,
   symbolism TEXT,
   plant_height REAL,
   spread NUMERIC,
   flower_size REAL,
   watering_information TEXT,
   fertilization_information TEXT,
   pruning TEXT,
   potting_suggestions TEXT,
   difficulty_description TEXT,
   fk_scientific_classification SERIAL NOT NULL,
   fk_habitat_id SERIAL,
   CONSTRAINT fk_scientific_classification FOREIGN KEY (fk_scientific_classification) REFERENCES scientific_classification (classification_id) ON DELETE CASCADE,
   CONSTRAINT fk_habitat_id FOREIGN KEY (fk_habitat_id) REFERENCES habitat (habitat_id) ON DELETE CASCADE
);