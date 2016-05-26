Ext.define('Salesdemo.salesdemo.smartdevice.sales.view.salesboundedcontext.sales.DistributorMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "DistributorMainController",
     "restURL": "/Distributor",
     "requires": ["Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.DistributorModel", "Salesdemo.salesdemo.smartdevice.sales.controller.salesboundedcontext.sales.DistributorMainController", "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.SalesRegionModel", "Salesdemo.salesdemo.shared.sales.viewmodel.salesboundedcontext.sales.DistributorViewModel"],
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
               "itemId": "DistributorTree",
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
                    "viewModel": "DistributorViewModel",
                    "xtype": "form",
                    "displayName": "Distributor",
                    "title": "Distributor",
                    "name": "Distributor",
                    "itemId": "Distributor",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "distributorname",
                         "itemId": "distributorname",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Distributor",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Distributor<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "8BE9B75B-842A-4866-B51C-BF82402CFCE3",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "distributorname",
                         "columnWidth": 1
                    }, {
                         "name": "regioncode",
                         "itemId": "regioncode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.SalesRegionModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Region<font color='red'> *<\/font>",
                         "fieldId": "5650A559-536C-44BB-B2AD-08BD34952057",
                         "restURL": "SalesRegion",
                         "bindable": "regioncode",
                         "columnWidth": 1
                    }, {
                         "name": "longitude",
                         "itemId": "longitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Longitude<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C2A5BF6C-4BD5-43AA-A651-D1A0DF3995EB",
                         "minValue": "-9223372000000000000",
                         "maxValue": "9223372000000000000",
                         "bindable": "longitude",
                         "columnWidth": 1
                    }, {
                         "name": "lattitude",
                         "itemId": "lattitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Latitude<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "52D08618-7B55-47B6-9150-BFCA84AD70DE",
                         "minValue": "-9223372000000000000",
                         "maxValue": "9223372000000000000",
                         "bindable": "lattitude",
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
                         "customId": 386,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 386,
                              "customId": 830
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 386,
                              "customId": 831,
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
                              "parentId": 386,
                              "customId": 832,
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