El siguiete proyecto cuenta con ejemplos de relaciones para entidades de un gimnasio las cuales son:

--Socio: el cliente del gimnasio
--Tarjeta: medio de acceso para el gimnasio
--Clase: tipo de entrenamiento
--Instructor: persona que imparte la clase

Relaciones

@OneToOne: Un Socio solo puede tener una Tarjeta y viceversa
@OneToMany: un Instructor puede impartir varias Clases
@ManyToOne: muchas Clases pueden ser impartidas por un Instructor
@ManyToMany: muchos Socios puden asistir a muchas Clases
