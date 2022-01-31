from email import message
from tkinter import *
from tkinter import messagebox

def ingreso(start):
    window = Toplevel()
    # window.geometry("450x300")
    window.title("Sistema de Información Bibliotecario")
    start.iconify()

    def inicio():
        start.deiconify()
        window.destroy()

    def acerca():
        messagebox.showinfo(title="Acerca de",
        message="Autores:",
        detail="- Nelson Andrés Salinas Zapata\n- Luis Felipe Marín Buitrago")

    def aplicacion():
        messagebox.showinfo(title="Aplicación",
        message="Sistema de infomración Bibliotecario:",
        detail="Por medio de esta aplicación usted podrá tener un registro del material disponible y del estado de los préstamos.")

    #Manejo de menús
    window.option_add('*tearOff', False)
    menubar = Menu(window)

    archivo = Menu(menubar)
    menubar.add_cascade(menu=archivo, label='Archivo')
    archivo.add_command(label="Aplicación", command=aplicacion)
    archivo.add_command(label="Salir", command=inicio)

    procesos = Menu(menubar)
    menubar.add_cascade(menu=procesos, label='Procesos y Consultas')
    procesos.add_command(label="Proceso 1")
    procesos.add_command(label="Proceso 2")

    ayuda = Menu(menubar)
    menubar.add_cascade(menu=ayuda, label ="Ayuda")
    ayuda.add_command(label="Acerca de", command=acerca)

    window['menu'] = menubar


    #Frame inicial
    principal = Frame(master=window,width=450,height=300)
    Label(master=principal,text="Sistema de Información\n Bibliotecario (SIB)",
    font=("Georgia",20)).place(x=70,y=0)
    texto = Text(principal, font=("Georgia",10),width=42,height=9,relief=GROOVE, borderwidth=4)
    
    texto.insert(1.0,"Mediante esta aplicación usted podrá realizar los siguientes \nprocesos:\n\n"+
    "1. Proceso 1\n"+
    "2. Proceso 2\n"+
    "3. Proceso 3\n\n"+
    "Para acceder a estas funcionalidades despliegue el menú de \n'Procesos y Consultas' y haga click en una opción")
    texto.place(x=32,y=110)
    principal.pack()