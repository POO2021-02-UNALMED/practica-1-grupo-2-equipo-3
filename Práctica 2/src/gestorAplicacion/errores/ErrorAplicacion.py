
#Clase Abuela de Errores
class ErrorAplicacion(Exception):
    def __init__(self, error) :
        self.error = "Manejo de errores de la aplicación: \n" + error

#-------------------------------------------------------------------------------------------
#Clase Padre1
class ValorInvalido(ErrorAplicacion):
    def __init__(self, error3):
        super().__init__("Valor Invalido Error -> ")
        self.error2= self.error + error3
#
class Negativo(ValorInvalido):
    
    def __init__(self):
        
        super().__init__("el valor ingresado es negativo") 

    @classmethod
    def ver(cls, *a):
        for x in a:
            if int(x) < 0:
               
                raise Negativo()

    def imprimir(self,*a):
        c = ""
        for x in a:
            if int(x) <0:
                c= c + x + " "
        return "Ingreso los siguientes valores negativos " + c
#
class NumeroE(ValorInvalido):
    def __init__(self):
        super().__init__("el valor ingresado es un numero") 

    @classmethod
    def ver(cls, *a):
        for x in a:
            if x.isnumeric():
                raise NumeroE()

    def imprimir(self,*a):
        c = ""
        for x in a:
            if x.isnumeric():
                c= c + x + " "
        return "Ingreso los siguientes numeros " + c   
#
class FueradeRango(ValorInvalido):
    def __init__(self):
        super().__init__("el valor ingresado esta fuera del rango") 

    @classmethod
    def ver(cls, *a):
        for x in a:
            if int(x) > 2:
                raise FueradeRango()

    @classmethod 
    def ver2(cls, *a):
        for x in a:
            if len(x) > 40:
                raise FueradeRango()

    def imprimir(self,*a):
        c = ""
        for x in a:
            if int(x) > 2:
                c= c + x + " "
        return "Ingreso los siguientes numeros fuera de rango " + c 
    
    def imprimir2(self,*a):
        c = ""
        for x in a:
            if len(x) > 40:
                c= c + x + " "
        return "Ingreso la siguiente cadena que excede el rango " + c
#
class Fecha(ValorInvalido):
    def __init__(self):
        super().__init__("el valor ingresado no tiene el formato de fecha correcto")

    @classmethod
    def ver(cls, *a):
        import re
        for x in a:
            if re.findall('^[0-3][0-1].[0-1][0-2].\d{4}', x):
                pass
            else:
                raise Fecha()
    def imprimir(self,*a):
        import re
        c = ""
        for x in a:
            if re.findall('^[0-3][0-1].[0-1][0-2].\d{4}', x):
                pass
            else:
                c= c + x + " "
        return "Ingreso las siguientes fechas en el formato erroneo " + c 

class EnumVivo(ValorInvalido):
    def __init__(self):
        super().__init__("el valor ingresado no cumple con 'si' o 'no' ")

    def imprimir(self,*a):
        c = ""
        for x in a:
            if not x == "si" or x == "Si" or x == "SI" or x == "no" or x == "NO" or x == "No":
                 c= c + x + " "       
        return "Ingreso la siguiente cadena erronea " + c

            
                






     
#clase Padre2 -------------------------------------------------------------------------------------------------------------------------
class BaseDatosError(ErrorAplicacion):
    def __init__(self,error3):
        super().__init__(" Base de Datos error ->")
        self.error2 = self.error + error3
           

class Inexistente(BaseDatosError):
    def __init__(self):
        super().__init__("El identificador no corresponde a un objeto creado") 

    @classmethod
    def verEstanteria(cls, a):
        from gestorAplicacion.obras.Estanteria import Estanteria
        if not Estanteria.getLista():
            raise Inexistente()
        else:
            for x in Estanteria.getLista():
                if x.getNumero() == a:
                    pass
                else:
                    raise Inexistente()

    def imprimirEstanteria(self):
        from gestorAplicacion.obras.Estanteria import Estanteria
        for x in  Estanteria.getLista():
            pass


            





if __name__ == "__main__":
    try:
        raise Negativo()
    except Negativo as e:
        print(e.error2)



    