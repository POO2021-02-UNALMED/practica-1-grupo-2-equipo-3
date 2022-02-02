import pickle

## Objetos
from gestorAplicacion.obras.Estanteria import Estanteria
from gestorAplicacion.obras.Folleto import Folleto
from gestorAplicacion.obras.Libro import Libro
from gestorAplicacion.obras.Publicacion import Publicacion
from gestorAplicacion.obras.Revista import Revista
from gestorAplicacion.personas.Autor import Autor
from gestorAplicacion.personas.Usuario import Usuario
##

## Funciones
from baseDatos.Almacenamiento import serializar,deserializar,creacion
##



# serializar()

creacion()
deserializar()
serializar() 


# # Estanteria.setLista(pickle.load(r_estanterias))
# r_estanterias.close()