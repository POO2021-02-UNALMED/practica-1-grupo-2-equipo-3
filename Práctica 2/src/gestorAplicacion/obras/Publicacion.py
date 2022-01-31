from enum import Enum

class Estado(Enum):
    circulacion = "CIRCULACION"
    prestado = "PRESTADO"

class Publicacion : 
    # serialversion ?

    #Atributos de clase
    _lista = []
    numeroPublicaciones = 0

    #Constructor
    def __init__(self, codigo=0,nombre="...",año=0,ejemplar=0,estado=Estado.circulacion) :
        self.codigo = codigo
        self.nombre = nombre
        self.año= año
        self.ejemplar = ejemplar
        self.estado = estado
        self.estanteria=None
        self.prestamo=None
        Publicacion.numeroPublicaciones+=1
        Publicacion._lista.append(self)

    #Metodos
    def mostrarInfo(self):
        return f'INFORMACION DE LA PUBLICACION: \n Codigo: {self.getCodigo()} \n Nombre: {self.getNombre()} \n Ejemplar: {self.getEjemplar()}'

    @classmethod
    def eliminarPublicacion(cl,p):
        Publicacion._lista.remove(p)
        del p

    @classmethod
    def mostrarRegistros(cls):
        from Libro import Libro
        from Revista import Revista
        from Folleto import Folleto
        c = "Publicaciones creadas "+ "\n"
        for x in Publicacion._lista :
            if isinstance(x,Libro):
                c=c + f'Libro {x.getNombre()} Codigo(CP) {x.getCodigo} \n'
            elif isinstance(x,Revista):
                c=c + f'Revista {x.getNombre()} Codigo(CP) {x.getCodigo} \n'
            elif isinstance(x,Folleto):
                c=c + f'Folleto {x.getNombre()} Codigo(CP) {x.getCodigo} \n'
        return c
    
    def verificarPrestado(self):
        if self.getEstado() == Estado.prestado:
            b=True
        else :
            b=False
        return b

    def agregarPublicacion(self,p):
        self._publicaciones.append(p)

    #def mostrarUbicacion(self): ABSTRACTO

    

    
    
    @classmethod
    def getLista(cls):
        return Publicacion._lista
    @classmethod
    def getNumeroPublicaciones(cls):
        return Publicacion._numeroEstanterias

    def getCodigo(self):
        return self.codigo
    def setCodigo(self,a):
        self.codigo = a

    def getNombre(self):
        return self.nombre
    def setNombre(self,a):
        self.nombre = a

    def getAño(self):
        return self.año 
    def setAño(self,a):
        self.año= a

    def getEjemplar(self):
        return self.ejemplar
    def setEjemplar(self,a):
        self.ejemplar=a

    def getEstado(self):
        return self.estado
    def setEstado(self,a):
        self.estado = a

    def getEstanteria(self):
        return self.estanteria
    def setEstanteria(self, a):
        self.estanteria = a

    def getPrestamo(self):
        return self.prestamo
    def setPrestamo(self,p):
        self.prestamo = p

