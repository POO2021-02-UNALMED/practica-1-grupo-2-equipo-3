from abc import ABC, abstractmethod
from gestorAplicacion.obras.Publicacion import Publicacion
from gestorAplicacion.prestamo.Prestamo  import Prestamo

class Usuario:

    _usuarios=[]

    @classmethod
    def mostrarUsuarios(cls):
        from gestorAplicacion.personas.EstudianteProfesor import EstudianteProfesor
        from gestorAplicacion.personas.Externo import Externo
        c = 'USUARIOS CREADOS \n'
        for i,x in enumerate(Externo.l + EstudianteProfesor.l):
            if isinstance(x,EstudianteProfesor):
                c=c + str(i) + f'. Usuario de la Universidad {x.getNombre()} con Identificacion {x.getId()} \n'
            elif isinstance(x,Externo):
                c=c + str(i) + f'. Usuario externo {x.getNombre()} con Identifiacion {x.getId()} \n'
        return c
    
    #Secuencia de metodos para prestamo
    #
    @classmethod
    def buscarUsuario(cls,usuarioId):
        for x in Usuario._usuarios:
            if x.getId() == usuarioId:
                usuario = x
                break
        return usuario

    def prestar(self,id,Codigopub,Finicio):
        pass
               
    
    
    @classmethod
    def getUsuarios(cls):
        return Usuario._usuarios
        
    @classmethod
    def setUsuarios(cls,lista):
        Usuario._usuarios = lista

    @abstractmethod
    def prestar(self, publicacion, fechainicio):
        pass
   
    def diasVencimiento(self):
        pass

    
    def renovar(self,prestamo):
        pass
