
create type isofficial as enum ('T','F');

CREATE TABLE IF NOT EXISTS countrylanguage (
  CountryCode char(3) NOT NULL DEFAULT '',
  Language char(30) NOT NULL DEFAULT '',
  IsOfficial isofficial NOT NULL DEFAULT 'F',
  Percentage NUMERIC(4,1) NOT NULL DEFAULT '0.0'
  );