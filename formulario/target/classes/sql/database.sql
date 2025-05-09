CREATE DATABASE escuela;
USE escuela;
CREATE TABLE estudiantes (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(50),
pellido VARCHAR(50),
correo VARCHAR(100),
estado TINYINT(1) DEFAULT 1
);
INSERT INTO estudiantes (nombre, pellido, correo, estado)
VALUES ('Juan', 'Pérez', 'juan.perez@example.com', 1);
UPDATE estudiantes
SET nombre = 'Carlos', pellido = 'Gómez', correo = 'carlos.gomez@example.com'
WHERE id = 1;
UPDATE estudiantes
SET estado = 0
WHERE id = 1;
SELECT * FROM estudiantes WHERE estado = 1;
SELECT * FROM estudiantes WHERE estado = 0;
