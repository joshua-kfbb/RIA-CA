var LaptopTableView = Backbone.View.extend({
    collection: LaptopList,
    initialize: function () {
        this.listenTo(this.collection, 'add', this.renderList);
        this.render();
    },
    render: function () {
        this.collection.each(function (laptop) {
            $('#laptop-tbody').append(
                new LaptopRowView({ model: laptop }).render()
            );
            $('#modals').append(
            		new LaptopEditDetailsView({model: laptop}).render());
        }, this);
        $('#laptop-table').DataTable();
    },
    renderTable: function () {
        $('#laptop-table').DataTable().destroy();
        $('#laptop-tbody tr').remove();
        this.collection.each(function (laptop) {
//        	console.log(laptop.get('lid'));
            $('#laptop-tbody').append(
            		new LaptopRowView({ model: laptop }).render());
            
        });
        // }, this);
        $('#laptop-table').DataTable();
    }
});