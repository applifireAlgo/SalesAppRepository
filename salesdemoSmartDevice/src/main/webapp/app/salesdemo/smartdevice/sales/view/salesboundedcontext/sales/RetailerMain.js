Ext.define('Salesdemo.salesdemo.smartdevice.sales.view.salesboundedcontext.sales.RetailerMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "RetailerMainController",
     "restURL": "/Retailer",
     "requires": ["Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.RetailerModel", "Salesdemo.salesdemo.smartdevice.sales.controller.salesboundedcontext.sales.RetailerMainController", "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.DistributorModel", "Salesdemo.salesdemo.shared.sales.viewmodel.salesboundedcontext.sales.RetailerViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "margin": 5,
     "tabBar": {
          "hidden": true
     },
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "treepanel",
               "customWidgetType": "vdTree",
               "title": "List",
               "useArrows": true,
               "rowLines": true,
               "columnLines": true,
               "rootVisible": false,
               "itemId": "RetailerTree",
               "listeners": {
                    "select": "treeClick"
               },
               "tbar": [{
                    "xtype": "triggerfield",
                    "customWidgetType": "vdTriggerField",
                    "width": "90%",
                    "height": "35",
                    "emptyText": "Search",
                    "triggerCls": "",
                    "listeners": {
                         "change": "onTriggerfieldChange",
                         "buffer": 250
                    }
               }, "->", {
                    "xtype": "tool",
                    "type": "refresh",
                    "tooltip": "Refresh Tree Data",
                    "handler": "onTreeRefreshClick"
               }],
               "region": "south",
               "height": "100%",
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false
          }, {
               "region": "center",
               "layout": "border",
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "RetailerViewModel",
                    "xtype": "form",
                    "displayName": "Retailer",
                    "title": "Retailer",
                    "name": "Retailer",
                    "itemId": "Retailer",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "retailername",
                         "itemId": "retailername",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Retailer",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Retailer<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F721CB73-848F-41F7-98F1-B3BCD96CDBF6",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "retailername",
                         "columnWidth": 1
                    }, {
                         "name": "distributorcode",
                         "itemId": "distributorcode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Distributor",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.DistributorModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Distributor<font color='red'> *<\/font>",
                         "fieldId": "62E8DB99-C8D5-4D7E-B152-699AD054B928",
                         "restURL": "Distributor",
                         "bindable": "distributorcode",
                         "columnWidth": 1
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 302,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 302,
                              "customId": 228
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 302,
                              "customId": 229,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 302,
                              "customId": 230,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5",
                              "flex": 1,
                              "height": 30
                         }
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }]
          }]
     }]
});