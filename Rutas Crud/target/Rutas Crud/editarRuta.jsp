<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Actualizar Ruta</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-header">
            <h1 class="card-title">Actualizar Rutas</h1>
        </div>
        <div class="card-body">
            <form action="ContActualizar" method="post">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="origenInput">Origen:</label>
                        <input type="text" id="origenInput" name="origen" class="form-control border border-4" value="${ruta.origen}">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="destinoInput">Destino:</label>
                        <input type="text" id="destinoInput" name="destino" class="form-control border border-4" value="${ruta.destino}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="distanciaInput">Distancia:</label>
                        <input type="text" id="distanciaInput" name="distancia" class="form-control border border-4" value="${ruta.distancia}">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="duracionInput">Duración:</label>
                        <input type="text" id="duracionInput" name="duracion" class="form-control border border-4" value="${ruta.duracion}">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="descripcionInput">Descripción:</label>
                        <input type="text" id="descripcionInput" name="descripcion" class="form-control border border-4" value="${ruta.descripcion}">
                    </div>
                </div>
                <input type="hidden" name="id" value="${ruta.id}">
                <button type="submit" class="btn btn-primary">Actualizar</button>
                <a href="index.jsp" class="btn btn-danger">Volver</a>
            </form>
        </div>
    </div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
