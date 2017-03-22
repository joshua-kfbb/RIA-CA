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
        }, this);
        $('#laptop-table').DataTable();
    },
    renderTable: function () {
        $('#laptop-table').DataTable().destroy();
        this.collection.each(function (laptop) {
            $('#laptop-tbody').append(
                new LaptopRowView({ model: laptop }).render()
            )});
        // }, this);
        $('#laptop-table').DataTable();
    }
});