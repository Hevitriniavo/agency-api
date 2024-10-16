CREATE TABLE Users
(
    id                INT PRIMARY KEY AUTO_INCREMENT,
    name              VARCHAR(100) NOT NULL,
    email             VARCHAR(100) NOT NULL UNIQUE,
    password          VARCHAR(255) NOT NULL,
    role              ENUM('Owner', 'Agent', 'Client') NOT NULL,
    phone             VARCHAR(15),
    address           VARCHAR(255),
    city              VARCHAR(100),
    postal_code       VARCHAR(10),
    registration_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Properties
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    title         VARCHAR(255)   NOT NULL,
    description   TEXT           NOT NULL,
    price         DECIMAL(10, 2) NOT NULL,
    area          INT            NOT NULL,
    type          VARCHAR(50)    NOT NULL,
    address       VARCHAR(255),
    city          VARCHAR(100),
    postal_code   VARCHAR(10),
    creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    user_id       INT,
    images        JSON,
    availability  BOOLEAN  DEFAULT TRUE,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE
);
