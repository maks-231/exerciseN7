
set profiling=1
show  profiles;

-- the most populated city in the country.
-- 1 --
CREATE INDEX code_idx ON country (Code);
CREATE INDEX country_code_idx ON city (CountryCode);

select c.name as Country, ct.Name as City, ct.Population as Population from country c
join city ct on ct.CountryCode = c.Code
join (
	select ct1.CountryCode as CountryCode, max(ct1.Population) as maxPopulation from city ct1
	group by ct1.CountryCode
) ct2 on ct2.CountryCode = ct.CountryCode and ct.Population = ct2.maxPopulation Order by ct.Population desc

-- 2 --
ALTER TABLE country ADD `id` INT NOT NULL AUTO_INCREMENT UNIQUE FIRST;
ALTER TABLE city  ADD `CountryId` INT;

UPDATE city cc SET cc.CountryId = (select c.id id from country c
							 	        where cc.CountryCode = c.Code group by cc.CountryCode, c.id);

CREATE INDEX id_idx ON country (id);
CREATE INDEX id_idx ON city (id);
CREATE INDEX countryid_idx ON city (CountryId);
CREATE INDEX population_idx ON country (Population);

ALTER table city ADD FOREIGN KEY (CountryId) REFERENCES country (id);

select c.name as Country, ct.Name as City, ct.Population as Population from country c
join city ct on ct.CountryId = c.id
join (
	select ct1.CountryId as CountryId, max(ct1.Population) as maxPopulation from city ct1
	group by ct1.CountryId
) ct2 on ct2.CountryId = ct.CountryId and ct.Population = ct2.maxPopulation Order by ct.Population desc

-- 3 --
CREATE VIEW max_populated_city AS
select ct.CountryId as CountryId, ct2.CityId as CityId, ct.Population as MaxPopulation from country c
join city ct on ct.CountryId = c.id
join (
	select ct1.CountryId as CountryId, max(ct1.Population) as maxPopulation, ct1.id as CityId from city ct1
	group by ct1.CountryId,ct1.id
) ct2 on ct2.CountryId = ct.CountryId and ct.Population = ct2.maxPopulation Order by ct.Population desc;

    -- 1 --
	select c.name as Country, ct.Name as City, mpc.MaxPopulation as Population from country c
	join city ct on ct.CountryId = c.id
	join max_populated_city mpc on mpc.CityId = ct.ID
	Order by mpc.MaxPopulation desc;

    -- 2 --
	select c.name as Country, ct.Name as City, mpc.MaxPopulation as Population from country c
	join max_populated_city mpc on mpc.CountryId = c.ID
	join city ct on ct.CountryId = mpc.CityId
	Order by mpc.MaxPopulation desc;
------------------------------------------------------------------------------------------------------------------------

-- the most used language in the country.
ALTER TABLE countrylanguage ADD `id` INT NOT NULL AUTO_INCREMENT UNIQUE FIRST;
ALTER TABLE countrylanguage  ADD `CountryId` INT;

UPDATE countrylanguage cc SET cc.CountryId = (select c.id id from country c
                                                    where cc.CountryCode = c.Code group by cc.CountryCode, c.id);

CREATE INDEX id_idx ON countrylanguage (id);
CREATE INDEX countryid_idx ON countrylanguage (CountryId);
CREATE INDEX percentage_idx ON countrylanguage (Percentage);

-- 1 --
select c.Code, c.name as Country, l.Language, ct2.maxPercentage as 'Max Percentage' from country c
join countrylanguage l on l.CountryCode = c.Code
join (
	select ct.CountryCode as CountryCode, max(ct.Percentage) as maxPercentage from countrylanguage ct
	group by ct.CountryCode
) ct2 on ct2.CountryCode = c.Code and ct2.maxPercentage = l.Percentage and l.Percentage > 0

-- 2 --
select c.Code, c.name as Country, l.Language, ct2.maxPercentage as 'Max Percentage' from country c
join countrylanguage l on l.CountryId = c.Id
join (
	select ct.CountryId as CountryId, max(ct.Percentage) as maxPercentage from countrylanguage ct
	group by ct.CountryId
) ct2 on ct2.CountryId = c.Id and ct2.maxPercentage = l.Percentage and l.Percentage > 0
------------------------------------------------------------------------------------------------------------------------

-- the largest region in the country. execution 1ms
CREATE INDEX surfaceArea_idx ON country (SurfaceArea);

select ct.name, ct.Region, c2.maxSurfaceArea from country ct
join(
	select Code, max(SurfaceArea) as maxSurfaceArea from country c1
	group by Code
) c2 on c2.Code = ct.Code;

select ct.name, ct.Region, c2.maxSurfaceArea from country ct
join(
	select id, max(SurfaceArea) as maxSurfaceArea from country c1
	group by id
) c2 on c2.id = ct.id;
------------------------------------------------------------------------------------------------------------------------

-- the countries where the capital is not the most populated city in the country.
CREATE INDEX capital_id_idx ON country (Capital);
-- 1 --
select ct.name as Country, c.Name as City, c.Population as Population from country ct
join city c on c.CountryCode = ct.Code and c.id = ct.Capital
join (
	select ct1.CountryCode as CountryCode, max(ct1.Population) as maxPopulation from city ct1
	group by ct1.CountryCode
) c2 on c2.CountryCode = ct.Code and c.Population < c2.maxPopulation

-- 2 --
select ct.name as Country, c.Name as City, c.Population as Population from country ct
join city c on c.CountryId = ct.id and c.id = ct.Capital
join (
	select ct1.CountryId as CountryId, max(ct1.Population) as maxPopulation from city ct1
	group by ct1.CountryId
) c2 on c2.CountryId = ct.id and c.Population < c2.maxPopulation
------------------------------------------------------------------------------------------------------------------------

-- the biggest countries with a certain type of governing
select ct.name as Country, ct.Population as Population, c1.GovernmentForm from country ct
join (
	select ct1.GovernmentForm, max(ct1.Population) as maxPopulation from country ct1
	group by ct1.GovernmentForm
) c1 on c1.maxPopulation = ct.Population and c1.maxPopulation > 0;
------------------------------------------------------------------------------------------------------------------------

select * from country
select * from countrylanguage
select * from city

