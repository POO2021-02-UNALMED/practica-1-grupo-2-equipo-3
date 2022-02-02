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

def ingreso(start):
    window = Toplevel()
    # window.geometry("450x300")
    window.title("Sistema de Información Bibliotecario")
    start.iconify()

    # Archivos para deserializar
    r_estanterias = open('src/baseDatos/estanterias','rb')
    Estanteria.setLista(pickle.load(r_estanterias))
    r_estanterias.close()

    r_autores = open('src/baseDatos/autores','rb')
    Autor.setAutores(pickle.load(r_autores))
    r_autores.close()

    r_publicaciones = open('src/baseDatos/publicaciones','rb')
    Publicacion.setLista(pickle.load(r_publicaciones))
    r_publicaciones.close()

    r_libros = open('src/baseDatos/libros','rb')
    Libro.setLibro(pickle.load(r_libros))
    r_libros.close()

    r_revistas = open('src/baseDatos/revistas','rb')
    Revista.setRevista(pickle.load(r_revistas))
    r_revistas.close()
    
    r_folletos = open('src/baseDatos/folletos','rb')
    Folleto.setFolleto(pickle.load(r_folletos))
    r_folletos.close()

    r_usuarios = open('src/baseDatos/usuarios','rb')
    Usuario.setUsuarios(pickle.load(r_usuarios))
    r_usuarios.close()


    def inicio():
        # Archivos para serializar
        w_estanterias = open('src/baseDatos/estanterias','wb')
        pickle.dump(Estanteria.getLista(),w_estanterias)
        w_estanterias.close()

        w_autores = open('src/baseDatos/autores','wb')
        pickle.dump(Autor.getAutores(),w_autores)
        w_autores.close()

        w_publicaciones = open('src/baseDatos/publicaciones','wb')
        pickle.dump(Publicacion.getLista(),w_publicaciones)
        w_publicaciones.close()

        w_libros = open('src/baseDatos/libros','wb')
        pickle.dump(Libro.getLibro(),w_libros)
        w_libros.close()

        w_folletos = open('src/baseDatos/folletos','wb')
        pickle.dump(Folleto.getFolleto(),w_folletos)
        w_folletos.close()

        w_revistas = open('src/baseDatos/revistas','wb')
        pickle.dump(Revista.getRevista(),w_revistas)
        w_revistas.close()

        w_usuarios = open('src/baseDatos/usuarios','wb')
        pickle.dump(Usuario.getUsuarios(),w_usuarios)
        w_usuarios.close()

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