from tkinter import *
from tkinter import messagebox
from functools import partial
from Ventanas.FieldFrame import FieldFrame
from tkinter import ttk

## Objetos
from gestorAplicacion.obras.Estanteria import Estanteria
from gestorAplicacion.obras.Publicacion import Publicacion
from gestorAplicacion.personas.Autor import Autor
from gestorAplicacion.personas.Persona import Persona
from gestorAplicacion.personas.Usuario import Usuario
##


class Frame5(Frame):
    def __init__(self,w):
        super().__init__(master=w,width=450)
        f_ini = Frame(master=self)
        f1 = Frame(master=self)
        f2 = Frame(master=self)
        f3 = Frame(master=self)
        f4 = Frame(master=self)

        def ini():
            Label(master=f_ini,text="Devolución de Publicaciones",
            font=("Georgia",20)).pack()

            Label(master=f_ini,text="Ingrese el código de la publicación de la que desee"+
            " registrar\nsu devolución\n",
            font=("Georgia",12)).pack()


            f = Frame(master=f_ini)  # Frame de la zona de interacción

            def lanzar(arg):
                def elim():
                    codigo = interaccion.getValue(criterios[0])
                    obj = Publicacion() # Falta exepción
                    ##
                    # Devolucion(codigo)
                    # obj = Publicacion.buscarPublicacion(codigo)
                    ##    
                    messagebox.showinfo(title="Devolución de Publicaciones",
                    message="ATENCIÓN: Acaba de registrar la devolución de siguiente publicación",
                    detail = obj.mostrarInfo())
                    lanzar(interaccion)  

                tituloCriterios = ""
                criterios = ["Código"]
                tituloValores = "PUBLICACIÓN"
                valores= None
                habilitado = None
                if arg is None:
                    interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción
                else:
                    arg.destroy()
                    interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción

                interaccion.pack(side=TOP)
                borrar.config(command=partial(lanzar,interaccion))
                eliminar.config(command=elim)
                f.pack()


            botones = Frame(f)
            eliminar = Button(botones,text="Eliminar")
            eliminar.grid(row=0,column=0)
            Label(master=botones,text="       ").grid(row=0,column=1)
            borrar = Button(botones,text="Borrar")
            borrar.grid(row=0,column=2)
            Label(master=botones).grid(row=1)
            botones.pack(side=BOTTOM)

            lanzar(None)
            f_ini.pack()

        ini()