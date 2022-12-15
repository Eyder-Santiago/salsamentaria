/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
$('document').ready(function (){
    /*usado en la vista ventas
     *  para que al presionar el btn con la clase edicion
     * reciba el json que genera dicho link y ponga la informacion,
     * en este caso el codigo en el id codigoEditar del modal editModal 
     * y lo muestre
     * */
    $('.edicion').on('click',function (event){
        event.preventDefault();
        var href=$(this).attr('href');
        $.get(href, function (producto,status){
            console.log("codigo producto: "+producto.codigo);
            $('#codigoEditar').val(producto.codigo);
            $('#unidadMedida').val(producto.unidadMedida);
        });
    $('#editModal').modal("show");    
    });
      
    if($('#triggerImpresion').hasClass('d-none')){//usado para identificar si existe el id 
        //triggerImpresion de manera que se visualiza si se comparte un codigo de venta generado
        //si es asi se muestra el modal con id modalImpresion
        $('#modalImpresion').modal("show");  
          
      }
});


