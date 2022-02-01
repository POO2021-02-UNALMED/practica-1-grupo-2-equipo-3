from abc import ABC, abstractmethod



class Usuario:

    _usuarios=[]

    def getUsuarios(self):
        return Usuario._usuarios

    @abstractmethod
    def prestar(self, publicacion, fechainicio):
        pass
   
    def diasVencimiento(self):
        pass

    
    def renovar(self,prestamo):
        pass
