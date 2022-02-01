from tkinter import *

class FieldFrame(Frame):

    def __init__(self,master,tituloCriterios, criterios, tituloValores,
        valores=None, habilitado=None):
        super().__init__(master,relief=GROOVE, borderwidth=4)

        Label(self,text=tituloCriterios).grid(row=1,column=1)
        Label(self,text=tituloValores).grid(row=1,column=2)

        for i in range(len(criterios)):
            Label(self,text=criterios[i]).grid(row=i+2,column=1)
            if valores is not None:
                if habilitado is None:
                    e = Entry(self,width=50)
                    e.grid(row=i+2,column=2)
                    e.insert(0,valores[i])
                else:
                    estado = NORMAL
                    if i+1 in habilitado:
                        estado = DISABLED
                    e = Entry(self,width=50)
                    e.grid(row=i+2,column=2)
                    e.insert(0,valores[i])
                    e.config(state=estado)
                    pass
            else:
                Entry(self,width=50).grid(row=i+2,column=2)

        # Button(self,text="Aceptar").grid(row=len(criterios)+3,column=1)
        # Button(self,text="Borrar").grid(row=len(criterios)+3,column=2)




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


     

