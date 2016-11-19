# Certamen3 2016 2, Pregunta 1

El objetivo de esta pregunta es, en primera instancia, hacer un refactor del código usando el patrón MVP (Modelo Vista Presentador) 
visto en clases.

En segunda instancia, se puede apreciar que la app es una lista de feeds de noticias. Si usted le da click al título de
la noticia, se abre un webview con el link de la noticia. Lo que se debe hacer es lo siguiente:

	1) En la esquina superior derecha, se aprecia un botón que dice "Agregar a favoritos". Actualmente no tiene mayor funcionalidad más que cambiar el estado del botón. Lo que se debe hacer, al momento de presionar el botón "Agregar a favoritos" es agregar este ítem a una base de datos local. Una vez que se agregue, el botón cambia su estado y dice "Agregado". En este caso, si se hace click, lo que se debe hacer es QUITAR este elemento de la base de datos, y cambiar el estado del ítem para que el botón cambie a "Agregar a favoritos".
	2) Una vez hecho lo anterior, se debe crear una activity que cargue los elementos guardados en la base de datos como una lista, tal cual en la pantalla principal. Para acceder a esta pantalla, se presiona en el menú superior derecho del toolbar, en el ítem "Mis Favoritos".

