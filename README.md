# Descripción

Este proyecto es un conversor de tasas de cambio que consume datos de una API externa para proporcionar tasas de conversión actualizadas entre diferentes monedas. Está desarrollado en Java y utiliza la biblioteca Gson para parsear el JSON devuelto por la API.

Características

Conexión con la API de tasas de cambio (Exchange Rate API o APILayer).

Soporte para tasas de cambio de monedas comunes como USD, EUR, y MXN.

Manejo de respuestas JSON mediante la librería Gson.

Sistema modular que permite fácilmente agregar nuevas monedas.

Requisitos previos

JDK 17 o superior.

Un entorno de desarrollo como IntelliJ IDEA o Eclipse.

Una API Key válida de Exchange Rate API o APILayer.

Maven configurado en el proyecto para gestionar dependencias.

Configuración

1. Clonar el repositorio

Clona el repositorio en tu máquina local:

$ git clone <URL-del-repositorio>
$ cd <nombre-del-proyecto>

2. Configurar la dependencia Gson

Asegúrate de que la dependencia de Gson esté en el archivo pom.xml si estás usando Maven:

<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.8</version>
</dependency>

Si no utilizas Maven, descarga el archivo JAR de Gson desde su repositorio oficial y agrégalo manualmente al proyecto.

3. Configurar la API Key

Reemplaza your_api_key_here en el archivo ExchangeRateConverter.java con tu API Key válida:

String apiKey = "your_api_key_here";

4. Ejecutar el programa

Ejecuta el archivo Main.java en tu IDE preferido o desde la línea de comandos:

$ javac Main.java
$ java Main

Estructura del proyecto

ExchangeRateConverter.java: Clase principal que realiza la conexión con la API y procesa las tasas de cambio.

Main.java: Punto de entrada para el programa.

Ejemplo de salida

Al ejecutar el programa, obtendras una salida como la siguiente:

Base currency: USD
Date: 2025-01-03
Rates:
USD: 1.0
EUR: 0.93
MXN: 18.23

Posibles errores y soluciones

Error 401

Causa: Problemas de autenticación con la API.

Solución: Verifica que la API Key sea válida y esté correctamente configurada.

Error 429

Causa: Exceso de solicitudes permitido por el plan gratuito.

Solución: Reduce la frecuencia de las solicitudes o actualiza a un plan pago.

Otros errores

Verifica la documentación oficial de la API y asegúrate de que la estructura del JSON no haya cambiado.
