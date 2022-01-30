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

label1 = Label(p3,text="Bienvenido al \nSistema de Información Bibliotecario")
label1.pack()

#p4
p4 = Frame(master=frameA,width=250,height=400,bg="yellow")
p4.pack(side=BOTTOM)

labelimagen = Label(p4)
imagen = PhotoImage(file="imagen1.png",width=200,height=200)
labelimagen['image'] = imagen

labelimagen.pack()




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
p6.pack(side=BOTTOM)







StartWindow.mainloop()