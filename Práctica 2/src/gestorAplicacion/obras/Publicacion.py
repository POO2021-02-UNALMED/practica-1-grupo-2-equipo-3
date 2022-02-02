from enum import Enum
from abc import ABC, abstractmethod

from gestorAplicacion.obras.Estanteria import Estanteria

#CLASE ABSTRACTA
class Estado(Enum):
    circulacion = "CIRCULACION"
    prestado = "PRESTADO"

class Publicacion(ABC) : 

    #Atributos de clase
    _lista = []
    numeroPublicaciones = 0

    #Constructor
    def __init__(self, codigo=0,nombre="...",año=0,ejemplar=0,estado=Estado.circulacion) :
        self.codigo = codigo
        self.nombre = nombre
        self.año= año
        self.ejemplar = ejemplar
        self.estado = estado
        self.estanteria=None
        self.prestamo=None
        Publicacion.numeroPublicaciones+=1
        Publicacion._lista.append(self)

    #Metodos
    def asignarEstanteria(self,numEstanteria):
        for x in Estanteria.getLista():
            if x.getNumero() == numEstanteria:
                self.setEstanteria(x)
                x.getPublicaciones().append(self)
                break

    def mostrarInfo(self):
        return f'INFORMACION DE LA PUBLICACION: \n Codigo: {self.getCodigo()} \n Nombre: {self.getNombre()} \n Ejemplar: {self.getEjemplar()}'

    @classmethod
    def eliminarPublicacion(cls,p):
        Publicacion._lista.remove(p)
        del p

    @classmethod
    def buscarPublicacion(cls, Codigop):
        for x in Publicacion.getLista:
            if x.getCodigo() == Codigop:
                publicacion = x
                break
        return publicacion

    @classmethod
    def mostrarRegistros(cls):
        from gestorAplicacion.obras.Libro import Libro
        from gestorAplicacion.obras.Revista import Revista
        from gestorAplicacion.obras.Folleto import Folleto
        c = "PUBLICACIONES CREADAS   "+ "\n"
        for i,x in enumerate(Publicacion._lista) :
            if isinstance(x,Libro):
                c=c + str(i) + f'. Libro {x.getNombre()} Codigo(CP) {x.getCodigo()} \n'
            elif isinstance(x,Revista):
                c=c + str(i) + f'. Revista {x.getNombre()} Codigo(CP) {x.getCodigo()} \n'
            elif isinstance(x,Folleto):
                c=c + str(i) + f'. Folleto {x.getNombre()} Codigo(CP) {x.getCodigo()} \n'
        return c
    
    def verificarPrestado(self):
        if self.getEstado() == Estado.prestado:
            b=True
        else :
            b=False
        return b

    @abstractmethod
    def mostrarUbicacion(self):
        pass
    
    
    @classmethod
    def getLista(cls):
        return Publicacion._lista
    @classmethod
    def setLista(cls,lista):
        Publicacion._lista = lista

    @classmethod
    def getNumeroPublicaciones(cls):
        return Publicacion.numeroPublicaciones

    def getCodigo(self):
        return self.codigo
    def setCodigo(self,a):
        self.codigo = a

    def getNombre(self):
        return self.nombre
    def setNombre(self,a):
        self.nombre = a

    def getAño(self):
        return self.año 
    def setAño(self,a):
        self.año= a

    def getEjemplar(self):
        return self.ejemplar
    def setEjemplar(self,a):
        self.ejemplar=a

    def getEstado(self):
        return self.estado
    def setEstado(self,a):
        self.estado = a

    def getEstanteria(self):
        return self.estanteria
    def setEstanteria(self, a):
        self.estanteria = a

    def getPrestamo(self):
        return self.prestamo
    def setPrestamo(self,p):
        self.prestamo = p

