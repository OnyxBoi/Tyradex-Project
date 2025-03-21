CREATE TABLE IF NOT exists `pokemons` (
    `id` BIGINT AUTO_INCREMENT NOT NULL,
    `pokedex_id` INT NOT NULL,
    `generation` INT NOT NULL,
    `category` VARCHAR(255) NOT NULL,
    `name` JSON,
    `sprites` JSON,
    `types` JSON,
    `talents` JSON,
    `stats` JSON,
    `resistances` JSON,
    `evolution` JSON,
    `height` VARCHAR(255),
    `weight` VARCHAR(255),
    `egg_groups` JSON,
    `sexe` JSON,
    `catch_rate` INT NOT NULL,
    `level_100` INT NOT NULL,
    `formes` JSON,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
