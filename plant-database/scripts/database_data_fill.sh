#!/bin/bash
#
# Filename: database_data_fill.sh
# Description: This script fills up database with data
# Author: Maja Kitek
# Date: 2023-05-01
#

# PostgreSQL database details
PGDATABASE="plants"
PGUSER="postgres"
export PGPASSWORD="admin"

# PostgreSQL installation check
if ! command -v psql &> /dev/null
then
    echo "PostgreSQL is not installed on this machine. Please install it first."
    exit 1
fi

cd ../migrations

# Filling database with data
echo "-- DATABASE FILL -- \n "
psql -U $PGUSER -d $PGDATABASE << EOF
-- fill tables with data
\i fill_data.sql
EOF
echo "-- DONE -- \n"