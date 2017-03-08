/**
 * JavaScript for manage page
 */

var baseUrl="api/laptops";

var currentLaptop;

var getAll=function(){
	console.log('getAll');
	$.ajax({
		type:	'GET',
		url:	baseUrl,
		dataType:'json',
		success:renderList
	});
};

var getById=function(id){
	console.log('getById:'+id);
	$.ajax({
		type:'GET',
		url: baseUrl+'/'+id,
		dataType:'json',
		success: function(data){
			$('#btnDelete').show();
			console.log('getById got :'+data.lmodel);
			currentLaptop=data;
			renderDetails(currentLaptop);
		}
	});
};

var renderDetails=function(laptop){
	$('#lid').val(laptop.lid);
	$('#lmodel').val(laptop.lmodel);
};

var renderList=function(data){
	var list=(data==null)?[]:((data instanceof Array)?data:[data]);
	$('#laptop-list li').remove();
	$.each(list, function(index,laptop){
		$('#laptop-list').append('<li><a href="#" id="'+laptop.lid+'">'+laptop.lmodel+'</a></li>');
	});
};

$(document).ready(function(){
	$(document).on("click",'#laptop-list a',function(){getById(this.id)});
	getAll();
});
	