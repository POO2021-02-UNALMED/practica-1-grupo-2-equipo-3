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

class Frame4(Frame):
    _opcion = None
    _n = None
    def __init__(self,w):
        super().__init__(master=w,width=450)
        f_ini = Frame(master=self)

        def ini():
            Label(master=f_ini,text="Ventana de Préstamos",
            font=("Georgia",20)).pack()

            Label(master=f_ini,text="Seleccione el tipo de usuario que realizará el préstamo",
            font=("Georgia",12)).pack()

            interaccion = Frame(master=f_ini)  # Frame de la zona de interacción

            def tipoUsuario(arg):
                def prestamos(op):
                    self._n = int(op.get())
                    # self._n = int(self._n)
                   
                    i = 1
                    p = Toplevel()
                    p.title("Préstamos")
                    # p.geometry("300x300")
                    Label(master=p,text="Préstamo {}".format(i),font=("Georgia",20)).pack()
                    Label(master=p,text="Llene los siguientes campos:",font=("Georgia",12)).pack()

                    f = Frame(master=p)  # Frame de la zona de interacción

                    def lanzar(arg):
                        def guardar():
                            
                            ##
                            # Constructor de préstamo
                            ##
                            messagebox.showinfo(title="Préstamos",
                            message="INFORMACIÓN:",
                            detail="El préstamo ha sido registrado con éxito")
                            p.destroy()

                        tituloCriterios = "ATRIBUTO"
                        criterios = ["Número", "Piso", "Límite Superior", "Límite Inferior"]
                        tituloValores = "VALOR"
                        valores= None
                        habilitado = None
                        if arg is None:
                            interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción
                        else:
                            arg.destroy()
                            interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción

                        interaccion.pack(side=TOP)
                        borrar.config(command=partial(lanzar,interaccion))
                        aceptar.config(command=guardar)
                        f.pack()

                        # p.destroy()


                        



                    botones = Frame(f)
                    aceptar = Button(botones,text="Aceptar")
                    aceptar.grid(row=1,column=1)
                    borrar = Button(botones,text="Borrar")
                    borrar.grid(row=1,column=2)
                    botones.pack(side=BOTTOM)

                    lanzar(None)


                    

                    if self._opcion == "Interno":
                        pass
                    elif self._opcion == "Externo":
                        pass

                    Label(master=interaccion,text="Prueba").pack

                    # for i in range(arg):
                    #     p = Toplevel()
                    #     titulo = "Préstamo {}".format(i+1)
                    #     p.title(titulo)


                self._opcion = arg.get()
                Label(master=interaccion,text="¿Cuántos prestamos realizará el usuario?",
                font=("Georgia",12)).pack()
                nprestamos =Entry (interaccion,width=4,font=('Consolas',14),
                justify='center') # Máximo un número de 2 cifras
                nprestamos.pack()

                Button(interaccion,text="Registrar préstamos",
                command = partial(prestamos,nprestamos)) .pack()
                Label(master=interaccion,text="").pack()

            opciones = ttk.Combobox(interaccion)
            opciones['values']= ["Interno","Externo"]
            opciones.pack()

            Button(interaccion,text="Aceptar",command=partial(tipoUsuario,opciones)).pack()
            Label(master=interaccion,text="").pack()

            interaccion.pack()

            f_ini.pack()


        ini()