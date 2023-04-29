/*
 * Filename: create_enum_values.sql
 * Description: Creates the different enum values to be used in the database
 * Author: Maja Kitek
 * Date: 2023-04-28
 */

CREATE TYPE IF NOT EXISTS sunlight_types as ENUM ("partial sun", "full shade", "full sun");
CREATE TYPE IF NOT EXISTS soil_types as ENUM ("loam", "sand", "clay", "chalky", "sandy loam", "acidic", "neutral" , "alkaline", "slightly acidic", "slightly alkaline");
CREATE TYPE IF NOT EXISTS seasons AS ENUM ("spring", "summer", "fall", "winter");
CREATE TYPE IF NOT EXISTS propagation_techniques AS ENUM ("cutting", "layering", "sowing", "division", "grafting")