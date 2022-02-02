from gestorAplicacion.obras.Estanteria import Estanteria
from gestorAplicacion.obras.Libro import Libro,tipoLibro
from gestorAplicacion.obras.Revista import Revista
from gestorAplicacion.personas.EstudianteProfesor import EstudianteProfesor
from gestorAplicacion.personas.Externo import Externo

if __name__ == "__main__":
    r1= Revista(2342,"semana",2014,1,'sds')
    r2=Revista(6454,"weekl",2014,1,'es')
    l1= Libro(23543,"olvidosqeremos",2003,1,"abad", tipoLibro.cg,'dfse',1  )
    e1 = Estanteria(1,1,["a","b"])
    e2 = Estanteria(2,1,["s","v"])
    p1 = EstudianteProfesor(1,1,1,1,1,1,1,1)
    p2 = Externo(2,2,2,2,2,2,2,2,2)

    print(e1.mostrarInfo())
    print(e1.mostrarContenido())
    print(Estanteria.mostrarRegistros())
    print(r1.getEstanteria())
    print(Revista.getRevista())