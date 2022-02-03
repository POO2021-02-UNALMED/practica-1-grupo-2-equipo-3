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
    w = open('baseDatos/estanterias','wb')
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
    w = open('baseDatos/estanterias','wb')
    pickle.dump(Estanteria.getLista(),w)
    w.close()

def serializarAutores():
    w = open('baseDatos/autores','wb')
    pickle.dump(Autor.getAutores(),w)
    w.close()

def serializarPublicaciones():
    w = open('baseDatos/publicaciones','wb')
    pickle.dump(Publicacion.getLista(),w)
    w.close()

def serializarLibros():
    w = open('baseDatos/libros','wb')
    pickle.dump(Libro.getLibro(),w)
    w.close()

def serializarFolletos():
    w = open('baseDatos/folletos','wb')
    pickle.dump(Folleto.getFolleto(),w)
    w.close()

def serializarRevistas():
    w = open('baseDatos/revistas','wb')
    pickle.dump(Revista.getRevista(),w)
    w.close()

def serializarUsuarios():
    w = open('baseDatos/usuarios','wb')
    pickle.dump(Usuario.getUsuarios(),w)
    w.close()




def deserializarEstanterias():
    r = open('baseDatos/estanterias','rb')
    Estanteria.setLista(pickle.load(r))
    r.close()

def deserializarAutores():
    r = open('baseDatos/autores','rb')
    Autor.setAutores(pickle.load(r))
    r.close()

def deserializarPublicaciones():
    r = open('baseDatos/publicaciones','rb')
    Publicacion.setLista(pickle.load(r))
    r.close()

def deserializarLibros():
    r = open('baseDatos/libros','rb')
    Libro.setLibro(pickle.load(r))
    r.close()

def deserializarRevistas():
    r = open('baseDatos/revistas','rb')
    Revista.setRevista(pickle.load(r))
    r.close()

def deserializarFolletos():
    r = open('baseDatos/folletos','rb')
    Folleto.setFolleto(pickle.load(r))
    r.close()

def deserializarUsuarios():
    r = open('baseDatos/usuarios','rb')
    Usuario.setUsuarios(pickle.load(r))
    r.close()