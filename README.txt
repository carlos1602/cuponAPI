Proyecto creado con Java - Maven y el framework de Springboot. 
El proyecto adem�s tiene instalado el programa Swagger para la documentaci�n y pruebas de la API.
Se modific� el proyecto Springboot para ser ejecutado en Servidor Apache, preferiblemente 9.0 y Java version 1.8.

1.Colocar el archivo .war en el servidor apache.

2. Reiniciar el servidor.

3. El serivicio se encuentra en la ruta http://localhost:8080/api/coupon
tiene los siguientes par�metros de entrada:

{
  "amount": 0,
  "itemIds": [
    "string"
  ]
}

4. Si se prefiere ejecutar la herramienta pruebas Swagger, ingresar a la direccion:

http://localhost:8080/swagger-ui.html