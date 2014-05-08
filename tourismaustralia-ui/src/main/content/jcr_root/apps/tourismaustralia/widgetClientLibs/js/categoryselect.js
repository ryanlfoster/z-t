CQ.CustomWidget = CQ.Ext.extend(CQ.Ext.form.ComboBox, {
    constructor: function(config){
        config = config || {};

        config.store = new CQ.Ext.data.Store({
            proxy: new CQ.Ext.data.HttpProxy({
                "autoLoad":true,
                url: "/bin/australia/pageCategories",
                method: 'GET'
            }),
            reader: new CQ.Ext.data.JsonReader({
                root: 'data',
                fields: [
                    {name: 'value', mapping: 'value'},
                    {name: 'text', mapping: 'text'},
                    {name: 'icon', mapping: 'icon'}
                ]
            })
        });

        config.mode = "remote";
        config.triggerAction = "all";
        config.valueField = 'value';
        config.displayField = 'text';

        config.tpl ='<tpl for=".">' +
            '<div class="x-combo-list-item" style="text-transform:capitalize;">' +
            '<img src="{icon}" style="width:25px;height:25px;" />{text}</div>' +
            '</tpl>';

        CQ.CustomWidget.superclass.constructor.call(this, config);
    },

    initComponent: function () {
        CQ.CustomWidget.superclass.initComponent.call(this);
    }
});

CQ.Ext.reg("categoryselect", CQ.CustomWidget);