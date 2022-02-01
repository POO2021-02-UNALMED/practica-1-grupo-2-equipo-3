from Publicacion import Publicacion
from Publicacion import Estado

class Folleto(Publicacion): 
    # serialversion ?

    #Atributos de clase
    _folleto = []
    

    #Constructor
    def __init__(self, codigo,nombre,año,ejemplar,referencia='...',estanteria=None,prestamo=None) :
        super().__init__(codigo,nombre,año,ejemplar)
        self._referencia = referencia
        self.estanteria = estanteria
        self.prestamo = prestamo
        Folleto._folleto.append(self)
        
        if estanteria is not None:
            self.estanteria.getPublicaciones.append(self)

    #Metodos
    def mostrarInfo(self):
        return  f'INFORMACION DEL FOLLETO: \n Nombre: {self.getNombre()} \n Año: {self.getAño} \n Codigo: {self.getCodigo} \n Ejemplar: {self.getEjemplar} \n Estado: {self.getEstado} \n Referencia: {self.getReferencia}'
        
    def mostrarUbicacion(self):
        return "Localizado en: " + str(self.estanteria.mostrarInfo())
    
    def getReferencia(self):
        return self._referencia
    def setReferencia(self,a):
        self._referencia = a

    @classmethod
    def getFolleto(cls):
        return Folleto._folleto
