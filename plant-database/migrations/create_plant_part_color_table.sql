/*
 * Filename: create_plant_part_color_table.sql
 * Description: Creates the 'plant_part_color' table in the 'plant' database
 * Author: Maja Kitek
 * Date: 2023-05-01
 */

CREATE TABLE plant_part_color (
  plant_part_color_id SERIAL PRIMARY KEY,
  fk_plant_id SERIAL NOT NULL, 
  fk_color_id SERIAL NOT NULL,
  fk_plant_part_id SERIAL NOT NULL,
  CONSTRAINT fk_plant_id FOREIGN KEY (fk_plant_id) REFERENCES plant (plant_id) ON DELETE CASCADE, 
  CONSTRAINT fk_color_id FOREIGN KEY (fk_color_id) REFERENCES color (color_id) ON DELETE CASCADE, 
  CONSTRAINT fk_plant_part_id FOREIGN KEY (fk_plant_part_id) REFERENCES plant_part (plant_part_id) ON DELETE CASCADE
);