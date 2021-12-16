# Run Tracker API

El Run Tracker API te permite crear y editar una rutina de entrenamiento para corredores que incluye plan alimenticio, rutina de entrenamiento, registro de tiempos corridos.

Tiene que incluir una autenticación y autorización utilizando el proceso estándar de creación de JWT y protección de contraseña.

- Un usuario puede crear una cuenta con email y contraseña. La contraseña debe de ser `hashed` antes de ser guardada en la base de datos.
- Resetear la contraseña.

Al tener un JWT el usuario puede crear una nueva rutina e ir agregando la información necesaria para completar el plan de entrenamiento.

Las 3 partes:

- Rutina
    - Definir cuantos kilometros debe de correr la persona y el día que debe correr.
- Nutrición
    - Calorías y macronutrientes por semana.
- Registro de tiempos
    - Poder guardar las corridas y la duración de este.
    - kilométro promedio, kilométro más rápido, kilométro más lento.

## Objetivos

- Sistema de Autenticación y Autorización
    - Crear usuarios usando email y contraseña.
    - Guardar contraseña encriptada a base de datos.
    - Poder cambiar contraseña.
    - Regresar información de usuario como JWT.
- Crear una API REST utilizando Spring
    - Rutas de Plan de Entrenamiento
    - Rutas de Nutrición
    - Rutas de Registro de Corridas
- Conectarse a una base de datos local de SQL
    - Utilizar PostgreSQL dado que es Open Source.
