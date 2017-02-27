$(document).ready(function(){
	$.ajax({
		url:"api/laptops",
		type:'GET',
		dataType:"json",
		success:renderTable});
	
})
function renderTable(data){
	$.each(data,function(index,laptop){
		$('#laptop-tbody').
		append('<tr><td>'+laptop.manufacturer+'</td><td>'
				+laptop.lmodel+'</td><td>'
				+laptop.screenSize+'</td><td>'
				+laptop.cpu+'</td><td>'
				+laptop.gpu+'</td><td>'
				+laptop.mainMem+'</td><td>'
				+laptop.storageType+'</td></tr>');
	})
	$('#laptop-table').DataTable();
}