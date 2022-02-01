from tkinter import *

class Frame3(Frame):
    def __init__(self,w):
        super().__init__(master=w,width=450)

        nombre = Label(master=self,text="Eliminar Registros",
        font=("Georgia",20)).pack()

        desc = Label(master=self,text="Seleccione el tipo de resgitro que desea eliminar, ingrese su ID y haga click en aceptar "+
        "\n(puede consultar el ID haciendo uso de la pestaña 'Mostrar Registros')",
        font=("Georgia",12)).pack()

        interaccion = Frame(master=self)  # Frame de la zona de interacción
        interaccion.pack()