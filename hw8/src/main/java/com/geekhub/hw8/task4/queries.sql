--1-- Count the number of tickets sold for December 2019
SELECT count(*) from tickets WHERE DATE BETWEEN '01/12/2019' and '31/12/2019'

--2--Count the number of trains in which Cherkasy station is present
SELECT * from trains WHERE start_station_id = 3 or finish_station_id = 3

--3--Select the 5 stations from which most trains depart
SELECT stations.station_name, COUNT(*) total_trains
FROM stations
       JOIN trains ON stations.id = trains.start_station_id
GROUP BY stations.id
ORDER BY total_trains DESC
LIMIT 5;

--4-- Select trains for the 4th quarter of 2019, how many tickets they have sold for what amount, sort by reduction
SELECT trains.id, temp_table.total_tickets, trains.ticket_price * temp_table.total_tickets AS sum_of_tickets
FROM trains
       JOIN (SELECT tk.train_id, count(*) AS total_tickets
             FROM tickets tk
             WHERE DATE BETWEEN '01/10/2019' and '31/12/2019'
             GROUP BY tk.train_id) AS temp_table
         ON temp_table.train_id = trains.id
ORDER BY sum_of_tickets DESC

--5-- Choose the names of passengers who bought more than 1 ticket in 2019 and sort by number of tickets
SELECT passangers.first_name, passangers.last_name , temp_table.total_tickets
FROM passangers
       JOIN (SELECT tk.passanger_id, count(*) AS total_tickets
             FROM tickets tk
             WHERE DATE BETWEEN '01/01/2019' and '31/12/2019'
             GROUP BY tk.passanger_id) AS temp_table
         ON temp_table.passanger_id = passangers.id
WHERE total_tickets > 1
ORDER BY total_tickets DESC

--6-- Select all trains with start and finish station names
SELECT temp_table.tid, temp_table.start, stations.station_name as finish
FROM stations
       RIGHT JOIN (SELECT t.id AS tid, s.station_name as start, t.finish_station_id AS fid
                  FROM trains t
                         LEFT JOIN stations s ON t.start_station_id = s.id) AS temp_table
         ON temp_table.fid = stations.id

--7-- Increase by 10% the number of seats on trains where the ticket price is less than 400
UPDATE trains
SET limit_tickets = limit_tickets * 1.1
WHERE ticket_price < 400

--8-- Increase the cost of all trains by 10%
UPDATE trains
SET ticket_price = ticket_price * 1.1

--9-- Change the last letters of station names 'ov' to 'iv'
UPDATE stations
SET station_name = REPLACE(station_name,'ov','iv')

--10-- Delete all tickets with a date more than a year from the current date
DELETE FROM tickets WHERE date < CURRENT_DATE - 365

--11-- Delete all trains for which no tickets have been sold
DELETE FROM trains
WHERE trains.id NOT IN (
    SELECT tickets.train_id FROM tickets)