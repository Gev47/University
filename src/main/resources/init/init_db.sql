-- Create a new database
CREATE DATABASE university_db
WITH
OWNER = postgres
ENCODING = 'UTF8'
CONNECTION LIMIT = -1;

-- Grant privileges to a specific user
GRANT ALL PRIVILEGES ON DATABASE university_db TO Gev;
