# Concesionario/Taller - API REST

Este repositorio alberga el proyecto final del curso "Master Java" centrado en un concesionario/taller. El sistema integra dos entidades principales, `Cliente` y `Vehículo`, las cuales se interconectan en una relación de uno a muchos. La aplicación utiliza una base de datos MySQL y expone sus funcionalidades a través de una API REST.

## Características Principales

- Conexión a una base de datos MySQL.
- Implementación de operaciones CRUD para gestionar `Cliente` y `Vehículo`.
- Relación uno a muchos entre `Cliente` y `Vehículo`.
- Exposición de endpoints para interactuar con las entidades.

## Inicio Rápido

1. **Clonar el repositorio:**
  
   ```git clone https://github.com/IsmaelMA/final_servidor.git```
   
3. **Acceder al directorio del proyecto**
  ```cd final_servidor```

# Entidades

1. **Cliente**: Representa a una persona o entidad que posee uno o más vehículos.
2. **Vehículo**: Representa a un coche, moto u otro vehículo motorizado, que pertenece a un Cliente específico.

## Endpoints Disponibles

### Clientes

1. **Listar todos los clientes**
   - **URL**: `/cliente`
   - **Método**: `GET`

2. **Buscar cliente por ID**
   - **URL**: `/cliente/{id}`
   - **Método**: `GET`

3. **Buscar clientes por apellido**
   - **URL**: `/cliente/detalle/{apellido}`
   - **Método**: `GET`

4. **Buscar vehículos por ID del cliente**
   - **URL**: `/cliente/{id}/vehiculos`
   - **Método**: `GET`

5. **Eliminar cliente**
   - **URL**: `/cliente/{id}`
   - **Método**: `DELETE`

6. **Crear cliente con objeto**
   - **URL**: `/cliente`
   - **Método**: `POST`

7. **Crear cliente con parámetros en URL**
   - **URL**: `/cliente/{nombre}/{apellido}`
   - **Método**: `POST`

8. **Actualizar cliente**
   - **URL**: `/cliente/{id}/{nombre}/{apellido}`
   - **Método**: `PUT`

### Vehículos

1. **Listar todos los vehículos**
   - **URL**: `/vehiculo`
   - **Método**: `GET`

2. **Buscar vehículo por ID**
   - **URL**: `/vehiculo/{id}`
   - **Método**: `GET`

3. **Buscar propietario del vehículo por ID del vehículo**
   - **URL**: `/vehiculo/propietario/{id}`
   - **Método**: `GET`

4. **Buscar vehículo por matrícula**
   - **URL**: `/vehiculo/detalle/matricula/{matricula}`
   - **Método**: `GET`

5. **Buscar vehículos por fabricante**
   - **URL**: `/vehiculo/detalle/{nombreFabricante}`
   - **Método**: `GET`

6. **Eliminar vehículo**
   - **URL**: `/vehiculo/{id}`
   - **Método**: `DELETE`

7. **Actualizar matrícula del vehículo**
   - **URL**: `/vehiculo/{id}/{matricula}`
   - **Método**: `PUT`

8. **Crear vehículo con objeto y asociar a un cliente**
   - **URL**: `/vehiculo/{id}`
   - **Método**: `POST`

9. **Crear vehículo con parámetros en URL y asociar a un cliente**
   - **URL**: `/vehiculo/{matricula}/{fabricante}/{modelo}/{clienteId}`
   - **Método**: `POST`




 
  


   
