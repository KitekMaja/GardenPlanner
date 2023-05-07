/*
 * Filename: create_seasons_table.sql
 * Description: Creates the 'seasons' table in the 'plants' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE seasons(
    season_id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL
);