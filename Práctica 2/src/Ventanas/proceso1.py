from distutils import command
from tkinter import *
from functools import partial
from Ventanas.FieldFrame import FieldFrame
from tkinter import ttk

class Frame1(Frame):
    _opcion = None
    def __init__(self,w):
        super().__init__(master=w,width=450)
        f_ini = Frame(master=self)
        f1 = Frame(master=self)
        f2 = Frame(master=self)
        f3 = Frame(master=self)
        f4 = Frame(master=self)
        f5 = Frame(master=self)
        f6 = Frame(master=self)
        f7 = Frame(master=self)

        def ini():
            Label(master=f_ini,text="Ingresar Registros",
            font=("Georgia",20)).pack()

            Label(master=f_ini,text="Seleccione el tipo de dato que desee ingresar",
            font=("Georgia",12)).pack()


            interaccion = Frame(master=f_ini)  # Frame de la zona de interacción

            def ejecutar(arg):
                self._opcion = arg.get()

                def ejecutar2():
                    self._opcion = opciones.get() #Se guarda la opción correcta
                    f_ini.pack_forget() # Se oculta la vntana inicial
                    if self._opcion == "Libro":
                        tres()
                    elif self._opcion == "Folleto":
                        cuatro()
                    elif self._opcion == "Revista":
                        cinco()
                    elif self._opcion == "Interno":
                        seis()
                    elif self._opcion == "Externo":
                        siete()


                if self._opcion == "Estantería":
                    f_ini.pack_forget()
                    uno()
                    pass
                    #Se guarda la op correcta
                    # label2.config(text=opcion)
                    # label2.pack()
                elif self._opcion == "Autor":
                    f_ini.pack_forget()
                    dos()
                    #Se guarda la op correcta
                    # label2.config(text=opcion)
                    # label2.pack()
                elif self._opcion == "Publicación":
                    label.config(text="Tipo de Publicación:")
                    label.pack()
                    opciones = ttk.Combobox(interaccion)
                    opciones['values']= ["Libro","Folleto","Revista"]
                    opciones.pack()

                    Button(interaccion,text="Aceptar",command=ejecutar2).pack()   

                elif self._opcion == "Usuario":
                    label.config(text="Tipo de Usuario:")
                    label.pack()
                    opciones = ttk.Combobox(interaccion)
                    opciones['values']= ["Interno","Externo"]
                    opciones.pack()

                    Button(interaccion,text="Aceptar",command=ejecutar2).pack()

            opciones = ttk.Combobox(interaccion)
            opciones['values']= ["Estantería","Autor","Publicación","Usuario"]
            opciones.pack()

            Button(interaccion,text="Aceptar",command=partial(ejecutar,opciones)).pack()

            label = Label(master=interaccion,font=("Georgia",10)) # Para desplegar otra opción
            # label2 = Label(master=interaccion,font=("Georgia",10)) # Paras saber si se almacena la opcion correcta

            interaccion.pack()

            f_ini.pack()




        def uno():
            Label(master=f1,text="Registrar Estantería", font=("Georgia",20)).pack()
            Label(master=f1,text="Llene los siguientes campos:",font=("Georgia",12)).pack()


            f = Frame(master=f1)  # Frame de la zona de interacción

            def lanzar(arg):

                def guardar():
                    codigo = interaccion.getValue(criterios[0])
                    nombre = interaccion.getValue(criterios[1])
                    descripcion = interaccion.getValue(criterios[2])
                    ubicacion = interaccion.getValue(criterios[3])
                    #
                    # Objeto(codigo,nombre,descripcion,ubicacion)
                    #
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







            f1.pack()

        def dos():
            Label(master=f2,text="Registrar Autor", font=("Georgia",20)).pack()

            Label(master=f2,text="Llene los siguientes campos:",font=("Georgia",12)).pack()


            interaccion = Frame(master=f2)  # Frame de la zona de interacción


            f2.pack()

        def tres():
            Label(master=f3,text="Registrar Libro", font=("Georgia",20)).pack()

            Label(master=f3,text="Llene los siguientes campos:",font=("Georgia",12)).pack()


            interaccion = Frame(master=f3)  # Frame de la zona de interacción


            f3.pack()

        def cuatro():
            Label(master=f4,text="Registrar Folleto", font=("Georgia",20)).pack()

            Label(master=f4,text="Llene los siguientes campos:",font=("Georgia",12)).pack()


            interaccion = Frame(master=f4)  # Frame de la zona de interacción


            f4.pack()

        def cinco():
            Label(master=f5,text="Registrar Revista", font=("Georgia",20)).pack()

            Label(master=f5,text="Llene los siguientes campos:",font=("Georgia",12)).pack()


            interaccion = Frame(master=f5)  # Frame de la zona de interacción


            f5.pack()

        def seis():
            Label(master=f6,text="Registrar Usuario Interno", font=("Georgia",20)).pack()

            Label(master=f6,text="Llene los siguientes campos:",font=("Georgia",12)).pack()


            interaccion = Frame(master=f6)  # Frame de la zona de interacción


            f6.pack()

        def siete():
            Label(master=f7,text="Registrar Usuario Externo", font=("Georgia",20)).pack()

            Label(master=f7,text="Llene los siguientes campos:",font=("Georgia",12)).pack()


            interaccion = Frame(master=f7)  # Frame de la zona de interacción


            f7.pack()
        

        ini()





        



        