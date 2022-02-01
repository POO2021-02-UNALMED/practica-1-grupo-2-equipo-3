from re import T
from tkinter import *

class FieldFrame(Frame):

    def __init__(self,master,tituloCriterios, criterios, tituloValores,
        valores=None, habilitado=None):
        super().__init__(master,relief=GROOVE, borderwidth=4)

        Label(self,text=tituloCriterios).grid(row=0,column=0)
        Label(self,text=tituloValores).grid(row=0,column=1)

        for i in range(len(criterios)):
            Label(self,text=criterios[i]).grid(row=i+1,column=0)
            if valores is not None:
                if habilitado is None:
                    e = Entry(self,width=50)
                    e.grid(row=i+1,column=1)
                    e.insert(0,valores[i])
                else:
                    estado = NORMAL
                    if i+1 in habilitado:
                        estado = DISABLED
                    e = Entry(self,width=50)
                    e.grid(row=i+1,column=1)
                    e.insert(0,valores[i])
                    e.config(state=estado)
            else:
                Entry(self,width=50,textvariable=criterios[i]).grid(row=i+1,column=1)

        def getValue(self,crit):
            crit.get




        ''' Formato de Frame de interacción
        # Frame de interacción
        tituloCriterios = "CRITERIO"
        criterios = ["Codigo", "Nombre", "Descripción", "Ubicación"]
        tituloValores = "VALOR"
        valores = ["Codigo", "Nombre", "Descripción", "Ubicación"]
        valores= []
        habilitado = []
        interaccion = FieldFrame(self,tituloCriterios, criterios, tituloValores)  # Frame de la zona de interacción
        
        interaccion.pack()
        '''


     

