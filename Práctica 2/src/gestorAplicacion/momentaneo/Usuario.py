from abc import ABC, abstractmethod

class Usuario:
    @abstractmethod
    def prestar(self, publicacion, fechainicio):
        pass
   
    def diasVencimiento(self):
        pass

    
    def renovar(self,prestamo):
        pass
