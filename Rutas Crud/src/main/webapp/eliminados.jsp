<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registros Eliminados</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container p-4">
    <div class="card">
        <div class="card-header">
            <h1 class="text-center">Registros Eliminados</h1>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead class="table-danger">
                    <tr class="text-center">
                        <th>ID</th>
                        <th>ORIGEN</th>
                        <th>DESTINO</th>
                        <th>DISTANCIA (KM)</th>
                        <th>DURACION (HRS)</th>
                        <th>DESCRIPCION</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${eliminados}" var="ruta">
                        <tr>
                            <td>${ruta.id}</td>
                            <td>${ruta.origen}</td>
                            <td>${ruta.destino}</td>
                            <td>${ruta.distancia}</td>
                            <td>${ruta.duracion}</td>
                            <td>${ruta.descripcion}</td>
                            <td>${ruta.estado}</td>
                            <td class="text-center">
                                <form action="ContRestaurar" method="post" style="display: inline;">
                                    <input type="hidden" name="id" value="${ruta.id}">
                                    <button type="submit" class="btn btn-success">Restaurar</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="text-center mt-3">
        <a href="index.jsp" class="btn btn-primary">Regresar al Inicio</a>
    </div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
