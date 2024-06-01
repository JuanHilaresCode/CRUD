<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Ruta</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .centered-form {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
    </style>
    <script src="JavaScript/crearRuta.js"></script>
</head>
<body>
<div class="container centered-form">
    <div class="card">
        <div class="card-body">
            <h1 class="card-title">Crear Nueva Ruta</h1>
            <form action="ContCrear" method="post" id="formulariovalidacion">
                <div class="form-group">
                    <label for="origenInput">Origen:</label>
                    <select class="form-control" id="origenInput" type="text" name="origen" required>
                        <option>Cañete</option>
                        <option>Piura</option>
                        <option>Lunahuana</option>
                        <option>San Luis</option>
                        <option>Lima</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="destinoInput">Destino:</label>
                    <select class="form-control" type="text" id="destinoInput" name="destino" required>
                        <option>Cañete</option>
                        <option>Piura</option>
                        <option>Lunahuana</option>
                        <option>San Luis</option>
                        <option>Lima</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="distanciaInput">Distancia (km):</label>
                    <input type="text" id="distanciaInput" name="distancia" class="form-control" pattern="\d+(\.\d+)?" title="Ingrese una distancia válida en km" required>
                </div>
                <div class="form-group">
                    <label for="duracionInput">Duración (hrs):</label>
                    <input type="text" id="duracionInput" name="duracion" class="form-control" pattern="\d+(\.\d+)?" title="Ingrese una duración válida en horas" required>
                </div>
                <div class="form-group">
                    <label for="descripcionInput">Descripción (OPCIONAL):</label>
                    <input type="text" id="descripcionInput" name="descripcion" class="form-control">
                </div>
                <input type="hidden" id="estadoInput" name="estado" value="1">
                <button type="submit" class="btn btn-primary">Crear</button>
                <a href="ContGetAll" class="btn btn-danger">Volver</a>
            </form>
        </div>
    </div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="JavaScript/crearRuta.js"></script>
</body>
</html>