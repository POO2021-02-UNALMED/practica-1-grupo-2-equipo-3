from abc import ABC, abstractmethod

#   CLASE ABSTRACTA
class Persona(ABC):

    #Atributo de Clase
    _lista = []

    #Constructor y atributos
    def __init__(self, nombre='...',id=0,correo='...',tel=0,direccion="...",nacimiento='...',pais='...',vivo=True):
        self.nombre = nombre
        self.id = id
        self.correo = correo
        self.telefono = tel
        self.direccion = direccion
        self.nacimiento = nacimiento
        self.pais = pais
        self.vivo = vivo
        Persona._lista.append(self)

    #Metodos
    @classmethod
    def eliminarPersona(cls,persona):
        Persona._lista.remove(persona)
        del persona

    @classmethod
    def mostrarRegistros(cls):
        
        c="Personas creadas: \n"

        for i,x in enumerate(Persona._lista ):
            if isinstance(x,Autor):
                c=c + str(i) + f'. Autor {x.getNombre()} con Identificacion {x.getId} \n'
            elif isinstance(x,EstudianteProfesor):
                c=c + str(i) + f'. Usuario de la Universidad {x.getNombre()} con Identificacion {x.getId} \n'
            elif isinstance(x,Externo):
                c=c + str(i) + f'. Usuario externo {x.getNombre()} con Identifiacion {x.getId} \n'
        return c

    @abstractmethod
    def infoPersonal(self):
        pass

    

    def getNombre(self):
        return self.nombre
    def setNombre(self,n):
        self.nombre = n

    def getId(self):
        return self.id
    def setId(self,i):
        self.id = i

    def getCorreo(self):
        return self.correo
    def setCorreo(self, c):
        self.correo = c

    def getTel(self):
        return self.telefono
    def setTel(self,t):
        self.telefono = t

    def getDireccion(self):
        return self.direccion
    def setDireccion(self,d):
        self.direccion = d
    
    def getNacimiento(self):
        return self.nacimiento
    def setNacimiento(self,n):
        self.nacimiento = n
    
    def getPais(self):
        return self.pais
    def setPais(self,p):
        self.pais = p

    def isVivo(self):
        return self.vivo
    def setVivo(self,v):
        self.vivo = v

    @classmethod
    def getLista(cls):
        return Persona._lista
    