from cProfile import label
from distutils import command
from tkinter import *

start = Tk()
start.geometry("300x150")
start.title("Prueba con Menús")

def des():
    sub_menu.destroy()
    pass

def color():
    start.config(bg='blue')

# Crear a menubar
start.option_add('*tearOff', False)

menubar = Menu(start)
start['menu'] = menubar
# start.config(menu=menubar)

file_menu = Menu(menubar,bg="blue")

file_menu.add_command(label="New")
file_menu.add_command(label="Open...")
file_menu.add_command(label="Close")
file_menu.add_separator()

#Submenu
sub_menu = Menu(file_menu)
sub_menu.add_command(label="Keyboard Shortcuts",command=des)

# add de sub_men to the file_menu
file_menu.add_cascade(label="Prefernces",menu=sub_menu)
# file_menu.add(menu=sub_menu)


menubar.add_cascade(label="File",menu=file_menu)



# file_menu.add_cascade(label="Preferencies",menu=sub_menu)



# menubar.add









start.mainloop()