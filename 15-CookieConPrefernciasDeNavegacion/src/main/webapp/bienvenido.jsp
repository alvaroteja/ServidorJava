<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
        <link rel="stylesheet" href="style2.css" />
    </head>
    <body>
        <div class="contenedor">
            <p>Bienvenido "nombre"</p>
            <form action="recepcion" method="post">
                <input type="radio" id="espanol" name="idiomas" value="espanol" />
                <label for="espanol">Español</label>
                <input type="radio" id="ingles" name="idiomas" value="ingles" />
                <label for="ingles">Inglés</label>
                <input type="radio" id="frances" name="idiomas" value="frances" />
                <label for="frances">Francés</label>
                <input type="submit" value="Desconectar">
            </form>
            <p id="contador">Nº de visitas:<strong>"X"</strong></p>
        </div>
    </body>
</html>