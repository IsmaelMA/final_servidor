CREATE TABLE
    `bd_proyecto_final_viernes`.`vehiculos` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `matricula` VARCHAR(45) NOT NULL,
        `fabricante` VARCHAR(45) NULL,
        `modelo` VARCHAR(45) NULL,
        `id_cliente` INT NULL,
        PRIMARY KEY (`id`),
        INDEX `FK_id_cliente_idx` (`id_cliente` ASC) VISIBLE,
        CONSTRAINT `FK_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `bd_proyecto_final_viernes`.`clientes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
    );