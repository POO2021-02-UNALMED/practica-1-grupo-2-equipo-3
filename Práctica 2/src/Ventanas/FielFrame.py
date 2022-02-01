from tkinter import *

class FieldFrame(Frame):
    # _valores = None
    # _habilitado = None

    def __init__(self,master,tituloCriterios, criterios, tituloValores,
     valores=None, habilitado=None):
     super().__init__(master,relief=GROOVE, borderwidth=4)

     Label(self,text=tituloCriterios).grid(row=1,column=1)
     Label(self,text=tituloValores).grid(row=1,column=2)

     for i in range(len(criterios)):
        Label(self,text=criterios[i]).grid(row=i+2,column=1) 

