
from enum import Enum
from gestorAplicacion.obras.Publicacion import Publicacion
from gestorAplicacion.personas.Autor import Autor
from gestorAplicacion.obras.Estanteria import Estanteria

class tipoLibro(Enum):
    cg = 'COLECCION_GENERAL'
    r = 'RESERVA'
    i = 'INVESTIGACION'
    s = 'SEMINARIO'
    t = 'TESIS'

class Libro(Publicacion): 
    # serialversion ?

    #Atributos de clase
    _libro = []
    _numeroLibro = len(_libro)
    

    #Constructor
    def __init__(self, codigo,nombre,año,ejemplar,autor=None,tipolibro='...',referencia='...',volumen=0,estanteria=None,prestamo=None) :
        Libro._libro.append(self)
        super().__init__(codigo,nombre,año,ejemplar)
        self._autor = autor
        self._tipo = tipolibro
        self._referencia = referencia
        self._volumen = volumen
        self.estanteria = estanteria
        self.prestamo = prestamo
        
        if estanteria is not None:
            self.estanteria.getPublicaciones.append(self)


    #Metodos
    

    def asignarAutor(self,idAutor):

        for x in Autor.getLista():
            if x.getId() == idAutor:
                self.setAutor(x)
                x.getLibros().append(self)
                break

    def mostrarInfo(self):
        return  f'INFORMACION DEL LIBRO: \n Nombre: {self.getNombre()} \n Autor: {self.getAutor()} \n Año: {self.getAño()} \n Tipo: {self.getTipo()} \n Vol: {self.getVol()} \n Codigo: {self.getCodigo()} \n Ejemplar: {self.getEjemplar()} \n Estado: {self.getEstado()} \n Referencia: {self.getReferencia()}'
        
    def mostrarUbicacion(self):
        return "Localizado en: " + str(self.estanteria.mostrarInfo())
    

    def getAutor(self):
        return self._autor
    def setAutor(self,a ):
        self._autor =a

    def getTipo(self):
        return self._tipo
    def setTipo(self,a):
        self._tipo = a

    def getVol(self):
        return self._volumen
    def setVol(self,a):
        self._volumen =a

    def getReferencia(self):
        return self._referencia
    def setReferencia(self,a):
        self._referencia = a

    @classmethod
    def getLibro(cls):
        return Libro._libro
    @classmethod
    def setLibro(cls,lista):
        Libro._libro = lista

    
    