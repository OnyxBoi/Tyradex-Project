create table IF NOT exists roles(
    id INT not null auto_increment,
    name varchar(255),
primary key (id)) engine=InnoDB;

create table IF NOT exists users (
    id INT not null auto_increment,
    username varchar(100),
    password VARCHAR(100) NOT NULL,
    enabled boolean,
primary key (id)) engine=InnoDB;

# On Utilise toujours des liste de roles, pour permettre l'ajout de nouveaux roles a un utilisateur
CREATE TABLE IF NOT exists users_roles (
    users_id INT,
    roles_id INT,
    FOREIGN KEY (users_id) REFERENCES users(id),
    FOREIGN KEY (roles_id) REFERENCES roles(id),
    PRIMARY KEY (users_id, roles_id)
);

# Le nom des roles doit commencer par ROLE_ en spring security
INSERT INTO roles (name) VALUES
('ROLE_ADMIN'),
('ROLE_USER'),
('ROLE_TESTER'),
('ROLE_CRUD'),
('ROLE_BOUNCER'),
('ROLE_SCRAPPER')
;