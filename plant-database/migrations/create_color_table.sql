/*
 * Filename: create_color_table.sql
 * Description: Creates the 'color' table in the 'plant' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE color (
  color_id SERIAL PRIMARY KEY,
  name VARCHAR (50) NOT NULL
);