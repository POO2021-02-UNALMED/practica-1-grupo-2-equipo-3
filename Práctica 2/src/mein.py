from gestorAplicacion.obras.Estanteria import Estanteria
from gestorAplicacion.obras.Libro import Libro,tipoLibro
from gestorAplicacion.obras.Revista import Revista
from gestorAplicacion.personas.EstudianteProfesor import EstudianteProfesor
from gestorAplicacion.personas.Externo import Externo
import re

print(re.findall('^\d{2}.\d{2}.\d{4}', '05/05/1990'))