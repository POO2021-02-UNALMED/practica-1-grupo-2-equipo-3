import datetime
from obras.Libro import Libro, tipoLibro
from personas.Persona import Persona

from obras.Publicacion import Publicacion
from obras.Revista import Revista
from obras.Folleto import Folleto


class Prestamo:

    #Atributo clase
    _lista=[]
    _fechaActual= datetime.datetime.now()

    #constructor
    def __init__(self, id=0,inicio='...', publicacion=None,usuario=None):
        self.id = id
        self.inicio = inicio
        self.fin = None
        self.publicacion = publicacion
        self.usuario = usuario
        Prestamo._lista.append(self)
        

    #metodos

    def asignacion(self,codigop,usuarioId):

        for x in Publicacion._lista:
            if x.getCodigo() == codigop:
                self.setPublicacion(x)
                break
        
        for x in Persona._lista:
            if x.getId() == usuarioId:
                self.setUsuario(x)
                break
    

    def determinarFinInterno(self): 
        if isinstance(self.publicacion,Libro):
            if self.publicacion.getTipo() == tipoLibro.r:
                self.fin = self.inicio + datetime.timedelta(days=1)
                self.fin = self.fin.replace(hour=12)
            elif self.publicacion.getTipo() == tipoLibro.cg:
                self.fin = self.inicio + datetime.timedelta(days=30)
                self.fin = self.fin.replace(hour=12)
            else:
                return "Los libros de Tesis y/o Investigacion no estan disponibles para prestamo"

        elif isinstance( self.publicacion ,Revista):
            self.fin = self.inicio + datetime.timedelta(days=15)
            self.fin = self.fin.replace(hour=12)
        
        elif isinstance(self.publicacion,Folleto):
            return "Los Folletos no estan disponibles para prestamo"

    
    def determinarFinExterno(self): 
        if isinstance(self.publicacion,Libro):
            if self.publicacion.getTipo() == tipoLibro.r:
                return "Los usuarios externos de la universidad no pueden prestar libros de reserva"
            elif self.publicacion.getTipo() == tipoLibro.cg:
                self.fin = self.inicio + datetime.timedelta(days=15)
                self.fin = self.fin.replace(hour=12)
            else:
                return "Los libros de Tesis y/o Investigacion no estan disponibles para prestamo"

        elif isinstance( self.publicacion ,Revista):
            self.fin = self.inicio + datetime.timedelta(days=7)
            self.fin = self.fin.replace(hour=12)
        
        elif isinstance(self.publicacion,Folleto):
            return "Los Folletos no estan disponibles para prestamo"

    def mostrarInfo(self):
        return f'DETALLE DEL PRESTAMO: \n Material prestado: {self.publicacion.getNombre()} CP: {self.publicacion.getCodigo()} \n Usuario: {self.usuario.getNombre()} CC: {self.usuario.getId()} \n Fecha inicio: {self.inicio} \n Fecha vencimiento: {self.fin}'



    @classmethod
    def getLista(cls):
        return Prestamo._lista

    @classmethod
    def getFechaActual(cls):
        return Prestamo._fechaActual

    def getId(self):
        return self.id
    def setId(self,i):
        self.id = i

    def getInicio(self):
        return self.inicio
    def setInicio(self,i):
        self.inicio =i

    def getFin(self):
        return self.fin
    def setFin(self,f):
        self.fin = f

    def getUsuario(self):
        return self.usuario
    def setUsuario(self,p):
        self.usuario = p

    def getPublicacion(self):
        return self.publicacion
    def setPublicacion(self,p):
        self.publicacion = p