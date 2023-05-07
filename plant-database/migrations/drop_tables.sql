/*
 * Filename: drop_tables.sql
 * Description: Deletes all the constraints and tables inside 'plants' database
 * Author: Maja Kitek
 * Date: 2023-04-28
 */
 
ALTER TABLE IF EXISTS plant DROP CONSTRAINT IF EXISTS fk_scientific_classification;

ALTER TABLE IF EXISTS scientific_classification DROP CONSTRAINT IF EXISTS fk_genus_id;
ALTER TABLE IF EXISTS scientific_classification DROP CONSTRAINT IF EXISTS fk_family_id;
ALTER TABLE IF EXISTS scientific_classification DROP CONSTRAINT IF EXISTS fk_order_id;
ALTER TABLE IF EXISTS scientific_classification DROP CONSTRAINT IF EXISTS fk_class_id;
ALTER TABLE IF EXISTS scientific_classification DROP CONSTRAINT IF EXISTS fk_phylum_id;

DROP TABLE IF EXISTS scientific_classification;

ALTER TABLE IF EXISTS plant_time_season DROP CONSTRAINT IF EXISTS fk_plant_time;
ALTER TABLE IF EXISTS plant_time_season DROP CONSTRAINT IF EXISTS fk_season_id;
ALTER TABLE IF EXISTS plant_time_season DROP CONSTRAINT IF EXISTS fk_plant_id;

DROP TABLE IF EXISTS plant_time;
DROP TABLE IF EXISTS seasons;
DROP TABLE IF EXISTS plant_time_season;

ALTER TABLE IF EXISTS plant_propagation DROP CONSTRAINT IF EXISTS fk_technique_id;
ALTER TABLE IF EXISTS plant_propagation DROP CONSTRAINT IF EXISTS fk_plant_id;

DROP TABLE IF EXISTS propagation_techniques;
DROP TABLE IF EXISTS plant_propagation;

ALTER TABLE IF EXISTS plant_types DROP CONSTRAINT IF EXISTS fk_plant_id;
ALTER TABLE IF EXISTS plant_types DROP CONSTRAINT IF EXISTS fk_plant_type_id;

DROP TABLE IF EXISTS plant_type;
DROP TABLE IF EXISTS plant_types;

ALTER TABLE IF EXISTS plant_lifespan DROP CONSTRAINT IF EXISTS fk_plant_id;
ALTER TABLE IF EXISTS plant_lifespan DROP CONSTRAINT IF EXISTS fk_lifespan_id;

DROP TABLE IF EXISTS lifespan;
DROP TABLE IF EXISTS plant_lifespan;

ALTER TABLE IF EXISTS plant_part_color DROP CONSTRAINT IF EXISTS fk_plant_id;
ALTER TABLE IF EXISTS plant_part_color DROP CONSTRAINT IF EXISTS fk_color_id;
ALTER TABLE IF EXISTS plant_part_color DROP CONSTRAINT IF EXISTS fk_plant_part_id;

DROP TABLE IF EXISTS color;
DROP TABLE IF EXISTS plant_part;

ALTER TABLE IF EXISTS plant_names DROP CONSTRAINT IF EXISTS fk_plant_id;

DROP TABLE IF EXISTS plant_names;

ALTER TABLE IF EXISTS plant_soil DROP CONSTRAINT IF EXISTS fk_soil_id;
ALTER TABLE IF EXISTS plant_soil DROP CONSTRAINT IF EXISTS fk_plant_id;

DROP TABLE IF EXISTS soil_types;
DROP TABLE IF EXISTS plant_soil;

ALTER TABLE IF EXISTS plant_sunlight_conditions DROP CONSTRAINT IF EXISTS fk_sunlight_id;
ALTER TABLE IF EXISTS plant_sunlight_conditions DROP CONSTRAINT IF EXISTS fk_plant_id;

DROP TABLE IF EXISTS sunlight_types;
DROP TABLE IF EXISTS plant_sunlight_conditions;

ALTER TABLE IF EXISTS plant_hardiness_zone DROP CONSTRAINT IF EXISTS fk_plant_id;
ALTER TABLE IF EXISTS plant_hardiness_zone DROP CONSTRAINT IF EXISTS fk_hardiness_zone;

DROP TABLE IF EXISTS hardiness_zones;
DROP TABLE IF EXISTS plant_hardiness_zone;

DROP TABLE IF EXISTS plant;