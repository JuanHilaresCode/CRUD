<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Detalles de la Ruta</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Detalles de la Ruta</h1>
    <c:choose>
        <c:when test="${not empty ruta}">
            <table class="table table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>ORIGEN</th>
                    <th>DESTINO</th>
                    <th>DISTANCIA (KM)</th>
                    <th>DURACION (En Minutos)</th>
                    <th>DESCRIPCION</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${ruta.route_id}</td>
                    <td>${ruta.origin}</td>
                    <td>${ruta.destination}</td>
                    <td>${ruta.distance}</td>
                    <td>${ruta.duration_in_minutes}</td>
                    <td>${ruta.description}</td>
                    <td>${ruta.status}</td>
                </tr>
                </tbody>
            </table>
            <a href="index.jsp" class="btn btn-primary">Regresar al Inicio</a>
            <a href="ContGetAll" class="btn btn-success">Ir a Lista de Rutas</a>
        </c:when>
        <c:otherwise>
            <p class="alert alert-warning">La ruta no fue encontrada.</p>
        </c:otherwise>
    </c:choose>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
