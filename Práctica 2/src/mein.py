
# from Obras.Estanteria import Estanteria
# from gestorAplicacion.momentaneo.Publicacion import Publicacion, Estado
# from gestorAplicacion.momentaneo.Libro import Libro, tipoLibro
# from gestorAplicacion.momentaneo.Revista import Revista


# from Obras import Estanteria, Libro, Revista

from momentaneo.Estanteria import Estanteria
from momentaneo.Libro import Libro,tipoLibro
from momentaneo.Revista import Revista


if __name__ == "__main__":
    r1= Revista(2342,"semana",2014,1,'sds')
    r2=Revista(6454,"weekl",2014,1,'es')
    l1= Libro(23543,"olvidosqeremos",2003,1,"abad", tipoLibro.cg,'dfse',1  )
    e1 = Estanteria(1,1,["a","b"])
    e2 = Estanteria(2,1,["s","v"])

    print(e1.mostrarInfo())
    print(e1.mostrarContenido())
    print(Estanteria.mostrarRegistros())
    print(r1.getEstanteria())
    print(Revista.getRevista())