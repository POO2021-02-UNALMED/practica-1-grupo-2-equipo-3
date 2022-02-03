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
from baseDatos.Almacenamiento import serializar,deserializar,creacion
##



# serializar()

# print(len(Usuario.getUsuarios()))

nombre= "fg"
id = "g"
correo = "g"
tel = "g"
dir = "g"
nac= "g"
pais= "g"
rol= "g"
uni = "hg"

obj = Externo(nombre,id,correo,tel,dir,nac,pais,rol,uni)
Externo()


# # Estanteria.setLista(pickle.load(r_estanterias))
# r_estanterias.close()