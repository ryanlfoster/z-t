var CQ = CQ || {};
CQ.TA = CQ.TA || {};

CQ.TA.Utils = {
    multicomponsitelimit:function (limit, container, component, index) {
        if (index >= limit) {
            CQ.Ext.Msg.alert("Error", "Max number of items is: " + limit);
            return false;
        }
    }
}