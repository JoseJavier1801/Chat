<h1>App mensajería instantania</h1>
En este artículo, voy a presentarles un proyecto que he realizado para la asignatura de Acceso a Datos, que consiste en una aplicación de mensajería sincronizada hecha en Java, JavaFX y Jaxb para xml.

La aplicación permite que dos o más usuarios puedan enviar y recibir mensajes entre sí dentro del mismo sistema, de forma que los mensajes se almacenan en un archivo xml y se actualizan automáticamente en las interfaces gráficas de los usuarios. Para ello, he utilizado las siguientes tecnologías:

- Java: el lenguaje de programación con el que he desarrollado la lógica de la aplicación, utilizando el paradigma orientado a objetos y el patrón de diseño MVC (Modelo-Vista-Controlador).<br><img src="https://th.bing.com/th/id/R.711f654d966e29da576399cc8d873a9e?rik=Pr7JzWIodBWV2Q&pid=ImgRaw&r=0" width="100"></img><br>
- JavaFX: el framework de Java para crear interfaces gráficas de usuario, con el que he diseñado la ventana principal de la aplicación, que muestra la lista de contactos, los mensajes enviados y recibidos, y un campo para escribir y enviar nuevos mensajes.
- Jaxb: la librería de Java para trabajar con archivos xml, con la que he creado las clases que representan los elementos del archivo xml donde se guardan los mensajes, y los métodos para leer y escribir en dicho archivo.

<h2>Funcionamiento de la aplicación</h2>

El funcionamiento de la aplicación es el siguiente:

- Al iniciar la aplicación, se pide al usuario que introduzca su nombre, que será el identificador que utilizará para enviar y recibir mensajes.
- A continuación, se muestra la ventana principal de la aplicación, donde se puede ver la lista de chats disponibles, que son los que se hayan creado previamente.
- Al seleccionar un chat, se muestra el historial de mensajes entre los usuarios de la aplicacion. También se muestra un campo para escribir y enviar un nuevo mensaje al contacto.
- Al enviar un mensaje, se añade al archivo xml donde se guardan los mensajes, y se actualiza la interfaz gráfica del usuario actual y del usuario destinatario, mostrando el nuevo mensaje en el historial.
- Al recibir un mensaje, se lee del archivo xml donde se guardaron los mensajes, y se actualiza la interfaz gráfica del usuario actual y del contacto remitente, mostrando el nuevo mensaje en el historial.

La aplicación es un ejemplo de cómo utilizar Java, JavaFX y Jaxb para crear una aplicación de mensajería sincronizada, que cumple con los requisitos de la asignatura de Acceso a Datos en una fecha estimada de 2 semanas. Espero que les haya gustado y les sirva de inspiración para sus propios proyectos.

<h2>Diagrama de clases</h2>
<img src="https://github.com/luishidalgoa/App-mensajer-a-ACD/blob/main/Diagrama.jpg" ></img>


<h2>Instalación</h2>

<ol>
  <li>Descargue el archivo rar que estara disponible en Relased</li>
  <li>Ejecute el archivo 'Execute.bat'</li>
  <li>¡Disfruta!</li>
</ol>
