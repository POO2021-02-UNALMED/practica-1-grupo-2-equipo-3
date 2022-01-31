from tkinter import *

if __name__ == "__main__":
    StartWindow = Tk()
    StartWindow.title("Ventana de Inicio")

    # Manejo del menú
    StartWindow.option_add('*tearOff', False)
    menubar = Menu(StartWindow)
    inicio = Menu(menubar)
    menubar.add_cascade(menu=inicio, label='Inicio')
    inicio.add_command(label="Descripción")
    inicio.add_command(label="Salir", command=StartWindow.destroy)

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
    imagen1 = PhotoImage(file="src/Ventanas/Imagenes/imagen1.png")
    imagen2 = PhotoImage(file="src/Ventanas/Imagenes/imagen2.png")
    imagen3 = PhotoImage(file="src/Ventanas/Imagenes/imagen3.png")
    imagen4 = PhotoImage(file="src/Ventanas/Imagenes/imagen4.png")
    imagen5 = PhotoImage(file="src/Ventanas/Imagenes/imagen5.png")

    # Estado incial del frame
    p4 = Frame(frameA,width=250,height=200)   
    label = Label(p4)
    label['image'] = imagen1
    label.pack()

    ingresar = Button(p4,text="Ingresar al Sistema")
    ingresar.pack()
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


    #p5
    p5 = Frame(master=frameB)
    hojavida = Text(p5, font="Georgia",width=45,height=6)
    hojavida.insert(INSERT,"Desarrollador:\n\n\
Nombre:       Nelson Andrés Salinas Zapata\n\
Profesión:     Estudiante de Pregrado\n\
Carrera:        Ingeniería de Sistemas e Informática\n\
Institución:  Universidad Nacional de Colombia sede Medellín")
    hojavida.pack()
    p5.pack(side=TOP)



#p6
p6 = Frame(master=frameB,width=250,height=400,bg="blue")


framefoto1 = Frame(master=p6)

labelfoto1 = Label(framefoto1)
foto1 = PhotoImage(file="src/Ventanas/Imagenes/foto1.png")
labelfoto1['image'] = foto1
labelfoto1.pack()
framefoto1.grid(row=1,column=1)


framefoto2 = Frame(master=p6)

labelfoto2 = Label(framefoto2)
foto2 = PhotoImage(file="src/Ventanas/Imagenes/foto1.png")
labelfoto2['image'] = foto2
labelfoto2.pack()
framefoto2.grid(row=1,column=2)

framefoto3 = Frame(master=p6)

labelfoto3 = Label(framefoto3)
foto3 = PhotoImage(file="src/Ventanas/Imagenes/foto1.png")
labelfoto3['image'] = foto3
labelfoto3.pack()
framefoto3.grid(row=2,column=1)

framefoto4 = Frame(master=p6)

labelfoto4 = Label(framefoto4)
foto4 = PhotoImage(file="src/Ventanas/Imagenes/foto1.png")
labelfoto4['image'] = foto4
labelfoto4.pack()
framefoto4.grid(row=2,column=2)


p6.pack(side=BOTTOM)


StartWindow.mainloop()