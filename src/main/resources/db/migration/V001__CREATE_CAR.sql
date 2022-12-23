CREATE TABLE IF NOT EXISTS car {
    id UUID NOT NULL PRIMARY KEY,
    brand varchar(100) NOT NULL,
    model varchar(100) NOT NULL,
    available BOOLEAN NOT NULL
};