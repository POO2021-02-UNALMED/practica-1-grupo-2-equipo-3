from tkinter import *
from tkinter import messagebox
from functools import partial
from Ventanas.proceso1 import Frame1
from Ventanas.proceso2 import Frame2
from Ventanas.proceso3 import Frame3
import pickle

## Objetos
from gestorAplicacion.obras.Estanteria import Estanteria
from gestorAplicacion.obras.Folleto import Folleto
from gestorAplicacion.obras.Libro import Libro
from gestorAplicacion.obras.Publicacion import Publicacion
from gestorAplicacion.obras.Revista import Revista
from gestorAplicacion.personas.Autor import Autor
from gestorAplicacion.personas.Usuario import Usuario
##

## Funciones
from baseDatos.Almacenamiento import serializar,deserializar
##

def ingreso(start):
    window = Toplevel()
    # window.geometry("450x300")
    window.title("Sistema de Información Bibliotecario")
    start.iconify()
    deserializar() # Cargamos todas las listas guardadas


    def inicio():
        serializar() # Guardamos todas las listas de objetos

        messagebox.showinfo(title="Guardar Y Salir",
        message="INFORMACIÓN:",
        detail="Todos los datos han sido almacenados en el dispositivo")


        start.deiconify() # Ocultamos la ventana de inicio
        window.destroy() # Destruimos la ventana principal

    def acerca():
        messagebox.showinfo(title="Acerca de",
        message="Autores:",
        detail="- Nelson Andrés Salinas Zapata\n- Luis Felipe Marín Buitrago")

    def aplicacion():
        messagebox.showinfo(title="Aplicación",
        message="Sistema de infomración Bibliotecario:",
        detail="Por medio de esta aplicación usted podrá tener un registro del material disponible y del estado de los préstamos.")

    principal = Frame(master=window,width=450,height=300) # Frame Interfaz de Inicio
    frame1 = Frame1(window) # Frame proceso 1
    frame2 = Frame2(window) # Frame proceso 2
    frame3 = Frame3(window) # Frame proceso 3

    def proceso1():
        principal.pack_forget()
        frame2.pack_forget()
        frame3.pack_forget()
        frame1.pack()

    def proceso2():
        principal.pack_forget()
        frame1.pack_forget()
        frame3.pack_forget()
        frame2.pack()

    def proceso3():
        principal.pack_forget()
        frame1.pack_forget()
        frame2.pack_forget()
        frame3.pack()

    def pprincipal():
        frame1.pack_forget()
        frame2.pack_forget()
        frame3.pack_forget()
        principal.pack()

    #Manejo de menús
    window.option_add('*tearOff', False)
    menubar = Menu(window)

    archivo = Menu(menubar)
    menubar.add_cascade(menu=archivo, label='Archivo')
    archivo.add_command(label="Aplicación", command=aplicacion)
    archivo.add_command(label="Guardar y Salir", command=inicio)

    procesos = Menu(menubar)
    menubar.add_cascade(menu=procesos, label='Procesos y Consultas')
    procesos.add_command(label="Ingresar Registros", command=proceso1)
    procesos.add_command(label="Mostrar Registros", command=proceso2)
    procesos.add_command(label="Eliminar Registros", command=proceso3)
    procesos.add_command(label="Interfaz de Inicio", command=pprincipal)

    ayuda = Menu(menubar)
    menubar.add_cascade(menu=ayuda, label ="Ayuda")
    ayuda.add_command(label="Acerca de", command=acerca)

    window['menu'] = menubar


    #Frame inicial
    Label(master=principal,text="Sistema de Información\n Bibliotecario (SIB)",
    font=("Georgia",20)).place(x=70,y=0)
    texto = Text(principal, font=("Georgia",10),width=42,height=9,relief=GROOVE, borderwidth=4)
    
    texto.insert(1.0,"Mediante esta aplicación usted podrá realizar los siguientes \nprocesos:\n\n"+
    "1. Proceso 1\n"+
    "2. Proceso 2\n"+
    "3. Proceso 3\n\n"+
    "Para acceder a estas funcionalidades despliegue el menú de \n'Procesos y Consultas' y haga click en una opción")
    texto.config(state=DISABLED)
    texto.place(x=32,y=110)
    principal.pack()