#!/bin/bash
#
# Filename: database_setup.sh
# Description: This script sets up the database for the plant database microservice
# Author: Maja Kitek
# Date: 2023-04-28
#

# PostgreSQL installation check
if ! command psql -V &> /dev/null
then
    echo "PostgreSQL is not installed on this machine. Please install it first."
    exit 1
fi

# Defining database connection parameters
PGDATABASE="plants"
PGUSER="postgres"
export PGPASSWORD="admin"

# Check if the database already exists
if psql -U $PGUSER -lqt | cut -d \| -f 1 | grep -wq $PGDATABASE; then
  echo "Database '$PGDATABASE' already exists. Deleting existing database."
  dropdb -U $PGUSER $PGDATABASE
fi

# Create the database
createdb -U $PGUSER $PGDATABASE

# Check if the creation was successful
if [ $? -eq 0 ]; then
  echo "Database '$PGDATABASE' created successfully."
else
  echo "Failed to create database '$PGDATABASE'."
  exit 1
fi

# Changing directory
cd ../migrations

# Connecting to database and running queries
psql -U $PGUSER -d $PGDATABASE << EOF
-- drop tables
\i drop_tables.sql

-- create genus table
\i create_genus_table.sql

-- create class table
\i create_class_table.sql

-- create order table
\i create_order_table.sql

-- create family table
\i create_family_table.sql

-- create phylum table
\i create_phylum_table.sql

-- create scientific classification table
\i create_scientific_classification_table.sql

-- create habitat table
\i create_habitat_table.sql

-- create plant table
\i create_plant_table.sql

-- create lifespan table
\i create_lifespan_table.sql

-- create plant lifespan
\i create_plant_lifespan_table.sql

-- create plant part
\i create_plant_part_table.sql

-- create color table
\i create_color_table.sql

-- create plant part color
\i create_plant_part_color_table.sql

-- create plant type table
\i create_plant_type_table.sql

-- create propagation techniques table
\i create_propagation_techniques_table.sql

-- create seasons table
\i create_seasons_table.sql

-- create plant time table
\i create_plant_time_table.sql

-- create plant types table
\i create_plant_types_table.sql

-- create plant propagation table
\i create_plant_propagation_table.sql

-- create plant time season table
\i create_plant_time_season_table.sql

-- create plant names table
\i create_plant_names_table.sql

-- create soil types table
\i create_soil_types_table.sql

-- create sunglight types
\i create_sunlight_types_table.sql

-- create hardiness zones table
\i create_hardiness_zones_table.sql

-- create plant soil table
\i create_plant_soil_table.sql

-- create plant sunlight conditions table
\i create_plant_sunlight_conditions_table.sql

-- create plant hardiness zone table
\i create_plant_hardiness_zone_table.sql
EOF

echo "-- DONE --"