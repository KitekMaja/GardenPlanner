/*
 * Filename: create_scientific_classification_table.sql
 * Description: Creates the 'scientific_classification' table in the 'plant' database
 * Author: Maja Kitek
 * Date: 2023-04-28
 */

 DROP TABLE IF EXISTS scientific_classification;

 CREATE TABLE IF NOT EXISTS scientific_classification (
    classification_id SERIAL PRIMARY KEY,
    genus VARCHAR (150) NOT NULL,
    family VARCHAR (150) NOT NULL,
    order VARCHAR (250) NOT NULL,
    class VARCHAR (250) NOT NULL,
    phylum VARCHAR (250) NOT NULL
 );