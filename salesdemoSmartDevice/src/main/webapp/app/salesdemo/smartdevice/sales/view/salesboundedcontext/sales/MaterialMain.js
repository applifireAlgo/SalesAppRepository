Ext.define('Salesdemo.salesdemo.smartdevice.sales.view.salesboundedcontext.sales.MaterialMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "MaterialMainController",
     "restURL": "/Material",
     "requires": ["Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.MaterialModel", "Salesdemo.salesdemo.smartdevice.sales.controller.salesboundedcontext.sales.MaterialMainController", "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.BrandModel", "Salesdemo.salesdemo.shared.sales.viewmodel.salesboundedcontext.sales.MaterialViewModel"],
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
               "itemId": "MaterialTree",
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
                    "viewModel": "MaterialViewModel",
                    "xtype": "form",
                    "displayName": "Material",
                    "title": "Material",
                    "name": "Material",
                    "itemId": "Material",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "materialdesc",
                         "itemId": "materialdesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Material",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Material<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "778E9242-B561-45E9-A912-A98E3ED4FBF8",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "materialdesc",
                         "columnWidth": 1
                    }, {
                         "name": "brandcode",
                         "itemId": "brandcode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Brand",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.BrandModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Brand<font color='red'> *<\/font>",
                         "fieldId": "41A73FBF-2D0E-4CF0-ADA6-F0119E75C3D3",
                         "restURL": "Brand",
                         "bindable": "brandcode",
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
                         "customId": 789,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 789,
                              "customId": 144
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 789,
                              "customId": 145,
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
                              "parentId": 789,
                              "customId": 146,
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