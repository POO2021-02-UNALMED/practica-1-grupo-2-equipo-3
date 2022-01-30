from tkinter import *
from p4 import Imagen

if __name__ == "__main__":
    StartWindow = Tk()
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
    imagen1 = PhotoImage(file="src/Ventanas/Imagenes/imagen1.png")
    imagen2 = PhotoImage(file="src/Ventanas/Imagenes/imagen2.png")
    imagen3 = PhotoImage(file="src/Ventanas/Imagenes/imagen3.png")
    imagen4 = PhotoImage(file="src/Ventanas/Imagenes/imagen4.png")
    imagen5 = PhotoImage(file="src/Ventanas/Imagenes/imagen5.png")


    '''
    p4 = Frame(master=frameA,width=250,height=400)
    p4.pack(side=BOTTOM)
 


    labelimagen = Label(p4)
    imagen = imagen1
    ima = "imagen 1"
    labelimagen['image'] = imagen
    labelimagen.pack()
    
    
    ingresar = Button(p4,text="Ingresar al Sistema")
    ingresar.pack()'''

    p4 = Imagen(frameA,imagen1)
    p4.pack(side=BOTTOM)






















    StartWindow.mainloop()