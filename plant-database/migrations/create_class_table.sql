/*
 * Filename: create_class_table.sql
 * Description: Creates the 'class' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE class(
    class_id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL
);