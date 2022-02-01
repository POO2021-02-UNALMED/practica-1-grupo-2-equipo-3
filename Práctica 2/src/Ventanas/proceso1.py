from distutils import command
from tkinter import *
from functools import partial
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

        def lanzar(arg):

            def guardar():
                codigo = interaccion.getValue(criterios[0])
                nombre = interaccion.getValue(criterios[1])
                descripcion = interaccion.getValue(criterios[2])
                ubicacion = interaccion.getValue(criterios[3])
                #
                # Objeto(codigo,nombre,descripcion,ubicacion)
                #
                Button(self,text=codigo).pack()
                lanzar(interaccion)

            tituloCriterios = "CRITERIO"
            criterios = ["Codigo", "Nombre", "Descripción", "Ubicación"]
            tituloValores = "VALOR"
            valores = ["Codigo", "Nombre", "Descripción", "Ubicación"]
            valores= [51218418,"","",""]
            habilitado = [1,3]
            if arg is None:
                interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción
            else:
                arg.destroy()
                interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción

            interaccion.pack(side=TOP)
            borrar.config(command=partial(lanzar,interaccion))
            aceptar.config(command=guardar)
            f.pack()


        botones = Frame(f)
        aceptar = Button(botones,text="Aceptar")
        aceptar.grid(row=1,column=1)
        borrar = Button(botones,text="Borrar")
        borrar.grid(row=1,column=2)
        botones.pack(side=BOTTOM)

        lanzar(None)