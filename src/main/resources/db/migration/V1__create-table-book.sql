CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    nota_media DOUBLE PRECISION NOT NULL,
    numero_avaliacoes INT NOT NULL,
    numero_resenhas INT NOT NULL,
    isbn VARCHAR(20) UNIQUE NOT NULL,
    isbn13 VARCHAR(20) UNIQUE NOT NULL,
    idioma VARCHAR(50) NOT NULL,
    numero_paginas INT NOT NULL
);
