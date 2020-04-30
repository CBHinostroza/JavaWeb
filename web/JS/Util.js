
function alerta()
{
   
    var opcion = confirm("¿Seguro que desea eliminar?");
    if (opcion) { //Si la opcion es aceptar retorna true
        return true; 
    } else {
       return false; //Si la opcion es cancelar retorna false
    }

}
