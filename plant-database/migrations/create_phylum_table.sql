/*
 * Filename: create_phylum_table.sql
 * Description: Creates the 'phylum' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE phylum(
    phylum_id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL
);