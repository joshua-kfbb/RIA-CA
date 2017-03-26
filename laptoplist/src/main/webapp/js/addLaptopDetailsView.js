var AddLaptopDetailsView = Backbone.View.extend({
    model: Laptop,
    tagName: 'div',
    events: {
        'click .btn-save': 'saveLaptop',
    },
    saveLaptop: function() {
        var id = 'new';
//        console.info('saving ' + id + ':' + this.model.get('lmodel'));
        var lDetails = {
        	lid: null,
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
        this.model=new Laptop(lDetails);
//        console.log(lDetails);
        this.model.save(lDetails, {
            success: function(laptop,wtf) {
            	laptopList.add(wtf);
//            	console.log(wtf)
                console.info('successfully added, id: '+wtf.lid);
                $('#modals').append(
                		new LaptopDetailsView({model: new Laptop(wtf)}).render());
                laptopTableView.renderTable();
            },
            error: function(laptop, response) {
                console.error('fail to add: ' + response.statusText);

            }
        });
    },
    render: function() {
        console.log("LaptopDetailsView.render")
        var template = _.template($('#template-laptop-details').html());
        return this.$el.html(template(this.model.toJSON()));
    }
});