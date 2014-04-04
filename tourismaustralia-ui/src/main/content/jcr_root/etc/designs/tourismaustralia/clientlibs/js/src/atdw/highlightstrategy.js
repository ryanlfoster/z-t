CQ.CustomWidget = CQ.Ext.extend(CQ.form.CompositeField, {

    /**
     * @private
     * @type CQ.Ext.form.TextField
     */
    hiddenField: null,

    /**
     * @private
     * @type CQ.Ext.form.TextField
     */
    valuetext: null,


    /**
     * @private
     * @type CQ.Ext.form.ComboBox
     */
    typeSelector: null,

    /**
     * @private
     * @type CQ.Ext.form.TextField
     */

    formPanel: null,

    savedState: {},

    constructor: function(config) {
        config = config || { };
        var defaults = {
            "border": false,
            "layout": "column",
            "columns":2
        };
        config = CQ.Util.applyDefaults(config, defaults);
        CQ.CustomWidget.superclass.constructor.call(this, config);
    },

    // overriding CQ.Ext.Component#initComponent
    initComponent: function() {
        CQ.CustomWidget.superclass.initComponent.call(this);
        //Hidden Field
        this.hiddenField = new CQ.Ext.form.Hidden({
            name: this.name
        });

        this.add(this.hiddenField);

        //DROP DOWN

        this.typeSelector = new CQ.form.Selection({
            type:"select",
            cls:"customwidget-1",
            listeners: {
                selectionchanged: {
                    scope:this,
                    fn: this.clearTextAndUpdateHidden
                }
            },
            options: [{
                text:"City",
                value:"City"
            },{
                text:"State",
                value:"State"
            },{
                text:"Term",
                value:"Term"
            },{
                text:"Tag",
                value:"Tag"
            }]
        });
        this.add(this.typeSelector);

        //Link Text

        this.valuetext = new CQ.Ext.form.TextField({
            cls:"customwidget-2",
            id:"valueTxt",
            listeners: {
                change: {
                    scope:this,
                    fn:this.updateHidden
                }
            }
        });
        this.add(this.valuetext);

    },

    // overriding CQ.form.CompositeField#setValue
    setValue: function(value) {
        var parts = value.split("|");
        this.typeSelector.setValue(parts[0]);
        this.valuetext.setValue(parts[1]);
        this.updateHidden();
    },

    // overriding CQ.form.CompositeField#getValue
    getValue: function() {
        this.getRawValue();
        return this.getRawValue();
    },

    // overriding CQ.form.CompositeField#getRawValue
    getRawValue: function() {
        return this.typeSelector.getValue() + "|" +
            this.valuetext.getValue();
    },

    // private

    clearTextAndUpdateHidden: function() {
        this.valuetext.setValue("");
        this.updateHidden();
    },

    updateHidden: function() {

        var type = this.typeSelector.getValue();
        if(type === 'Tag') {
            this.valuetext.hide();
        } else {
            this.valuetext.show();
        }

        this.hiddenField.setValue(this.getRawValue())
    }

});

// register xtype
CQ.Ext.reg("highlightstrategy", CQ.CustomWidget);

//------------------------------------------------------------------------------