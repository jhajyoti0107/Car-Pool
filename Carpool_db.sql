
CREATE DATABASE carpool_db;
USE carpool_db;


CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50)
);


CREATE TABLE rides (
    ride_id INT AUTO_INCREMENT PRIMARY KEY,
    source VARCHAR(50),
    destination VARCHAR(50),
    seats INT,
    fare DOUBLE
);

CREATE TABLE bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    ride_id INT,
    seats_booked INT,
    total_fare DOUBLE,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (ride_id) REFERENCES rides(ride_id)
);
