CREATE TABLE IF NOT EXISTS pages
(
    slug         VARCHAR(254) PRIMARY KEY,
    title        VARCHAR(200)  NOT NULL,
    description  VARCHAR(500),
    menu_label   VARCHAR(100)  NOT NULL,
    h1           VARCHAR(254)  NOT NULL,
    content      VARCHAR(2000) NOT NULL,
    published_at timestamp,
    priority     INT
);