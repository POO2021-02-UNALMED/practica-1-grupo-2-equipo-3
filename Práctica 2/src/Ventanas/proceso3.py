# from distutils import command
from tkinter import *
from functools import partial
from Ventanas.FieldFrame import FieldFrame
from tkinter import ttk

## Objetos
from gestorAplicacion.obras.Estanteria import Estanteria
from gestorAplicacion.obras.Publicacion import Publicacion
from gestorAplicacion.personas.Autor import Autor
from gestorAplicacion.personas.Usuario import Usuario
##

class Frame3(Frame):
    def __init__(self,w):
        super().__init__(master=w,width=450)
        f_ini = Frame(master=self)
        f1 = Frame(master=self)
        f2 = Frame(master=self)
        f3 = Frame(master=self)
        f4 = Frame(master=self)

        def ini():
            Label(master=f_ini,text="Eliminar Registros",
            font=("Georgia",20)).pack()

            # Label(master=self,text="Seleccione el tipo de resgitro que desea eliminar, ingrese su ID y haga click en aceptar "+
            # "\n(puede consultar el ID haciendo uso de la pestaña 'Mostrar Registros')",
            # font=("Georgia",12)).pack()

            Label(master=f_ini,text="Seleccione el tipo de resgitro que desea eliminar",
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
            Label(master=f1,text="Eliminar Estantería", font=("Georgia",20)).pack()
            Label(master=f1,text="Ingrese el número de estantería y haga click en eliminar ",
            font=("Georgia",12)).pack()
            Label(master=f1,text="(puede consultar este número haciendo uso de la pestaña 'Mostrar Registros')",
             font=("Georgia",10)).pack()
            
            f = Frame(master=f1)  # Frame de la zona de interacción

            def lanzar(arg):
                def elim():
                    pass
                tituloCriterios = ""
                criterios = ["Número"]
                tituloValores = "ESTANTERÍA"
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
            f1.pack()


        def dos():
            Label(master=f2,text="Eliminar Autor", font=("Georgia",20)).pack()
            Label(master=f2,text="Ingrese el ID de autor y haga click en eliminar ",
            font=("Georgia",12)).pack()
            Label(master=f1,text="(puede consultar este número haciendo uso de la pestaña 'Mostrar Registros')",
             font=("Georgia",10)).pack()
            
            f = Frame(master=f2)  # Frame de la zona de interacción

            def lanzar(arg):
                def elim():
                    pass
                tituloCriterios = ""
                criterios = ["ID"]
                tituloValores = "AUTOR"
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
            f2.pack()


        def tres():
            Label(master=f3,text="Eliminar Publicación", font=("Georgia",20)).pack()
            Label(master=f3,text="Ingrese el código de la publicación y haga click en eliminar ",
            font=("Georgia",12)).pack()
            Label(master=f3,text="(puede consultar este número haciendo uso de la pestaña 'Mostrar Registros')",
             font=("Georgia",10)).pack()
            
            f = Frame(master=f3)  # Frame de la zona de interacción
            def lanzar(arg):
                def elim():
                    pass
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
            f3.pack()

        def cuatro():
            Label(master=f4,text="Eliminar Usuario", font=("Georgia",20)).pack()
            Label(master=f4,text="Ingrese el ID del usuario y haga click en eliminar ",
            font=("Georgia",12)).pack()
            Label(master=f4,text="(puede consultar este número haciendo uso de la pestaña 'Mostrar Registros')",
             font=("Georgia",10)).pack()
            
            f = Frame(master=f4)  # Frame de la zona de interacción

            def lanzar(arg):
                def elim():
                    pass

                tituloCriterios = ""
                criterios = ["ID"]
                tituloValores = "USUARIO"
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
            f4.pack()

        ini()
