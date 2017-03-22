var LaptopRowView=Backbone.View.extend({
    model:Laptop,
    tagName:'tr',
    events:{},
    render:function () {
        var template=_.template($('#template-laptop-details').html());
        return this.$el.html(template(this.model.toJSON()));
    }
});