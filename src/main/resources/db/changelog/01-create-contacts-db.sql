CREATE TABLE contacts (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    birth_year INTEGER,
    first_phone_number VARCHAR(255) UNIQUE,
    second_phone_number VARCHAR(255) UNIQUE,
    created_at TIMESTAMPTZ
);