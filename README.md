# Tarea ARSW Inter (HttpServer Concurrente que lee imagenes, js, css y html)

## Autor
**Julian Adolfo Peña Marin**

## Descripcion
La aplicacion es una version del servidor http realizado anteriormente pero esta vez se hizo que fuera un servisor concurrente, que devuelve archivos con extensiones css que son archivos de estilo, extensiones "js" que son archivos javascript, extensiones "html" que muestra como tal una pagina web y una imagen.

Adicionalmente la aplicacion esta desplegada en Heroku, para esto se creo un archivo llamado Procfile, para que heroku entendiera que era una aplicacion web.

## Documentacion
Para obtener la documentacion del proyecto, con el siguiente comando se puede generar:

```
    mvn javadoc:javadoc
```

## Como Correrlo
Primero se debe clonar el repositorio, para esto puede utilizar el siguiente comando de git, con la url del repositorio que se quiere clonar, como se muestra a continuación

```
    git clone https://github.com/JulianP-24/Tarea-Servidor-Web-Concurrente-Arsw-Inter.git
```

Una vez clonado para generar el JAR, debe poner el siguiente comando

```
    mvn package
```

Despues puede correrlo con el siguiente comando, ubicandose en la carpeta raiz
```
    java -cp "./target/classes/" edu.escuelaing.arsw.app.TareaHttpServerBrowser.httpServerBrowser
```

Otra forma para correrlo, ya generado el JAR, es con el siguiente comando

```
    java -cp "target/TareaServidorWebConcurrente-1.0-SNAPSHOT.jar" edu.escuelaing.arsw.app.TareaHttpServerBrowser.httpServerBrowser
```

## Link Heroku

Link: https://cryptic-castle-98984.herokuapp.com/

## Funcionamiento de la Aplicacion en Heroku

Para verificar el funcionamiento de la aplicacion en Heroku, solo se accede al link de heroku, mostrado anteriormente, como se muestra a continuacion:

Para devolver el html, en el siguiente link

```
    https://cryptic-castle-98984.herokuapp.com/
```

Como resultado se obtiene, el mensaje de javascript que es una alerta como se muestra en la siguiente imagen

![](img/imgHtmlJs.png)

Y despues muestra la pagina html con el css aplicado, como se ve en la siguiente imagen

![](img/herokuHtml.png)

Para devolver el js, en el siguiente link

```
    https://cryptic-castle-98984.herokuapp.com/index.js
```
Como resultado se obtiene

![](img/herokuJs.png)

Para devolver el css, en el siguiente link

```
    https://cryptic-castle-98984.herokuapp.com/style.css
```
Como resultado se obtiene

![](img/img3.png)

Para devolver la imagen, en el siguiente link

```
    https://cryptic-castle-98984.herokuapp.com/valorant.png
```
Como resultado se obtiene

![](img/img1.png)



## Diagrama de Clases
A continuacion se presenta el diagrama de clases de la arquitectura para la tarea propuesta

![](img/diagramaClases.png)

Como se puede observar la arquitectura se encuentra dentro de tres paquetes, el primero de ellos es el paquete con nombre app, el cual es el principal y en donde estan contenidos los otros dos, el segundo paquete es el que tiene como nombre TareaHttpServerBrowser, el cual tiene la clase principal y otra clase de nombre RequestProcessor que implementa Runnable y trabaja como un hilo atendiendo las conexiones y otro paquete de nombre Reader. En la clase principal se tiene el metodo main , que es donde esta la implementacion del servidor y en donde instancia la clase RequestProcesor, quien es la que se encarga de verificar el tipo de archivo que llega en el path, para despues llamar a uno de los metodos de la clase que esta en el paquete Reader para obtener el resultado correcto.

## Built con

* [Maven](https://maven.apache.org/) - Dependency Management
* [JAVA JDK 8](http://www.oracle.com/technetwork/java/javase/overview/index.html) - construcción


## Licencia

This project is licensed under the GNU General Public License - see the [LICENSE](LICENSE) file for details
