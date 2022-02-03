import pickle

## Objetos
from gestorAplicacion.obras.Estanteria import Estanteria
from gestorAplicacion.obras.Folleto import Folleto
from gestorAplicacion.obras.Libro import Libro
from gestorAplicacion.obras.Publicacion import Publicacion
from gestorAplicacion.obras.Revista import Revista
from gestorAplicacion.personas.Autor import Autor
from gestorAplicacion.personas.EstudianteProfesor import EstudianteProfesor
from gestorAplicacion.personas.Externo import Externo
from gestorAplicacion.personas.Usuario import Usuario
from gestorAplicacion.prestamo.Prestamo import Prestamo
##


def serializar():
    serializarEstanterias()
    serializarAutores()
    serializarPublicaciones()
    serializarLibros()
    serializarRevistas()
    serializarFolletos()
    serializarUsuariosI()
    serializarUsuariosE()
    serializarPrestamos()

def deserializar():
    deserializarEstanterias()
    deserializarAutores()
    deserializarPublicaciones()
    deserializarLibros()
    deserializarRevistas()
    deserializarFolletos()
    deserializarUsuariosI()
    deserializarUsuariosE()
    deserializarPrestamos()
    


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

def serializarUsuariosI():
    w = open('baseDatos/usuariosI','wb')
    pickle.dump(EstudianteProfesor.l,w)
    w.close()

def serializarUsuariosE():
    w = open('baseDatos/usuariosE','wb')
    pickle.dump(Externo.l,w)
    w.close()

def serializarPrestamos():
    w = open('baseDatos/prestamos','wb')
    pickle.dump(Prestamo.getLista(),w)
    w.close()




def deserializarEstanterias():
    r = open('baseDatos/estanterias','rb')
    Estanteria.setLista(pickle.load(r))
    Estanteria._numeroEstanterias =len (Estanteria.getLista())
    r.close()

def deserializarAutores():
    r = open('baseDatos/autores','rb')
    Autor.setAutores(pickle.load(r))
    Autor._numeroAutores =len(Autor.getAutores())
    r.close()

def deserializarPublicaciones():
    r = open('baseDatos/publicaciones','rb')
    Publicacion.setLista(pickle.load(r))
    r.close()

def deserializarLibros():
    r = open('baseDatos/libros','rb')
    Libro.setLibro(pickle.load(r))
    Libro._numeroLibro = len(Libro.getLibro())
    r.close()

def deserializarRevistas():
    r = open('baseDatos/revistas','rb')
    Revista.setRevista(pickle.load(r))
    r.close()

def deserializarFolletos():
    r = open('baseDatos/folletos','rb')
    Folleto.setFolleto(pickle.load(r))
    r.close()

def deserializarUsuariosI():
    r = open('baseDatos/usuariosI','rb')
    EstudianteProfesor.l = pickle.load(r)
    r.close()

def deserializarUsuariosE():
    r = open('baseDatos/usuariosE','rb')
    Externo.l = pickle.load(r)
    r.close()

def deserializarPrestamos():
    r = open('baseDatos/prestamos','rb')
    Prestamo.setLista(pickle.load(r))
    r.close()