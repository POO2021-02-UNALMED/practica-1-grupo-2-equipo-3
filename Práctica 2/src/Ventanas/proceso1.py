from tkinter import *
from FieldFrame import FieldFrame

class Frame1(Frame):
    def __init__(self,w):
        super().__init__(master=w,width=450)

        nombre = Label(master=self,text="Ingresar Registros",
        font=("Georgia",20)).pack()

        desc = Label(master=self,text="Acá se pone una corta descripción de cada proceso"+
        "\ningrese los correspondiente segín desee",
        font=("Georgia",12)).pack()


        # Frame de interacción
        f = Frame(self)


        tituloCriterios = "CRITERIO"
        criterios = ["Codigo", "Nombre", "Descripción", "Ubicación"]
        tituloValores = "VALOR"
        valores = ["Codigo", "Nombre", "Descripción", "Ubicación"]
        valores= []
        habilitado = []
        interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores)  # Frame de la zona de interacción
        interaccion.pack(side=TOP)

        botones = Frame(f)
        Button(botones,text="Aceptar").grid(row=1,column=1)
        Button(botones,text="Borrar").grid(row=1,column=2)


        f.pack()