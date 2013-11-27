#!/usr/bin/env python
import matplotlib.pyplot as plt
import sys
fo = open(sys.argv[1], "rw+")
data=[i.split(",") for i in fo.readlines()]
print data
x=[i[0] for i in data]
y=[i[1] for i in data]
plt.plot(x,y,'ro-')
print "Guardando Imagen en grafica.jpg"
plt.savefig('grafica.jpg')

