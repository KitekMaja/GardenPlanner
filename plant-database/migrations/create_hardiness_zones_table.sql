/*
 * Filename: create_hardiness_zones_table.sql
 * Description: Creates the 'hardiness_zones' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE hardiness_zones(
    zone_id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    min_temperature REAL NOT NULL,
    max_temperature REAL NOT NULL
);