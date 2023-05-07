/*
 * Filename: create_habitat_table.sql
 * Description: Creates the 'habitat' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-02
 */

CREATE TABLE habitat(
    habitat_id SERIAL PRIMARY KEY,
    name VARCHAR (100) NOT NULL
);