import os
import pickle
## GUI
from tkinter import *
from functools import partial
from Ventanas.Principal import Principal
##

## Objetos
from gestorAplicacion.obras.Estanteria import Estanteria
from gestorAplicacion.obras.Folleto import Folleto
from gestorAplicacion.obras.Libro import Libro
from gestorAplicacion.obras.Publicacion import Publicacion
from gestorAplicacion.obras.Revista import Revista
from gestorAplicacion.personas.Autor import Autor
from gestorAplicacion.personas.Usuario import Usuario
from gestorAplicacion.obras.Publicacion import Estado
##

if __name__ == "__main__":

    # Creación de archivos que no existan
    if not os.path.exists("baseDatos/estanterias"):
        w = open('baseDatos/estanterias','wb')
        pickle.dump(Estanteria.getLista(),w)
        w.close()

    if not os.path.exists("baseDatos/autores"):
        w = open('/baseDatos/autores','wb')
        pickle.dump(Autor.getAutores(),w)
        w.close()

    if not os.path.exists("baseDatos/publicaciones"):
        w = open('/baseDatos/publicaciones','wb')
        pickle.dump(Publicacion.getLista(),w)
        w.close()

    if not os.path.exists("baseDatos/libros"):
        w = open('baseDatos/libros','wb')
        pickle.dump(Libro.getLibro(),w)
        w.close()

    if not os.path.exists("baseDatos/folletos"):
        w = open('baseDatos/folletos','wb')
        pickle.dump(Folleto.getFolleto(),w)
        w.close()

    if not os.path.exists("baseDatos/revistas"):
        w = open('baseDatos/revistas','wb')
        pickle.dump(Revista.getRevista(),w)
        w.close()

    if not os.path.exists("baseDatos/usuarios"):
        w = open('baseDatos/usuarios','wb')
        pickle.dump(Usuario.getUsuarios,w)
        w.close()
    #

    
    StartWindow = Tk()
    StartWindow.title("Ventana de Inicio")

    def descripcion():
        p3.pack_forget()
        label1.place_forget()
        desc = "Descripción:\n\nEste es un Sistema de Información\nbibliotecario por medio \
del cual se\npodrá tener un registro del material\ndisponible y del estado de los\npréstamos."
        label2 = Label(p3,text=desc, font=("Georgia",10))
        label2.place(x=6,y=10)
        p3.pack(side=TOP)

    # Manejo del menú
    StartWindow.option_add('*tearOff', False)
    menubar = Menu(StartWindow)
    inicio = Menu(menubar)
    menubar.add_cascade(menu=inicio, label='Inicio')
    inicio.add_command(label="Descripción", command=descripcion)
    inicio.add_command(label="Salir", command=StartWindow.destroy)

    StartWindow['menu'] = menubar


    # Manejo de frames
    frameA = Frame(master=StartWindow)
    frameA.pack(side=LEFT)

    #p3
    p3 = Frame(master=frameA,width=250,height=150,relief=GROOVE, borderwidth=4)
    p3.pack(side=TOP)

    label1 = Label(p3,text="Bienvenido al\nSistema de Información\nBibliotecario")
    label1.place(x=58,y=48)


    #p4
    imagen1 = PhotoImage(file="Ventanas/Imagenes/imagen1.png")
    imagen2 = PhotoImage(file="Ventanas/Imagenes/imagen2.png")
    imagen3 = PhotoImage(file="Ventanas/Imagenes/imagen3.png")
    imagen4 = PhotoImage(file="Ventanas/Imagenes/imagen4.png")
    imagen5 = PhotoImage(file="Ventanas/Imagenes/imagen5.png")

    # Estado incial del frame
    p4 = Frame(frameA,width=250,height=215)   
    label = Label(p4)
    label['image'] = imagen1
    label.place(x=25,y=20)
    
    ingresar = Button(p4,text="Ingresar al Sistema", command=partial(Principal().VentanaPrincipal,StartWindow))
    ingresar.place(x=68,y=170)
    p4.pack(side=BOTTOM)  

    def p4_1(e):
        p4.pack_forget()
        label['image'] = imagen1
        label.bind('<Enter>',p4_2)
        p4.pack(side=BOTTOM)   

    def p4_2(e):
        p4.pack_forget()
        label['image'] = imagen2
        label.bind('<Enter>',p4_3)
        p4.pack(side=BOTTOM)

    #Bind inicial
    label.bind('<Enter>',p4_2)

    def p4_3(e):
        p4.pack_forget()
        label['image'] = imagen3
        label.bind('<Enter>',p4_4)
        p4.pack(side=BOTTOM)

    def p4_4(e):
        p4.pack_forget()
        label['image'] = imagen4
        label.bind('<Enter>',p4_5)
        p4.pack(side=BOTTOM) 

    def p4_5(e):
        p4.pack_forget()
        label['image'] = imagen5
        label.bind('<Enter>',p4_1)
        p4.pack(side=BOTTOM) 

    

    frameB = Frame(master=StartWindow)
    
    #p5
    p5 = Frame(master=frameB,width=500,height=150)
    hojavida = Text(p5, font=("Georgia",12),width=45,height=7,relief=GROOVE, borderwidth=4)
    hojavida.insert(1.0,"Desarrollador 1:\n\
(Click en el texto para ver más desarrolladores)\n\n\
Nombre:       Nelson Andrés Salinas Zapata\n\
Profesión:     Estudiante de Pregrado\n\
Carrera:        Ingeniería de Sistemas e Informática\n\
Institución:  Universidad Nacional de Colombia sede Medellín")
    hojavida.place(x=20,y=5)
    p5.pack(side=TOP)

    frameB.pack(side=RIGHT)


    #p6
    p6 = Frame(master=frameB,width=250,height=400)

    foto1 = PhotoImage(file="Ventanas/Imagenes/foto1.png")  
    foto2 = PhotoImage(file="Ventanas/Imagenes/foto2.png")
    foto3 = PhotoImage(file="Ventanas/Imagenes/foto3.png")
    foto4 = PhotoImage(file="Ventanas/Imagenes/foto4.png")
    foto5 = PhotoImage(file="Ventanas/Imagenes/foto5.png")
    foto6 = PhotoImage(file="Ventanas/Imagenes/foto6.png")
    foto7 = PhotoImage(file="Ventanas/Imagenes/foto7.png")
    foto8 = PhotoImage(file="Ventanas/Imagenes/foto8.png")


    framefoto1 = Frame(master=p6)
    labelfoto1 = Label(framefoto1)
    labelfoto1['image'] = foto1
    labelfoto1.pack()
    framefoto1.grid(row=1,column=1)

    framefoto2 = Frame(master=p6)
    labelfoto2 = Label(framefoto2)
    labelfoto2['image'] = foto2
    labelfoto2.pack()
    framefoto2.grid(row=1,column=2)

    framefoto3 = Frame(master=p6)
    labelfoto3 = Label(framefoto3)
    labelfoto3['image'] = foto3
    labelfoto3.pack()
    framefoto3.grid(row=2,column=1)

    framefoto4 = Frame(master=p6)
    labelfoto4 = Label(framefoto4)
    labelfoto4['image'] = foto4
    labelfoto4.pack()
    framefoto4.grid(row=2,column=2)

    p6.pack(side=BOTTOM) 


    def frameB_1(e):
        hojavida.delete(1.0,8.0)
        hojavida.insert(1.0,"Desarrollador 1:\n\
(Click en el texto para ver más desarrolladores)\n\n\
Nombre:       Nelson Andrés Salinas Zapata\n\
Profesión:     Estudiante de Pregrado\n\
Carrera:        Ingeniería de Sistemas e Informática\n\
Institución:  Universidad Nacional de Colombia sede Medellín")
        hojavida.place(x=20,y=5)

        p6.pack_forget()
        labelfoto1['image']= foto1
        labelfoto2['image']= foto2
        labelfoto3['image']= foto3
        labelfoto4['image']= foto4
        p6.pack(side=BOTTOM)

        hojavida.bind('<ButtonPress-1>',frameB_2) 


    def frameB_2(e):
        hojavida.delete(1.0,8.0)
        hojavida.insert(1.0,"Desarrollador 2:\n\
(Click en el texto para ver más desarrolladores)\n\n\
Nombre:       Luis Felipe Marín Buitrago\n\
Profesión:     Estudiante de Pregrado\n\
Carrera:        Ingeniería de Sistemas e Informática\n\
Institución:  Universidad Nacional de Colombia sede Medellín")
        hojavida.place(x=20,y=5)

        p6.pack_forget()
        labelfoto1['image']= foto5
        labelfoto2['image']= foto6
        labelfoto3['image']= foto7
        labelfoto4['image']= foto8
        p6.pack(side=BOTTOM)

        hojavida.bind('<ButtonPress-1>',frameB_1) 


    #Bind inicial
    hojavida.bind('<ButtonPress-1>',frameB_2)



    StartWindow.mainloop()