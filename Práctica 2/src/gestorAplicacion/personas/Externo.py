from gestorAplicacion.personas.Persona import Persona
from gestorAplicacion.personas.Usuario import Usuario
from gestorAplicacion.prestamo.Prestamo import Prestamo
from gestorAplicacion.obras.Publicacion import Publicacion, Estado



class Externo(Persona,Usuario):

    l=[]
    #constructor
    def __init__(self,nombre='...',id=0, correo="...",tel="...",direccion='...',nacimiento="...",pais='...', rol='...', universidad="No especificada"):
        super().__init__(nombre,id,correo,tel,direccion,nacimiento,pais)
        self._universidad =  universidad
        self._rol = rol
        self._prestamos = []
        Externo.l.append(self)

        Usuario.getUsuarios().append(self)

    def infoPersonal(self):
        return f'USUARIO EXTERNO - DATOS PERSONALES: \n Nombre: {self.nombre} \n Rol: {self._rol} \n CC: {self.id} \n Universidad: {self._universidad} \n Correo: {self.correo} \n Fecha nacimiento: {self.nacimiento} \n Telefono: {self.telefono} \n Direccion residencia: {self.direccion} \n Pais: {self.pais} \n '
    
    def prestar(self,id,Codigopub,Finicio = Prestamo._fechaActual):
    
        #falta considerar excepciones si esta prestado u otras verificarPrestado(), deudas, entregar
        #mensaje al prestar?
        publicacion = Publicacion.buscarPublicacion(Codigopub)
        prestamo = Prestamo(id, Finicio, publicacion)
        prestamo.determinarFinExterno()
        self.getPrestamos().append(prestamo)
        publicacion.setPrestamo(prestamo)
        publicacion.setEstado(Estado.prestado)
    
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