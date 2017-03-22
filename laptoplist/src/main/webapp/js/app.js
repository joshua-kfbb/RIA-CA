
//An instance of MainView is made whenever the app is run.

var laptopTableView;
var laptopList;
//The rendered main view is put on the page.
$(document).ready(function(){
	//console.log("here");
	laptopList = new LaptopList();
	laptopList.fetch({
		success: function(data){
			laptopTableView = new LaptopTableView({collection: laptopList});
//			laptopTableView.$el.appendTo(document.body);
		}
	});
});

