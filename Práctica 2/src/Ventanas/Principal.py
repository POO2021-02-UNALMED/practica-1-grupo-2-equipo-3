from tkinter import *

def ingreso(start):
    window = Toplevel()
    window.title("Sistema de Información Bibliotecario")
    start.iconify()

    def inicio():
        start.deiconify()
        window.destroy()

    window.option_add('*tearOff', False)
    menubar = Menu(window)

    archivo = Menu(menubar)
    menubar.add_cascade(menu=archivo, label='Archivo')
    archivo.add_command(label="Aplicación")
    archivo.add_command(label="Salir", command=inicio)

    procesos = Menu(menubar)
    menubar.add_cascade(menu=procesos, label='Procesos y Consultas')
    procesos.add_command(label="Proceso 1")
    procesos.add_command(label="Proceso 2")

    ayuda = Menu(menubar)
    menubar.add_cascade(menu=ayuda, label ="Ayuda")
    ayuda.add_command(label="Acerca de")

    window['menu'] = menubar