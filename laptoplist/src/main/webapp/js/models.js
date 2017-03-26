/**
 * models for laptop and laptop collection
 */

var baseUrl = 'api/laptops';

var Laptop = Backbone.Model.extend({
    urlRoot: baseUrl,
    idAttribute:'lid',
    defaults: {
        "adapterPower": 0,
        "cpu": "",
        "gpu": "",
        "kbBacklight": "none",
        "lid": 0,
        "lmodel": "",
        "mainMem": 0,
        "manufacturer": "",
        "screenResolution": "",
        "screenSize": 0,
        "storageSize": 0,
        "storageType": "HDD",
        "videoMem": 0,
        "weight": 0
    },
    initialize: function () {
        // LOG
        console.log('Laptop Initialization');
    }
});

var LaptopList = Backbone.Collection.extend({
    model: Laptop,
    url: baseUrl
});
