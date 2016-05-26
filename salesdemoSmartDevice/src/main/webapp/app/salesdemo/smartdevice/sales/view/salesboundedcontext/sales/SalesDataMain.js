Ext.define('Salesdemo.salesdemo.smartdevice.sales.view.salesboundedcontext.sales.SalesDataMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "SalesDataMainController",
     "restURL": "/SalesData",
     "requires": ["Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.SalesDataModel", "Salesdemo.salesdemo.smartdevice.sales.controller.salesboundedcontext.sales.SalesDataMainController", "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.ChannelModel", "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.RetailerModel", "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.MaterialModel", "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.BrandModel", "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.CategoryModel", "Salesdemo.salesdemo.shared.sales.viewmodel.salesboundedcontext.sales.SalesDataViewModel"],
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
               "itemId": "SalesDataTree",
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
                    "viewModel": "SalesDataViewModel",
                    "xtype": "form",
                    "displayName": "SalesData",
                    "title": "SalesData",
                    "name": "SalesData",
                    "itemId": "SalesData",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "channelId",
                         "itemId": "channelId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Channel",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.ChannelModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Channel<font color='red'> *<\/font>",
                         "fieldId": "09B0B7A8-E90F-40EA-92D7-49CF6F839BA2",
                         "restURL": "Channel",
                         "bindable": "channelId",
                         "columnWidth": 1
                    }, {
                         "name": "reatilercode",
                         "itemId": "reatilercode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Retailer",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.RetailerModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Retailer<font color='red'> *<\/font>",
                         "fieldId": "D97CC7A5-7596-441D-AE59-9F80377411A2",
                         "restURL": "Retailer",
                         "bindable": "reatilercode",
                         "columnWidth": 1
                    }, {
                         "name": "retailername",
                         "itemId": "retailername",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Retailer name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Retailer name",
                         "fieldId": "1381F306-5546-4CE5-BEF8-D0FC339675C6",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "retailername",
                         "columnWidth": 1
                    }, {
                         "name": "salesdate",
                         "itemId": "salesdate",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "Sales Date",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "Sales Date<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "682A30F6-8609-4429-BA4A-41FFF6C2ADF8",
                         "bindable": "salesdate",
                         "columnWidth": 1
                    }, {
                         "name": "salesmonth",
                         "itemId": "salesmonth",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Sales Month",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Sales Month<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A5621D40-EDD9-4A3D-969C-9334D788DB73",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "salesmonth",
                         "columnWidth": 1
                    }, {
                         "name": "salesyear",
                         "itemId": "salesyear",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Sales Year",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Sales Year<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "4E88A7EE-A9DE-4457-8824-DC9D18647C3C",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "salesyear",
                         "columnWidth": 1
                    }, {
                         "name": "salesinvoicenbr",
                         "itemId": "salesinvoicenbr",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Invoice Number",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Invoice Number<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "DAC3D1A1-AC58-490B-B760-8C4DB5B460CB",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "salesinvoicenbr",
                         "columnWidth": 1
                    }, {
                         "name": "materialdescription",
                         "itemId": "materialdescription",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Material Desc",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Material Desc",
                         "fieldId": "B8A59341-055B-4B0E-A7DF-BDDD58C20FEF",
                         "minLength": "1",
                         "maxLength": "64",
                         "bindable": "materialdescription",
                         "columnWidth": 1
                    }, {
                         "name": "branddescription",
                         "itemId": "branddescription",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Brand Desc",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Brand Desc",
                         "fieldId": "144CE5F4-28F1-4704-8F08-94E7633EC46B",
                         "maxLength": "1",
                         "bindable": "branddescription",
                         "columnWidth": 1
                    }, {
                         "name": "salesqty",
                         "itemId": "salesqty",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Sales Quantity",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Sales Quantity<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "5FBDA71C-169F-4E22-A3A0-C10345093A23",
                         "minValue": "-9223372000000000000",
                         "maxValue": "9223372000000000000",
                         "bindable": "salesqty",
                         "columnWidth": 1
                    }, {
                         "name": "netsalesamt",
                         "itemId": "netsalesamt",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Net Sales",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Net Sales<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "3655377E-7ABF-4350-BCFA-7EFAF72E6C62",
                         "minValue": "-9223372000000000000",
                         "maxValue": "9223372000000000000",
                         "bindable": "netsalesamt",
                         "columnWidth": 1
                    }, {
                         "name": "grosssalesamt",
                         "itemId": "grosssalesamt",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Gross Sales",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Gross Sales<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "DA192492-FBAD-4243-8C5C-7E4CDD305394",
                         "minValue": "-9223372000000000000",
                         "maxValue": "9223372000000000000",
                         "bindable": "grosssalesamt",
                         "columnWidth": 1
                    }, {
                         "name": "materialcode",
                         "itemId": "materialcode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Material",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.MaterialModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Material<font color='red'> *<\/font>",
                         "fieldId": "203A1998-3E1B-40D2-A8B7-B2C2AAED2195",
                         "restURL": "Material",
                         "bindable": "materialcode",
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
                         "fieldId": "42A7E018-6DD5-4867-B34F-212988494F22",
                         "restURL": "Brand",
                         "bindable": "brandcode",
                         "columnWidth": 1,
                         "listeners": {
                              "change": "onBrandcodeChange"
                         }
                    }, {
                         "name": "categoryId",
                         "itemId": "categoryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Category",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.CategoryModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Category<font color='red'> *<\/font>",
                         "fieldId": "7453E178-1DC4-47B5-985B-81E2BA1F31B7",
                         "restURL": "Category",
                         "bindable": "categoryId",
                         "columnWidth": 1,
                         "listeners": {
                              "change": "onCategoryIdChange"
                         }
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
                         "customId": 445,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 445,
                              "customId": 921
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 445,
                              "customId": 922,
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
                              "parentId": 445,
                              "customId": 923,
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