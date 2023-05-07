/*
 * Filename: create_order_table.sql
 * Description: Creates the 'order' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE plant_order(
    order_id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL
);