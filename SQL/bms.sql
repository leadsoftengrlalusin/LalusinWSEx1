-- Create the bms database
CREATE DATABASE bms;

-- Connect to the bms database
\c bms;

-- Create tables
CREATE TABLE sailor (
    id SERIAL PRIMARY KEY,
    sid INTEGER NOT NULL,
    name TEXT NOT NULL,
    rating INTEGER,
    age INTEGER
);

CREATE TABLE bid (
    id SERIAL PRIMARY KEY,
    bid INTEGER NOT NULL,
    name TEXT NOT NULL,
    color TEXT
);

CREATE TABLE reserve (
    id SERIAL PRIMARY KEY,
    sid INTEGER NOT NULL,
    bid INTEGER NOT NULL,
    date DATE
);

-- Insert into sailor
INSERT INTO sailor (sid, name, rating, age) VALUES
(22, 'Dustin', 7, 45),
(29, 'Brutus', 1, 33),
(31, 'Lubber', 79, 55),
(32, 'Andy', 25, 25),
(58, 'Rusty', 10, 35),
(58, 'Buplb', 10, 35),
(58, 'Buplerb', 10, 35),
(22, 'Albert', 10, 35);

-- Insert into bid
INSERT INTO bid (bid, name, color) VALUES
(101, 'Interlake', 'blue'),
(102, 'Interlake', 'red'),
(103, 'Clipper', 'green'),
(104, 'Marine', 'red');

-- Insert into reserve
INSERT INTO reserve (sid, bid, date) VALUES
(22, 101, '2004-01-01'),
(22, 102, '2004-01-01'),
(22, 103, '2004-01-02'),
(22, 105, '2004-01-02'),
(31, 103, '2005-05-05'),
(32, 104, '2005-04-07');
