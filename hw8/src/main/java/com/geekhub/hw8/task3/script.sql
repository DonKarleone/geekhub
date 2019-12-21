--1--
SELECT countries.*,
       COUNT(*) AS total_states
FROM countries
       JOIN states ON countries.id = states.country_id
GROUP BY countries.id
ORDER BY total_states DESC
LIMIT 1;

--2--
SELECT countries.*,
       COUNT(*) AS total_cities
FROM countries
       JOIN states ON countries.id = states.country_id
       JOIN cities ON states.id = cities.state_id
GROUP BY countries.id
ORDER BY total_cities DESC
LIMIT 1;

--3--
SELECT countries.*,
       COUNT(*) AS total_states
FROM countries
       JOIN states ON countries.id = states.country_id
GROUP BY countries.id
ORDER BY total_states DESC,
         countries.name,
         countries.id;

--4--
SELECT countries.*,
       COUNT(*) AS total_cities
FROM countries
       JOIN states ON countries.id = states.country_id
       JOIN cities ON states.id = cities.state_id
GROUP BY countries.id
ORDER BY total_cities DESC,
         countries.name,
         countries.id;

--5--
SELECT countries.*,
       COUNT(DISTINCT states.id) AS total_states,
       COUNT(DISTINCT cities.id) AS total_cities
FROM countries
       JOIN states ON countries.id = states.country_id
       JOIN cities ON states.id = cities.state_id
GROUP BY countries.id;

--6--
SELECT *
FROM (SELECT DISTINCT ON (countries.id) countries.*,
                         COUNT(*) AS total_cities
      FROM countries
             JOIN states ON countries.id = states.country_id
             JOIN cities ON states.id = cities.state_id
      GROUP BY countries.id, states.id
      ORDER BY countries.id, total_cities DESC) AS temp_table
ORDER BY total_cities DESC
LIMIT 10;

--7--
(SELECT countries.*,
        COUNT(*) AS total_states
 FROM countries
        JOIN states ON countries.id = states.country_id
 GROUP BY countries.id
 ORDER BY total_states DESC
 LIMIT 10)
UNION
    (SELECT countries.*,
            COUNT(*) AS total_states
     FROM countries
            JOIN states ON countries.id = states.country_id
     GROUP BY countries.id
     ORDER BY total_states ASC
     LIMIT 10)
ORDER BY name;

--8--
SELECT countries.*
FROM countries
       JOIN (SELECT country_id,
                    COUNT(*) AS total_states,
                    AVG(COUNT(*)) OVER () AS average
             FROM states
             GROUP BY states.country_id)
    AS temp_table ON temp_table.country_id = countries.id
WHERE temp_table.total_states > temp_table.average;

--9--
SELECT DISTINCT ON (total_states) countries.*,
                   COUNT(*) AS total_states
FROM countries
       JOIN states ON countries.id = states.country_id
GROUP BY countries.id
ORDER BY total_states, countries.name;

--10--
SELECT *
FROM states
WHERE name IN (SELECT states.name
               FROM states
               GROUP BY states.name
               HAVING COUNT(*) > 1);

--11--
SELECT states.*
FROM states
       LEFT OUTER JOIN cities ON states.id = cities.state_id
WHERE cities.id IS NULL