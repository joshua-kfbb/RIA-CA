var LaptopEditDetailsView = Backbone.View.extend({
    model: Laptop,
    tagName: 'div',
    events: {
        'click .btn-save': 'saveLaptop',
        'click .btn-delete': 'deleteLaptop'
    },
    saveLaptop: function() {
        var id = this.model.get("lid");
        console.info('saving ' + id + ':' + this.model.get('lmodel'));
        var lDetails = {
            lid: id,
            lmodel: $('#laptop-model-' + id).val(),
            manufacturer: $('#laptop-manufacturer-' + id).val(),
            adapterPower: $('#adapter-power-' + id).val(),
            kbBacklight: $('#kb-backlight-' + id).val(),
            cpu: $('#cpu-' + id).val(),
            gpu: $('#gpu-' + id).val(),
            mainMem: $('#main-mem-' + id).val(),
            screenResolution: $('#screen-resolution-' + id).val(),
            screenSize: $('#screen-size-' + id).val(),
            storageType: $('#storage-type-' + id).val(),
            storageSize: $('#storage-size-' + id).val(),
            videoMem: $('#video-mem-' + id).val(),
            weight: $('#weight-' + id).val()
        };
        this.model.save(lDetails, {
            success: function(laptop) {
                console.info('successfully updated.');
                laptopTableView.renderTable();
            },
            error: function(laptop, response) {
                console.error('fail to update: ' + response.statusText);

            }
        });
        console.log(lDetails);
    },
    deleteLaptop: function() {
        var id = this.model.get('lid');
        console.info('deleteing ' + id + ': ' + this.model.get('lmodel'));
        this.model.destroy({
            success: function(laptop) {
            	laptopList.remove(id);
                console.info(laptop.get('lid') + ' deleted.');
                laptopTableView.renderTable();
            }
        });
    },
    render: function() {
        console.log("LaptopDetailsView.render")
        var template = _.template($('#template-laptop-details').html());
        return this.$el.html(template(this.model.toJSON()));
    }
});