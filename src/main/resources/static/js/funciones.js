function eliminar(id){
	swal({
  title: "Estas seguro de ELIMINAR?",
  text: "Una vez eliminado, ¡no podra recuperar el usuario!",
  icon: "ADVERTENCIA",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"/eliminar/"+id,
		success: function(res){
			console.log(res);
		}
	});
    swal("Poof! El usuario a sido eliminado!", {
      icon: "exitosamente",
    }).then((ok)=>{
	if(ok){
		location.href="/listar";
	}
});
  } else {
    swal("El usuario esta a salvo!");
  }
});
}

function eliminarAsistencia(id){
	swal({
  title: "Estas seguro de ELIMINAR?",
  text: "Una vez eliminado, ¡no podra recuperar el usuario!",
  icon: "ADVERTENCIA",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"/eliminar/"+id,
		success: function(res){
			console.log(res);
		}
	});
    swal("Poof! El usuario a sido eliminado!", {
      icon: "exitosamente",
    }).then((ok)=>{
	if(ok){
		location.href="/listarAsistencias";
	}
});
  } else {
    swal("El usuario esta a salvo!");
  }
});
}