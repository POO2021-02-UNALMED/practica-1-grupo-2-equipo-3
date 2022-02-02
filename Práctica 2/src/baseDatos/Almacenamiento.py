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


def creacion():
    w = open('src/baseDatos/estanterias','wb')
    w.close()

def serializar():
    serializarEstanterias()
    serializarAutores()
    serializarPublicaciones()
    serializarLibros()
    serializarRevistas()
    serializarFolletos()
    serializarUsuarios()

def deserializar():
    deserializarEstanterias()
    deserializarAutores()
    deserializarPublicaciones()
    deserializarLibros()
    deserializarRevistas()
    deserializarFolletos()
    deserializarUsuarios()
    


def serializarEstanterias():
    w = open('src/baseDatos/estanterias','wb')
    pickle.dump(Estanteria.getLista(),w)
    w.close()

def serializarAutores():
    w = open('src/baseDatos/autores','wb')
    pickle.dump(Autor.getAutores(),w)
    w.close()

def serializarPublicaciones():
    w = open('src/baseDatos/publicaciones','wb')
    pickle.dump(Publicacion.getLista(),w)
    w.close()

def serializarLibros():
    w = open('src/baseDatos/libros','wb')
    pickle.dump(Libro.getLibro(),w)
    w.close()

def serializarFolletos():
    w = open('src/baseDatos/folletos','wb')
    pickle.dump(Folleto.getFolleto(),w)
    w.close()

def serializarRevistas():
    w = open('src/baseDatos/revistas','wb')
    pickle.dump(Revista.getRevista(),w)
    w.close()

def serializarUsuarios():
    w = open('src/baseDatos/usuarios','wb')
    pickle.dump(Usuario.getUsuarios(),w)
    w.close()




def deserializarEstanterias():
    r = open('src/baseDatos/estanterias','rb')
    Estanteria.setLista(pickle.load(r))
    # print(Estanteria.getLista())
    r.close()

def deserializarAutores():
    r = open('src/baseDatos/autores','rb')
    Autor.setAutores(pickle.load(r))
    r.close()

def deserializarPublicaciones():
    r = open('src/baseDatos/publicaciones','rb')
    Publicacion.setLista(pickle.load(r))
    r.close()

def deserializarLibros():
    r = open('src/baseDatos/libros','rb')
    Libro.setLibro(pickle.load(r))
    r.close()

def deserializarRevistas():
    r = open('src/baseDatos/revistas','rb')
    Revista.setRevista(pickle.load(r))
    r.close()

def deserializarFolletos():
    r = open('src/baseDatos/folletos','rb')
    Folleto.setFolleto(pickle.load(r))
    r.close()

def deserializarUsuarios():
    r = open('src/baseDatos/usuarios','rb')
    Usuario.setUsuarios(pickle.load(r))
    r.close()