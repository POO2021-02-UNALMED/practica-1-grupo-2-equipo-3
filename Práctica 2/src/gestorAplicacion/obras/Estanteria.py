class Estanteria: #serializacion ?
    # serialversion ?
    #atributos de clase
    lista = []
    numeroEstanterias = 0
    
    def __init__(self, numero=0, piso=0, limites=None) :
        self.numero = numero
        self.piso = piso
        if limites is None:
            self.limites=[]
        else:
            self.limites = limites 
        Estanteria.numeroEstanterias+=1
        Estanteria.lista.append(self)