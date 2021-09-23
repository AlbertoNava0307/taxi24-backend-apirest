# taxi24-backend-apirest
API REST para la gestión de pasajeros de la plataforma taxi24

Prerrequisitos para correr el proyecto: Tener una base de datos Postgres instalada en el puerto 5432

Para correr el proyecto basta con descargarlo e importarlo en un IDE como un 'Existing Maven Projects'
enseguida comenzará a descargar las dependencias de MAVEN y una vez finalizado este proceso
estará listo para correrse como 'Spring Boot App'

Al iniciar, la aplicación escaneará las clases de entidad y creará las tablas en la BD automáticamente
Después se importarán los registros en las tablas 'conductores' y 'pasajeros' con el archivo '\src\main\resources\import.sql'
Entonces la aplicación estará lista para realizar pruebas

End Points

El servicio estará corriendo en: 'http://localhost:9000/taxi24/'

Ejemplo de solicitud: http://localhost:9000/taxi24/conductores

Conductores
/conductores                            -     Obtiene lista de todos los conductores
/conductores-disponibles                -     Obtiene lista de todos los disponibles
/conductores-disponibles-location       -     Obtiene lista de todos los conductores disponibles en un rango de 3km
/conductores/{id}                       -     Obtiene un conductor especifico por ID

Pasajeros
/pasajeros"                             -     Obtiene una lista de todos los pasajeros
/pasajeros/{id}                         -     Obtiene un pasajero especifico por ID
/conductores-cercanos                   -     Obtiene una lista de los 3 conductores más cercanos al punto de partida

Viajes
/viajes                                 -     Obtiene una lista de todos los viajes activos
/viajes                                 -     Crea una neva solicitud de "Viaje" asignando un conductor al viaje
