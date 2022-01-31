
from enum import Enum
from Publicacion import Publicacion

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
    

    #Constructor
    def __init__(self, codigo,nombre,año,ejemplar,autor='...',tipolibro='...',referencia='...',volumen=0,estanteria=None,prestamo=None) :
        super().__init__(codigo,nombre,año,ejemplar)
        self._autor = autor
        self._tipo = tipolibro
        self._referencia = referencia
        self._volumen = volumen
        self.estanteria = estanteria
        self.prestamo = prestamo
        Libro._libro.append(self)
        Publicacion.numeroPublicaciones+=1
        if estanteria is not None:
            self.estanteria.getPublicaciones.append(self)


    #Metodos
    def mostrarInfo(self):
        return  f'INFORMACION DEL LIBRO: \n Nombre: {self.getNombre()} \n Autor: {self.getAutor()} \n Año: {self.getAño()} \n Tipo: {self.getTipo} \n Vol: {self.getVol} \n Codigo: {self.getCodigo} \n Ejemplar: {self.getEjemplar} \n Estado: {self.getEstado} \n Referencia: {self.getReferencia}'
        
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
    