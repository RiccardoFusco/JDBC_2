CREATE TABLE prodotti (
    id bigint auto_increment primary key,
    nome varchar(100),
    descrizione varchar(1000),
    prezzo int check (prezzo > 0)
);



CREATE TABLE varianti (
    id bigint auto_increment primary key,
    attributo varchar(100),
    valore varchar(1000),
    prodotto_id int references prodotti(id)
);



CREATE TABLE fornitori (
    id bigint auto_increment primary key,
    nome varchar(100),
);



CREATE TABLE fornitori_prodotti (
    fornitore_id bigint references fornitori(id),
    prodotto_id bigint references prodotti
);