from doctest import master
from textwrap import fill
from tkinter import *
from turtle import left

StartWindow = Tk()
#StartWindow.geometry("500x400")
StartWindow.title("Ventana de Inicio")

# Manejo del menú
StartWindow.option_add('*tearOff', False)
menubar = Menu(StartWindow)
inicio = Menu(menubar)
menubar.add_cascade(menu=inicio, label='Inicio')
inicio.add_command(label="Descripción")
inicio.add_command(label="Salir")

StartWindow['menu'] = menubar


# Manejo de frames
frameA = Frame(master=StartWindow)
frameA.pack(side=LEFT)

frameB = Frame(master=StartWindow)
frameB.pack(side=RIGHT)

#p3
p3 = Frame(master=frameA,width=250,height=200,bg="red")
p3.pack(side=TOP)

label1 = Label(p3,text="Bienvenido al\nSistema de Información\nBibliotecario")
label1.pack()

#p4





p4 = Frame(master=frameA,width=250,height=400,bg="yellow")
p4.pack(side=BOTTOM)

labelimagen = Label(p4)
imagen = PhotoImage(file="Imagenes/imagen1.png")
labelimagen['image'] = imagen
labelimagen.pack()

ingresar = Button(p4,text="Ingresar al Sistema")
ingresar.pack()




#p5
p5 = Frame(master=frameB,width=250,height=200,bg="green")
p5.pack(side=TOP)

hojavida = Text(p5, font="Georgia")
hojavida.insert(INSERT,"Desarrollador:\n\n\
Nombre: Nelson Andrés Salinas Zapata\n\
Profesión: Estudiante de Pregrado\n\
Carrera: Ingeniería de Sistemas e Informática\n\
Institución: Universidad Nacional de Colombia sede Medellín")
hojavida.pack()



#p6
p6 = Frame(master=frameB,width=250,height=400,bg="blue")


framefoto1 = Frame(master=p6)

labelfoto1 = Label(framefoto1)
foto1 = PhotoImage(file="Imagenes/foto1.png")
labelfoto1['image'] = foto1
labelfoto1.pack()
framefoto1.grid(row=1,column=1)


framefoto2 = Frame(master=p6)

labelfoto2 = Label(framefoto2)
foto2 = PhotoImage(file="Imagenes/foto1.png")
labelfoto2['image'] = foto2
labelfoto2.pack()
framefoto2.grid(row=1,column=2)

framefoto3 = Frame(master=p6)

labelfoto3 = Label(framefoto3)
foto3 = PhotoImage(file="Imagenes/foto1.png")
labelfoto3['image'] = foto3
labelfoto3.pack()
framefoto3.grid(row=2,column=1)

framefoto4 = Frame(master=p6)

labelfoto4 = Label(framefoto4)
foto4 = PhotoImage(file="Imagenes/foto1.png")
labelfoto4['image'] = foto4
labelfoto4.pack()
framefoto4.grid(row=2,column=2)


p6.pack(side=BOTTOM)


StartWindow.mainloop()