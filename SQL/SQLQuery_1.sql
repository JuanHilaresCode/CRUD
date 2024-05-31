CREATE DATABASE MovilSur;

CREATE TABLE rutas(
id INT NOT NULL IDENTITY(1,1),
origen varchar(200) NOT NULL,
destino varchar(200) NOT NULL,
distancia varchar(200) NOT NULL,
duracion varchar(200) NOT NULL,
descripcion VARCHAR(200) NOT NULL,
estado int NOT NULL DEFAULT 1,
CONSTRAINT pk_rutas PRIMARY KEY(id),
);


INSERT INTO rutas (origen, destino, distancia, duracion, descripcion, estado)
VALUES 
('Cañete', 'Piura', '500', '8', 'Viaje costero por el norte del país', 1),
('Piura', 'Lima', '950', '12', 'Viaje desde el norte hasta la capital', 1),
('Lunahuana', 'San Luis', '80', '2', 'Recorrido corto por valle de Lunahuana', 1),
('San Luis', 'Lima', '90', '2.5', 'Viaje corto desde el sur hasta la capital', 1),
('Lima', 'Cañete', '150', '2', 'Viaje desde la capital hasta la costa sur', 1);



DROP TABLE rutas;

select * from rutas;
