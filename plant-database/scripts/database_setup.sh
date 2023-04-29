#!/bin/bash
#
# Filename: database_setup.sh
# Description: This script sets up the database for the plant database microservice
# Author: Maja Kitek
# Date: 2023-04-28
#

# PostgreSQL database details
DB_USER = "postgres"
DB_NAME = "plants"

# PostgreSQL installation check
if ! command -v psql &> /dev/null
then
    echo "PostgreSQL is not installed on this machine. Please install it first."
    exit 1
fi

# Database creation
echo "-- Creating database -- \n"
./migrations/create_plant_database.sql
echo "-- Done -- \n"

# Enum creation
echo "-- Creating enum values -- \n"
./migrations/create_enum_values.sql
echo "-- Done -- \n"

# Table creation
echo "-- Creating tables -- \n "

echo "-- create scientific classification table -- \n"
./migrations/create_scientific_classification_table.sql

echo "-- create plant conditions table -- \n"
./migrations/create_plant_conditions_table.sql

echo "-- create plant characteristics table -- \n"
./migrations/create_plant_characteristics_table.sql

echo "-- create care guide table -- \n"
./migrations/create_care_guide_table.sql

echo "-- create basic plant info table -- \n"
./migrations/create_basic_plant_info_table.sql

echo "-- Done -- \n"

# Constraints creation
echo "-- Creating constraints -- \n "
./migrations/create_constraints.sql
echo "-- Done -- \n"

# Filling database with data
echo "-- Database fill -- \n "
./migrations/fill_data.sql
echo "-- Done -- \n"