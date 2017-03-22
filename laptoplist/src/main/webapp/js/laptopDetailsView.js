var LaptopDetailsView=Backbone.View.extend({
    model:Laptop,
    tagName:'tr',
    events:{},
    render:function () {
        var template=_.template($('#template-laptop-row').html());
        return this.$el.html(template(this.model.toJSON()));
    }
});