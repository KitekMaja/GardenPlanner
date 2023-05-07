/*
 * Filename: create_propagation_tecnhiques_table.sql
 * Description: Creates the 'propagation_techniques' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */
 
CREATE TABLE propagation_techniques(
    technique_id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL
);