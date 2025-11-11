-- Скрипт инициализации базы данных для туристического агентства
-- Контрольная работа - Вариант 5

-- Создание базы данных
CREATE DATABASE IF NOT EXISTS travel_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE travel_db;

-- Удаление таблицы если существует
DROP TABLE IF EXISTS tourists;

-- Создание таблицы туристов/клиентов
CREATE TABLE tourists (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(20),
    destination VARCHAR(100) NOT NULL,
    duration_days INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Добавление тестовых данных
INSERT INTO tourists (first_name, last_name, email, phone_number, destination, duration_days, price) VALUES
    ('Иван', 'Петров', 'ivan.petrov@mail.ru', '+375291234567', 'Париж', 7, 1500.00),
    ('Мария', 'Сидорова', 'maria.sidorova@gmail.com', '+375291234568', 'Рим', 5, 1200.00),
    ('Алексей', 'Козлов', 'alexey.kozlov@mail.ru', '+375291234569', 'Барселона', 10, 2000.00),
    ('Елена', 'Смирнова', 'elena.smirnova@gmail.com', '+375291234570', 'Прага', 4, 800.00),
    ('Дмитрий', 'Иванов', 'dmitry.ivanov@mail.ru', '+375291234571', 'Лондон', 6, 1800.00);

-- Проверка данных
SELECT * FROM tourists;
