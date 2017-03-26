var LaptopDetailsView=Backbone.View.extend({
    model:Laptop,
    tagName:'div',
    events:{},
    render:function () {
    	console.log("LaptopDetailsView.render")
        var template=_.template($('#template-laptop-details').html());
        return this.$el.html(template(this.model.toJSON()));
    }
});