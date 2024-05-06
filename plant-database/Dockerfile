# Use the official PostgreSQL image as the base image
FROM postgres:latest

# Copy the contents of the db directory into the container
COPY src/main/resources/db/scripts/db-setup.sh /docker-entrypoint-initdb.d/
COPY src/main/resources/db/migrations /db/migrations

# Set execute permissions for the shell script
RUN chmod +x /docker-entrypoint-initdb.d/*.sh