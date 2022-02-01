from re import T
from tkinter import *

class FieldFrame(Frame):
    _criterios = []
    _entrys = []

    def __init__(self,master,tituloCriterios, criterios, tituloValores,
        valores=None, habilitado=None):
        super().__init__(master,relief=GROOVE, borderwidth=4)
        self._criterios = criterios
        self._entrys = criterios.copy()

        Label(self,text=tituloCriterios).grid(row=0,column=0)
        Label(self,text=tituloValores).grid(row=0,column=1)

        for i in range(len(criterios)):
            Label(self,text=criterios[i]).grid(row=i+1,column=0)
            if valores is not None:
                if habilitado is None:
                    self._entrys[i] = Entry(self,width=50)
                    self._entrys[i].grid(row=i+1,column=1)
                    self._entrys[i].insert(0,valores[i])
                else:
                    estado = NORMAL
                    if i+1 in habilitado:
                        estado = DISABLED
                    self._entrys[i] = Entry(self,width=50)
                    self._entrys[i].grid(row=i+1,column=1)
                    self._entrys[i].insert(0,valores[i])
                    self._entrys[i].config(state=estado)
            else:
                self._entrys[i] = Entry(self,width=50)
                self._entrys[i].grid(row=i+1,column=1)

    def getValue(self,crit):
        i = self._criterios.index(crit)
        valor = self._entrys[i].get()
        return valor

