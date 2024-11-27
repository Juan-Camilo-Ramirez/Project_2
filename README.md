# **Sistema de gestión de rutas de vuelos para un aeropuerto**

## 1. **Descripción del Proyecto:**

Este proyecto es una apliación de escritorio desarrollada en Java, la cuál tiene como objetivo
ayudar con la gestión de rutas internacionales para un aeropuerto. Los usuarios, en este caso los
administradores y/o trabajadores de la torre de control del aeropuerto pueden realizar diferentes funciones como;
agregar, despachar, reprogramar y cancelar vuelos, observando en tiempo real los vuelos que se gestionan, así mismo
almacenar la información de los vuelos cancelados y
despachados para así mismo poder generar un informe de los mismos para llevar un respectivo control.

#### **Lenguaje de programación y framework utilizados:**

**° Lenguaje de programación:** en este caso para el desarrollo de la aplicación es **JAVA en su versión 21**

**° Framework Utilizado:** Swing, la cual se utiliza para la interfaz gráfica de usuario.

## 2. **Requisitos para la instalación y ejecución del código:**

**° Java Development Kit (JDK):** Como primer paso debemos tener instalado el JDK, en caso de no tenerlo instalado
se procede a instalarlo desde el sitio oficial de Oracle o de OpenJDK, como recomendación no usar una versión
tan nueva porque esta puede presentar muchos errrores.

**° Entorno de Desarrollo Integrado (IDE):** Como segundo paso tener intalado el IDE, en caso de no tenerlo
instalado se procede a descargar un Ide adecuado para desarrollar JAVA, los más usados son Intellij IDEA, Eclipse o
NetBeans.

## 3. **Instrucciones de como instalar y ejecutar el programa:**

3.1 Se debe cumplir con los requisitos expresados en el punto anterior (Punto 2).

3.2 Se procede a copiar este repositorio de forma local en el equipo en el que se desea ejecutar el programa.

3.3 Luego de tenerlo copiado procedemos a abrir nuestro IDE de preferencia o el
que se ha descargado.

3.4 Estando en el IDE seleccionamos abrir un proyecto y buscamos la carpeta del proyecto que
previamente habiamos copiado del repositorio. Lo cual deberia quedar algo parecido a lo siguiente:

GestionVuelos (Project Root)

├── src

│ ├── Nodo.java

│ ├── GestionVuelosGUI.java

│ ├── Vuelo.java

│ └── ArbolBinarioBusqueda.java

└── .idea (IDE Settings)

3.5 Por último para ejecutar de manera correcta, hacemos click en la clase **GestionVuelosGUI**, estando allí deberiamos
observar el botón de iniciar, hacemos click ahi y si todo salió bien aparecerá la interfaz gráfica donde podemos hacer
la gestión de los vuelos.

## 4. **Funcionalidades del sistema:**

**- Agregar Vuelo:** Permite agregar vuelos con detalles como hora de salida, aerolínea y destino.

**- Despachar Vuelo:** Despacha el siguiente vuelo programado y lo mueve al historial de vuelos despachados.

**- Reprogramar Vuelo:** Reprograma un vuelo existente cambiando su hora de salida y destino.

**- Cancelar Vuelo:** Cancela un vuelo basado en la aerolínea y destino, y lo mueve al historial de vuelos cancelados.

**- Mostrar Historial:** Muestra el historial de vuelos despachados y cancelados en un cuadro de diálogo.

##### **Ejemplo de Uso:**

**¬ Agregar Vuelo:** El usuario ingresa la hora de salida, selecciona la aerolínea y destino desde menús desplegables, y
presiona el botón "Agregar Vuelo".

**¬ Despachar Vuelo:** El usuario presiona el botón "Despachar Siguiente Vuelo" para despachar el próximo vuelo
programado.

**¬ Reprogramar Vuelo:** El usuario selecciona una aerolínea y puede cambiar la hora de salida y destino del vuelo.

**¬ Cancelar Vuelo:** El usuario selecciona la aerolínea y el destino del vuelo que desea cancelar.

## 5. **Prueba del código:**
#### **Ejecución del codigo**
https://github.com/user-attachments/assets/6449ba2d-f2d8-4902-8f12-1899692bd960
