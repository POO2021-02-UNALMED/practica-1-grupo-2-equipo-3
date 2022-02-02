from tkinter import *
from functools import partial
from tkinter import ttk
# from Ventanas.FieldFrame import FieldFrame

## Objetos
from gestorAplicacion.obras.Estanteria import Estanteria
from gestorAplicacion.obras.Publicacion import Publicacion
from gestorAplicacion.personas.Autor import Autor
from gestorAplicacion.personas.Usuario import Usuario
##

class Frame2(Frame):
    _opcion = None
    def __init__(self,w):
        super().__init__(master=w,width=450)
        f_ini = Frame(master=self)
        f1 = Frame(master=self)
        f2 = Frame(master=self)
        f3 = Frame(master=self)
        f4 = Frame(master=self)

        def ini():
            Label(master=f_ini,text="Mostrar Registros",
            font=("Georgia",20)).pack()

            Label(master=f_ini,text="Seleccione el tipo de dato que desee ingresar",
            font=("Georgia",12)).pack()


            interaccion = Frame(master=f_ini)  # Frame de la zona de interacción

            def ejecutar(arg):
                self._opcion = arg.get()

                if self._opcion == "Estantería":
                    f_ini.pack_forget()
                    uno()
                elif self._opcion == "Autor":
                    f_ini.pack_forget()
                    dos()
                elif self._opcion == "Publicación":
                    f_ini.pack_forget()
                    tres() 
                elif self._opcion == "Usuario":
                    f_ini.pack_forget()
                    cuatro() 

            opciones = ttk.Combobox(interaccion)
            opciones['values']= ["Estantería","Autor","Publicación","Usuario"]
            opciones.pack()

            Button(interaccion,text="Aceptar",command=partial(ejecutar,opciones)).pack()

            interaccion.pack()

            f_ini.pack()

        def uno():
            Label(master=f1,text="Mostrar Estanterías", font=("Georgia",20)).pack()
            Label(master=f1,text="Haga click en el botón para mostrar todos los registros\nde estanterías en una ventana nueva:",font=("Georgia",12)).pack()

            botones = Frame(master=f1)  # Frame de la zona de interacción
            def reg():
                windowr = Toplevel()
                windowr.title("Registro de Estanterías")
                t = Text(windowr,font=("consolas",10))
                t.insert(1.0,Estanteria.mostrarRegistros())
                t.config(state=DISABLED)
                t.pack()

            Label(botones,text="").grid(row=0)
            Button(botones,text="Ver registros",command=reg).grid(row=1)
            Label(botones,text="").grid(row=2)
            botones.pack()

            f1.pack()

        def dos():
            Label(master=f2,text="Mostrar Autores", font=("Georgia",20)).pack()
            Label(master=f2,text="Haga click en el botón para mostrar todos los registros\nde autores en una ventana nueva:",font=("Georgia",12)).pack()

            botones = Frame(master=f2)  # Frame de la zona de interacción
            def reg():
                windowr = Toplevel()
                windowr.title("Registro de Autores")
                t = Text(windowr,font=("consolas",10))
                t.insert(1.0,Autor.mostrarRegistros())
                t.config(state=DISABLED)
                t.pack()

            Label(botones,text="").grid(row=0)
            Button(botones,text="Ver registros",command=reg).grid(row=1)
            Label(botones,text="").grid(row=2)
            botones.pack()


            f2.pack()

        def tres():
            Label(master=f3,text="Mostrar Publicaciones", font=("Georgia",20)).pack()
            Label(master=f3,text="Haga click en el botón para mostrar todos los registros\nde publicaciones en una ventana nueva:",font=("Georgia",12)).pack()

            botones = Frame(master=f3)  # Frame de la zona de interacción
            def reg():
                windowr = Toplevel()
                windowr.title("Registro de Publicaciones")
                t = Text(windowr,font=("consolas",10))
                t.insert(1.0,Publicacion.mostrarRegistros())
                t.config(state=DISABLED)
                t.pack()

            Label(botones,text="").grid(row=0)
            Button(botones,text="Ver registros",command=reg).grid(row=1)
            Label(botones,text="").grid(row=2)
            botones.pack()


            f3.pack()

        def cuatro():
            Label(master=f4,text="Mostrar Usuarios", font=("Georgia",20)).pack()
            Label(master=f4,text="Haga click en el botón para mostrar todos los registros\nde usuarios en una ventana nueva:",font=("Georgia",12)).pack()

            botones = Frame(master=f4)  # Frame de la zona de interacción
            def reg():
                windowr = Toplevel()
                windowr.title("Registro de Usuarios")
                t = Text(windowr,font=("consolas",10))
                t.insert(1.0,Usuario.mostrarRegistros())
                t.config(state=DISABLED)
                t.pack()

            Label(botones,text="").grid(row=0)
            Button(botones,text="Ver registros",command=reg).grid(row=1)
            Label(botones,text="").grid(row=2)
            botones.pack()

            f4.pack()

        ini()


        
        