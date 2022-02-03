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
from gestorAplicacion.prestamo.Prestamo import Prestamo
##

class Frame4(Frame):
    _opcion = None
    _n = None
    _i = 1
    def __init__(self,w):
        super().__init__(master=w,width=450)
        f_ini = Frame(master=self)
        # presentacion = 0

        def ini():
            presentacion = Label(master=f_ini,text="Ventana de Préstamos",
            font=("Georgia",20))
            presentacion.pack()
            pregunta = Frame(master=f_ini)  # Frame de la zona de interacción

            def inter(op):
                self._n = int(op.get())
                pregunta.pack_forget()
                f = Frame(master=f_ini)  # Frame de la zona de interacción

                botones = Frame(f)   # Zona de botones
                aceptar = Button(botones,text="Aceptar")
                aceptar.grid(row=1,column=1)
                borrar = Button(botones,text="Borrar")
                borrar.grid(row=1,column=2)
                botones.pack(side=BOTTOM)

                # Label(master=f,text="Préstamo {}".format(self._i),
                # font=("Georgia",12)).pack()


                def lanzar(arg):
                    tituloCriterios = "PRÉSTAMO {}".format(self._i)
                    criterios = ['ID',"Fecha", "Publicación (ID)", "Usuario (ID)"]
                    tituloValores = "VALOR"
                    valores= [len(Prestamo.getLista()) + 1,"","",""]
                    habilitado = [1]
                    if arg is None:
                        interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción
                    else:
                        arg.destroy()
                        interaccion = FieldFrame(f,tituloCriterios, criterios, tituloValores,valores,habilitado)  # Frame de la zona de interacción

                    interaccion.pack(side=TOP)
                    borrar.config(command=partial(lanzar,interaccion))
                    f.pack()

                    def guardar():
                        id = interaccion.getValue(criterios[0])
                        fechai = interaccion.getValue(criterios[1])
                        publicacion = interaccion.getValue(criterios[2])
                        usuario = interaccion.getValue(criterios[3])

                        us = Usuario.buscarUsuario(usuario)
                        us.prestar(id,publicacion,fechai)

                        ##
                        # Prestamo(fecha,publicacion,usuario)
                        ##
                        messagebox.showinfo(title="Préstamos",
                        message="INFORMACIÓN:",
                        detail="El préstamo ha sido registrado con éxito")

                        f.destroy()
                        self._i +=1
                        if self._i <= self._n :
                            inter(nprestamos)
                        else:
                            # Label(master=f_ini,text="Vuelva a ingresar a la pestaña para regiustrar mas").pack()
                            presentacion.destroy()
                            self._i = 1
                            ini()


                    aceptar.config(command=guardar)


                lanzar(None)
                pass # inter


            
            Label(master=pregunta,text="¿Cuántos prestamos realizará el usuario?",
            font=("Georgia",12)).pack()
            nprestamos =Entry (pregunta,width=4,font=('Consolas',14),
            justify='center') # Máximo un número de 2 cifras
            nprestamos.pack()

            Button(pregunta,text="Registrar préstamos",
            command = partial(inter,nprestamos)) .pack()
            Label(master=pregunta,text="").pack()

            # Button(pregunta,text="Desplegar",
            # command = partial(inter,nprestamos)) .pack()
            #

            pregunta.pack()

            f_ini.pack()


        ini()