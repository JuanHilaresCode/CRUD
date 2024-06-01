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
            <form action="ContActualizar" method="post" id="formulariovalidacion">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="origenInput">Origen:</label>
                        <select class="form-control border border-4" id="origenInput" type="text" name="origen" required>
                            <option ${ruta.origen eq 'Cañete' ? 'selected' : ''}>Cañete</option>
                            <option ${ruta.origen eq 'Piura' ? 'selected' : ''}>Piura</option>
                            <option ${ruta.origen eq 'Lunahuana' ? 'selected' : ''}>Lunahuana</option>
                            <option ${ruta.origen eq 'San Luis' ? 'selected' : ''}>San Luis</option>
                            <option ${ruta.origen eq 'Lima' ? 'selected' : ''}>Lima</option>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="destinoInput">Destino:</label>
                        <select class="form-control border border-4" id="destinoInput" type="text" name="destino" required>
                            <option ${ruta.destino eq 'Cañete' ? 'selected' : ''}>Cañete</option>
                            <option ${ruta.destino eq 'Piura' ? 'selected' : ''}>Piura</option>
                            <option ${ruta.destino eq 'Lunahuana' ? 'selected' : ''}>Lunahuana</option>
                            <option ${ruta.destino eq 'San Luis' ? 'selected' : ''}>San Luis</option>
                            <option ${ruta.destino eq 'Lima' ? 'selected' : ''}>Lima</option>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="distanciaInput">Distancia (km):</label>
                        <input type="text" id="distanciaInput" name="distancia" class="form-control border border-4" value="${ruta.distancia}" pattern="\d+(\.\d+)?" title="Ingrese una distancia válida en km" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="duracionInput">Duracion (hrs):</label>
                        <input type="text" id="duracionInput" name="duracion" class="form-control border border-4" value="${ruta.duracion}" pattern="\d+(\.\d+)?" title="Ingrese una duración válida en horas" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="descripcionInput">Descripción (OPCIONAL):</label>
                        <input type="text" id="descripcionInput" name="descripcion" class="form-control border border-4" value="${ruta.descripcion}">
                    </div>
                </div>
                <input type="hidden" name="id" value="${ruta.id}">
                <button type="submit" class="btn btn-primary">Actualizar</button>
                <a href="ContGetAll" class="btn btn-danger">Volver</a>
            </form>
        </div>
    </div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="JavaScript/editarRuta.js"></script>
</body>
</html>
