from gestorAplicacion.obras.Publicacion import Publicacion,Estado
# from Publicacion import Estado
from enum import Enum

class Meses:
    jan='ENERO'
    feb='FEBRERO'
    mar='MARZO'
    apr='ABRIL'
    may="MAYO"
    jun="JUNIO"
    jul="JULIO"
    ago="AGOSTO"
    sep="SEPTIEMBRE"
    oct='OCTUBRE'
    nov="NOVIEMBRE"
    dec="DICIEMBRE"

class Revista(Publicacion): 
    # serialversion ?

    #Atributos de clase
    _revista = []
    

    #Constructor
    def __init__(self, codigo,nombre,año,ejemplar,numero=0,mes='...', temporada=0,estanteria=None,prestamo=None) :
        Revista._revista.append(self)
        super().__init__(codigo,nombre,año,ejemplar)
        self._numero = numero
        self._mes=mes
        self._temporada=temporada
        self.estanteria = estanteria
        self.prestamo = prestamo
        
        
        if estanteria is not None:
            self.estanteria.getPublicaciones.append(self)

    #Metodos
    def mostrarInfo(self):
        return  f'INFORMACION DE LA REVISTA: \n Nombre: {self.getNombre()} \n Año: {self.getAño} \n Mes: {self.getMes} \n Temporada: {self.getTemporada} \n Codigo: {self.getCodigo} \n Ejemplar: {self.getEjemplar} \n Estado: {self.getEstado} \n '
        
    def mostrarUbicacion(self):
        return "Localizada en: " + str(self.estanteria.mostrarInfo())
    
    def getNumero(self):
        return self._numero
    def setNumero(self,a):
        self._numero = a

    def getMes(self):
        return self._mes
    def setMes(self,a):
        self._mes = a
    
    def getTemporada(self):
        return self._temporada
    def setTemporada(self,a):
        self._temporada=a

    @classmethod
    def getRevista(cls):
        return Revista._revista
    @classmethod
    def setRevista(cls,lista):
        Revista._revista = lista