
from Estanteria import Estanteria
from Publicacion import Publicacion, Estado
from Libro import Libro, tipoLibro
from Revista import Revista

r1= Revista(2342,"semana",2014,1,'sds')
l1= Libro(23543,"olvidosqeremos",2003,1,"abad", tipoLibro.cg,'dfse',1  )
e1 = Estanteria(1,1,["a","b"])
e2 = Estanteria(2,1,["s","v"])
e1.agregarPublicacion(r1)
print(e1.mostrarInfo())
print(e1.mostrarContenido())
print(not [2])