// Función para rellenar automáticamente si la description esta vacia
function validarDescripcion() {
    var descripcionInput = document.getElementById("descripcionInput");
    if (descripcionInput.value.trim() === "") {
        descripcionInput.value = "NINGUNO";
    }
}
document.querySelector("form").addEventListener("submit", validarDescripcion);

// Funcion para validar la description
document.getElementById("descripcionInput").addEventListener("input", function() {
    var descripcionInput = document.getElementById("descripcionInput").value;
    var descripcionPattern = /^[A-Za-z\sáéíóúÁÉÍÓÚñÑ.,:;"'()\-]+$/;
    if (!descripcionPattern.test(descripcionInput)) {
        alert("La descripción solo puede contener letras y caracteres especiales.");
        document.getElementById("descripcionInput").value = "";
    }
});

// Funcion para evitar que origin y destination no sean iguales
document.getElementById("formulariovalidacion").onsubmit = function() {
    var origen = document.getElementById("origenInput").value;
    var destino = document.getElementById("destinoInput").value;

    if (origen === destino) {
        alert("El origin y el destination no pueden ser iguales.");
        return false; // Evita que el formulario se envíe
    }
};