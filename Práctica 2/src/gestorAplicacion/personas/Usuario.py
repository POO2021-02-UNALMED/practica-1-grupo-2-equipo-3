from abc import ABC, abstractmethod





class Usuario:

    _usuarios=[]

    @classmethod
    def mostrarUsuarios(cls):
        from gestorAplicacion.personas.EstudianteProfesor import EstudianteProfesor
        from gestorAplicacion.personas.Externo import Externo
        c = 'USUARIOS CREADOS \n'
        for i,x in enumerate(Usuario._usuarios):
            if isinstance(x,EstudianteProfesor):
                c=c + str(i) + f'. Usuario de la Universidad {x.getNombre()} con Identificacion {x.getId()} \n'
            elif isinstance(x,Externo):
                c=c + str(i) + f'. Usuario externo {x.getNombre()} con Identifiacion {x.getId()} \n'
        return c

    
    @classmethod
    def getUsuarios(cls):
        return Usuario._usuarios

    def setUsuarios(cls,lista):
        Usuario._usuarios = lista

    @abstractmethod
    def prestar(self, publicacion, fechainicio):
        pass
   
    def diasVencimiento(self):
        pass

    
    def renovar(self,prestamo):
        pass
