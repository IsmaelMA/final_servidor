ALTER TABLE `vehiculos` DROP FOREIGN KEY `FK_id_cliente`;

ALTER TABLE `vehiculos`
ADD
    CONSTRAINT `FK_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE;