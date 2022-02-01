from tkinter import *
from FielFrame import FieldFrame

class Frame1(Frame):
    def __init__(self,w):
        super().__init__(master=w,width=450)

        nombre = Label(master=self,text="Ingresar Registros",
        font=("Georgia",20)).pack()

        desc = Label(master=self,text="Acá se pone una corta descripción de cada proceso"+
        "\ningrese los correspondiente segín desee",
        font=("Georgia",12)).pack()

        # interaccion = Frame(master=self)  # Frame de la zona de interacción
        tituloCriterios = "CRITERIO"
        criterios = ["Codigo", "Nombre", "Descripción", "Ubicación"]
        interaccion = FieldFrame(self,tituloCriterios, criterios, "VALOR")  # Frame de la zona de interacción
        
        interaccion.pack()