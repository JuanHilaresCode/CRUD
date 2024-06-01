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
</head>
<body>
<div class="container centered-form">
    <div class="card">
        <div class="card-body">
            <h1 class="card-title">Crear Nueva ruta</h1>
            <form action="ContCrear" method="post">
                <div class="form-group">
                    <label for="origenInput">Origen:</label>
                    <input type="text" id="origenInput" name="origen" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="destinoInput">Destino:</label>
                    <input type="text" id="destinoInput" name="destino" class="form-control"required>
                </div>
                <div class="form-group">
                    <label for="distanciaInput">Distancia:</label>
                    <input type="text" id="distanciaInput" name="distancia" class="form-control"required>
                </div>
                <div class="form-group">
                    <label for="duracionInput">Duración:</label>
                    <input type="text" id="duracionInput" name="duracion" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="descripcionInput">Descripción:</label>
                    <input type="text" id="descripcionInput" name="descripcion" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="estadoInput">Estado:</label>
                    <input type="text" id="estadoInput" name="estado" class="form-control" value="1" readonly>
                </div>
                <button type="submit" class="btn btn-primary">Crear</button>
                <a href="index.jsp" class="btn btn-danger">Volver</a>
            </form>
        </div>
    </div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
