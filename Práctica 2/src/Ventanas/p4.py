from tkinter import *

class Imagen(Frame):
    def __init__(self,window,img):
        super().__init__(window,width=250,height=400)

        label = Label(self)
        imagen = img
        ima = "imagen 1"
        label['image'] = imagen
        label.pack()
    