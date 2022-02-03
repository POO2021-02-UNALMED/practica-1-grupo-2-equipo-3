from tkinter import *
from functools import partial
from tkinter import ttk
from Ventanas.FieldFrame import FieldFrame
from tkinter import messagebox

## Objetos
from gestorAplicacion.obras.Estanteria import Estanteria
from gestorAplicacion.obras.Publicacion import Publicacion
from gestorAplicacion.personas.Autor import Autor
from gestorAplicacion.personas.Persona import Persona
from gestorAplicacion.personas.Usuario import Usuario
from gestorAplicacion.errores.ErrorAplicacion import Inexistente
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

            Label(master=f_ini,text="Seleccione el tipo de dato que desee ver",
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


            # Información detallada
            Label(master=f1,text="Ingrese el número de estantería para ver todas sus\npublicaciones asociadas",font=("Georgia",12)).pack()
            f = Frame(master=f1)  # Frame de la zona de interacción

            def lanzar(arg):
                def ver():
                    numero = interaccion.getValue(criterios[0])
                    a = True
                    try:    
                        Inexistente.verEstanteria(numero)
                    
                    except Inexistente as i:
                        messagebox.showinfo(title="ERROR",message = i.error2 , detail= '')
                        a = False
                    for elem in Estanteria.getLista():
                        if elem.getNumero() == numero:
                            e = elem
                            break

                    if a == True:
                    
                        windowv = Toplevel()
                        windowv.title("Publicaciones asociadas")
                        #print(Estanteria.getLista())
                        

                        t = Text(windowv,font=("consolas",10))
                        t.insert(1.0,e.mostrarContenido())
                        t.config(state=DISABLED)
                        t.pack()
                    else:
                        pass

                tituloCriterios = ""
                criterios = ["Número"]
                tituloValores = "PUBLICACIONES ASOCIADAS"
                valores= None
                habilitado = None
                if arg is None:
                    interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción
                else:
                    arg.destroy()
                    interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción

                interaccion.pack(side=TOP)
                borrar.config(command=partial(lanzar,interaccion))
                aceptar.config(command=ver)
                f.pack()

            botones = Frame(f)
            aceptar = Button(botones,text="Ver")
            aceptar.grid(row=0,column=0)
            Label(master=botones,text="       ").grid(row=0,column=1)
            borrar = Button(botones,text="Borrar")
            borrar.grid(row=0,column=2)
            Label(master=botones).grid(row=1)
            botones.pack(side=BOTTOM)

            lanzar(None)
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



            # Información detallada
            Label(master=f2,text="Ingrese el Id del autor para ver información detallada de este",font=("Georgia",12)).pack()

            f = Frame(master=f2)  # Frame de la zona de interacción

            def lanzar(arg):
                def ver():
                    id = interaccion.getValue(criterios[0])
                    
                    a = True
                    try:    
                        Inexistente.verAutor(id)
                    
                    except Inexistente as i:
                        messagebox.showinfo(title="ERROR",message = i.error2 , detail= '')
                        a = False
                    for elem in Autor.getAutores():
                        if elem.getId() == id:
                            e = elem
                            break

                    if a == True:
                    
                        windowv = Toplevel()
                        windowv.title("Informacion personal")
                        #print(Estanteria.getLista())
                        

                        t = Text(windowv,font=("consolas",10))
                        t.insert(1.0,e.infoPersonal())
                        t.config(state=DISABLED)
                        t.pack()
                    else:
                        pass

                tituloCriterios = ""
                criterios = ["ID"]
                tituloValores = "INFORMACIÓN PERSONAL"
                valores= None
                habilitado = None
                if arg is None:
                    interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción
                else:
                    arg.destroy()
                    interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción

                interaccion.pack(side=TOP)
                borrar.config(command=partial(lanzar,interaccion))
                aceptar.config(command=ver)
                f.pack()

            botones = Frame(f)
            aceptar = Button(botones,text="Ver")
            aceptar.grid(row=0,column=0)
            Label(master=botones,text="       ").grid(row=0,column=1)
            borrar = Button(botones,text="Borrar")
            borrar.grid(row=0,column=2)
            Label(master=botones).grid(row=1)
            botones.pack(side=BOTTOM)

            lanzar(None)
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


            # Información detallada
            Label(master=f3,text="Ingrese el codigo de la publicación para ver información detallada de esta",font=("Georgia",12)).pack()

            f = Frame(master=f3)  # Frame de la zona de interacción

            def lanzar(arg):
                def ver():
                    codigo = interaccion.getValue(criterios[0])
                    a = True
                    try:    
                        Inexistente.verPublicacion(codigo)
                    
                    except Inexistente as i:
                        messagebox.showinfo(title="ERROR",message = i.error2 , detail= '')
                        a = False
                    for elem in Publicacion.getLista():
                        if elem.getCodigo() == codigo   :
                            e = elem
                            break

                    if a == True:
                    
                        windowv = Toplevel()
                        windowv.title("Informacion detallada")
                        #print(Estanteria.getLista())
                        

                        t = Text(windowv,font=("consolas",10))
                        t.insert(1.0,e.mostrarInfo())
                        t.config(state=DISABLED)
                        t.pack()
                    else:
                        pass

                tituloCriterios = ""
                criterios = ["Código"]
                tituloValores = "INFORMACIÓN DETALLADA"
                valores= None
                habilitado = None
                if arg is None:
                    interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción
                else:
                    arg.destroy()
                    interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción

                interaccion.pack(side=TOP)
                borrar.config(command=partial(lanzar,interaccion))
                aceptar.config(command=ver)
                f.pack()

            botones = Frame(f)
            aceptar = Button(botones,text="Ver")
            aceptar.grid(row=0,column=0)
            Label(master=botones,text="       ").grid(row=0,column=1)
            borrar = Button(botones,text="Borrar")
            borrar.grid(row=0,column=2)
            Label(master=botones).grid(row=1)
            botones.pack(side=BOTTOM)

            lanzar(None)
            f3.pack()

        def cuatro():
            Label(master=f4,text="Mostrar Usuarios", font=("Georgia",20)).pack()
            Label(master=f4,text="Haga click en el botón para mostrar todos los registros\nde usuarios en una ventana nueva:",font=("Georgia",12)).pack()

            botones = Frame(master=f4)  # Frame de la zona de interacción
            def reg():
                windowr = Toplevel()
                windowr.title("Registro de Usuarios")
                t = Text(windowr,font=("consolas",10))
                t.insert(1.0,Usuario.mostrarUsuarios())
                t.config(state=DISABLED)
                t.pack()

            Label(botones,text="").grid(row=0)
            Button(botones,text="Ver registros",command=reg).grid(row=1)
            Label(botones,text="").grid(row=2)
            botones.pack()

            # Información detallada
            Label(master=f4,text="Ingrese el ID del usuario para ver su información personal",font=("Georgia",12)).pack()

            f = Frame(master=f4)  # Frame de la zona de interacción

            def lanzar(arg):
                def ver():
                    id = interaccion.getValue(criterios[0])
                    a = True
                    try:    
                        Inexistente.verUsuario(id)
                    
                    except Inexistente as i:
                        messagebox.showinfo(title="ERROR",message = i.error2 , detail= '')
                        a = False
                    for elem in Usuario.getUsuarios():
                        if elem.getId() == id   :
                            e = elem
                            break

                    if a == True:
                    
                        windowv = Toplevel()
                        windowv.title("Informacion personal")
                        #print(Estanteria.getLista())
                        

                        t = Text(windowv,font=("consolas",10))
                        t.insert(1.0,e.infoPersonal())
                        t.config(state=DISABLED)
                        t.pack()
                    else:
                        pass

                tituloCriterios = ""
                criterios = ["ID"]
                tituloValores = "INFORMACIÓN PERSONAL"
                valores= None
                habilitado = None
                if arg is None:
                    interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción
                else:
                    arg.destroy()
                    interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción

                interaccion.pack(side=TOP)
                borrar.config(command=partial(lanzar,interaccion))
                aceptar.config(command=ver)
                f.pack()

            botones = Frame(f)
            aceptar = Button(botones,text="Ver")
            aceptar.grid(row=0,column=0)
            Label(master=botones,text="       ").grid(row=0,column=1)
            borrar = Button(botones,text="Borrar")
            borrar.grid(row=0,column=2)
            Label(master=botones).grid(row=1)
            botones.pack(side=BOTTOM)

            lanzar(None)
            f4.pack()

        ini()


        
        