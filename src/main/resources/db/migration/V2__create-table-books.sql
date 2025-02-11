CREATE TABLE books (
    bookID BIGINT PRIMARY KEY,              -- bookID (long)
    title VARCHAR(255),                     -- title (string)
    authors TEXT,                           -- authors (string)
    average_rating DOUBLE PRECISION,        -- average_rating (double)
    isbn VARCHAR(20),                       -- isbn (string)
    isbn13 VARCHAR(20),                     -- isbn13 (string)
    language_code VARCHAR(10),              -- language_code (string)
    num_pages INTEGER,                      -- num_pages (integer)
    ratings_count INTEGER,                  -- ratings_count (integer)
    text_reviews_count INTEGER,             -- text_reviews_count (integer)
    publication_date DATE,                  -- publication_date (string)
    publisher VARCHAR(255)                  -- publisher (string)
);
