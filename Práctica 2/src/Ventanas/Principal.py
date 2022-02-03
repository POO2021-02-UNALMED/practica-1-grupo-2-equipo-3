# from distutils import command
from tkinter import *
from tkinter import messagebox
# from functools import partial
from Ventanas.registro import Frame1
from Ventanas.muestra import Frame2
from Ventanas.eliminacion import Frame3
from Ventanas.prestamo import Frame4
from Ventanas.devolucion import Frame5
import pickle

## Objetos
# from gestorAplicacion.obras.Estanteria import Estanteria
# from gestorAplicacion.obras.Folleto import Folleto
# from gestorAplicacion.obras.Libro import Libro
# from gestorAplicacion.obras.Publicacion import Publicacion
# from gestorAplicacion.obras.Revista import Revista
# from gestorAplicacion.personas.Autor import Autor
# from gestorAplicacion.personas.Usuario import Usuario
##

## Funciones
from baseDatos.Almacenamiento import serializar,deserializar
##

class Principal():
    frame1 = None
    frame2 = None
    frame3 = None
    frame4 = None
    frame5 = None
    
    def VentanaPrincipal(self,start):
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

        
        
        # Frames 
        principal = Frame(master=window,width=450,height=300) # Frame Interfaz de Inicio

        def ingresar():
            principal.pack_forget()
            if self.frame1 is None:
                if self.frame2 is not None:
                    self.frame2.destroy()
                if self.frame3 is not None:
                    self.frame3.destroy()
                if self.frame4 is not None:
                    self.frame4.destroy()  
                if self.frame5 is not None:
                    self.frame5.destroy() 
            else:
                if self.frame2 is not None:
                    self.frame2.destroy()
                if self.frame3 is not None:
                    self.frame3.destroy()
                if self.frame4 is not None:
                    self.frame4.destroy() 
                if self.frame5 is not None:
                    self.frame5.destroy() 
                self.frame1.destroy()        # destruyo lo que se haya creado para el frame1

            self.frame1 = Frame1(window) # Frame proceso 1
            self.frame1.pack()

        def mostrar():
            principal.pack_forget()
            if self.frame2 is None:
                if self.frame1 is not None:
                    self.frame1.destroy()
                if self.frame3 is not None:
                    self.frame3.destroy() 
                if self.frame4 is not None:
                    self.frame4.destroy() 
                if self.frame5 is not None:
                    self.frame5.destroy()  
            else:
                if self.frame1 is not None:
                    self.frame1.destroy()
                if self.frame3 is not None:
                    self.frame3.destroy()
                if self.frame4 is not None:
                    self.frame4.destroy() 
                if self.frame5 is not None:
                    self.frame5.destroy() 
                self.frame2.destroy()        # destruyo lo que se haya creado para el frame2

            self.frame2 = Frame2(window) # Frame proceso 2
            self.frame2.pack()

        def eliminar():
            principal.pack_forget()
            if self.frame3 is None:
                if self.frame1 is not None:
                    self.frame1.destroy()
                if self.frame2 is not None:
                    self.frame2.destroy()  
                if self.frame4 is not None:
                    self.frame4.destroy()
                if self.frame5 is not None:
                    self.frame5.destroy()  
            else:
                if self.frame1 is not None:
                    self.frame1.destroy()
                if self.frame2 is not None:
                    self.frame2.destroy()
                if self.frame4 is not None:
                    self.frame4.destroy()
                if self.frame5 is not None:
                    self.frame5.destroy()  
                self.frame3.destroy()        # destruyo lo que se haya creado para el frame3

            self.frame3 = Frame3(window) # Frame proceso 3
            self.frame3.pack()


        def prestar():
            principal.pack_forget()
            if self.frame4 is None:
                if self.frame1 is not None:
                    self.frame1.destroy()
                if self.frame2 is not None:
                    self.frame2.destroy() 
                if self.frame3 is not None:
                    self.frame3.destroy()
                if self.frame5 is not None:
                    self.frame5.destroy()    
            else:
                if self.frame1 is not None:
                    self.frame1.destroy()
                if self.frame2 is not None:
                    self.frame2.destroy()
                if self.frame3 is not None:
                    self.frame3.destroy()
                if self.frame5 is not None:
                    self.frame5.destroy() 
                self.frame4.destroy()        # destruyo lo que se haya creado para el frame4

            self.frame4 = Frame4(window) # Frame proceso 4
            self.frame4.pack()

        def entregar():
            principal.pack_forget()
            if self.frame5 is None:
                if self.frame1 is not None:
                    self.frame1.destroy()
                if self.frame2 is not None:
                    self.frame2.destroy() 
                if self.frame3 is not None:
                    self.frame3.destroy()
                if self.frame4 is not None:
                    self.frame4.destroy()    
            else:
                if self.frame1 is not None:
                    self.frame1.destroy()
                if self.frame2 is not None:
                    self.frame2.destroy()
                if self.frame3 is not None:
                    self.frame3.destroy()
                if self.frame4 is not None:
                    self.frame4.destroy() 
                self.frame5.destroy()        # destruyo lo que se haya creado para el frame5

            self.frame5 = Frame5(window) # Frame proceso 5
            self.frame5.pack()

    
        def pprincipal():
            if self.frame1 is not None:
                self.frame1.destroy()
            if self.frame2 is not None:
                self.frame2.destroy()
            if self.frame3 is not None:
                self.frame3.destroy()
            if self.frame4 is not None:
                    self.frame4.destroy() 
            if self.frame5 is not None:
                    self.frame5.destroy() 
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

        procesos.add_command(label="Ingresar Registros", command=ingresar)
        procesos.add_command(label="Mostrar Registros", command=mostrar)
        procesos.add_command(label="Eliminar Registros", command=eliminar)
        procesos.add_command(label="Préstamos", command=prestar)
        procesos.add_command(label="Devoluciones", command=entregar)
        procesos.add_separator()
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
        "1. Ingresar Registros\n"+
        "2. Mostrar Registros\n"+
        "3. Eliminar Registros\n"+
        "4. Registrar Préstamos\n"+
        "5. Resgitrar Devoluciones\n\n"+
        "Para acceder a estas funcionalidades despliegue el menú de \n'Procesos y Consultas' y haga click en una opción")
        texto.config(state=DISABLED)
        texto.place(x=32,y=110)
        principal.pack()