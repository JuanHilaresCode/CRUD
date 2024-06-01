// Función para rellenar automáticamente si la descripción está vacía o es opcional
function validarDescripcion() {
    var descripcionInput = document.getElementById("descripcionInput");
    if (descripcionInput.value.trim() === "") {
        descripcionInput.value = "NINGUNO";
    }
}
document.querySelector("form").addEventListener("submit", validarDescripcion);

// Función para evitar que origen y destino sean iguales
document.getElementById("formulariovalidacion").onsubmit = function() {
    var origen = document.getElementById("origenInput").value;
    var destino = document.getElementById("destinoInput").value;

    if (origen === destino) {
        alert("El origen y el destino no pueden ser iguales.");
        return false; // Evita que el formulario se envíe
    }
};