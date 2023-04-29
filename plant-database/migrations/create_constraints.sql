/*
 * Filename: create_constraints.sql
 * Description: Creates the constraints among tables
 * Author: Maja Kitek
 * Date: 2023-04-28
 */

ALTER TABLE basic_plant_info 
ADD CONSTRAINT care_guide_id 
FOREIGN KEY (care_guide_id) 
REFERENCES care_guide (care_guide_id);

ALTER TABLE basic_plant_info 
ADD CONSTRAINT plant_characteristics_id 
FOREIGN KEY (plant_characteristics_id) 
REFERENCES plant_characteristics (characteristics_id);

ALTER TABLE basic_plant_info 
ADD CONSTRAINT plant_conditions_id 
FOREIGN KEY (plant_conditions_id) 
REFERENCES plant_conditions (conditions_id);

ALTER TABLE basic_plant_info 
ADD CONSTRAINT scientific_classification_id 
FOREIGN KEY (scientific_classification_id) 
REFERENCES scientific_classification (classification_id);