from Persona import Persona
from Usuario import Usuario


class Externo(Persona):

    #atributos de clase
    _usuariosexternos=[]

    #constructor
    def __init__(self,nombre='...',id=0, correo="...",tel="...",direccion='...',nacimiento="...",pais='...', rol='...', universidad="No especificada"):
        super().__init__(nombre,id,correo,tel,direccion,nacimiento,pais)
        self._universidad =  universidad
        self._rol = rol
        self._prestamos = []
        Externo._usuariosexternos.append(self)

    def infoPersonal(self):
        return f'DATOS PERSONALES: \n Nombre: {self.nombre} \n Rol: {self._rol} \n CC: {self.id} \n Universidad: {self._universidad} \n Correo: {self.correo} \n Fecha nacimiento: {self.nacimiento} \n Telefono: {self.telefono} \n Direccion residencia: {self.direccion} \n Pais: {self.pais} \n '
    

    @classmethod
    def getEstyProf(cls):
        return EstudianteProfesor._estudiantesyprofesores
    
    def getUniversidad(self):
        return self._universidad
    
    def getRol(self):
        return self._rol
    def setRol(self, r):
        self._rol = r
    
    def getPrestamos(self):
        return self._prestamos
    def setPrestamos(self, p):
        self._prestamos = p