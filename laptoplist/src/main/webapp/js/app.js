var laptopTableView;
var laptopList;
//The rendered main view is put on the page.
$(document).ready(function(){
	$('#modals').append(
    		new AddLaptopDetailsView({model: new Laptop({lid:'new',isNew:function(){return true;}})}).render());
	laptopList = new LaptopList();
	laptopList.fetch({
		success: function(data){
			laptopTableView = new LaptopTableView({collection: laptopList});
		}
	});
});

