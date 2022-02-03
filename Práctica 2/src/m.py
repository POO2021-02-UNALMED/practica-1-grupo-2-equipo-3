import pickle

## Objetos
from gestorAplicacion.obras.Estanteria import Estanteria
from gestorAplicacion.obras.Folleto import Folleto
from gestorAplicacion.obras.Libro import Libro
from gestorAplicacion.obras.Publicacion import Publicacion
from gestorAplicacion.obras.Revista import Revista
from gestorAplicacion.personas.Autor import Autor
from gestorAplicacion.personas.Usuario import Usuario
from gestorAplicacion.personas.Externo import Externo
##

## Funciones
from baseDatos.Almacenamiento import serializar,deserializar
from gestorAplicacion.prestamo.Prestamo import Prestamo
##



# serializar()

# print(len(Usuario.getUsuarios()))

print(Prestamo.mostrarRegistros())


# # Estanteria.setLista(pickle.load(r_estanterias))
# r_estanterias.close()