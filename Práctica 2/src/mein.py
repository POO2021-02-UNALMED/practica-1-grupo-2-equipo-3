from gestorAplicacion.obras.Estanteria import Estanteria
from gestorAplicacion.obras.Libro import Libro,tipoLibro
from gestorAplicacion.obras.Revista import Revista
from gestorAplicacion.personas.EstudianteProfesor import EstudianteProfesor
from gestorAplicacion.personas.Externo import Externo
import re

print(re.findall('^[0-3][0-1].[0-1][0-2].\d{4}', '01-01-2000'))