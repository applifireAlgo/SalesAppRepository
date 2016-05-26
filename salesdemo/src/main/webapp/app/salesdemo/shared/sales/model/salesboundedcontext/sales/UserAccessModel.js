Ext.define('Salesdemo.salesdemo.shared.sales.model.salesboundedcontext.sales.UserAccessModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "userid",
          "reference": "User",
          "defaultValue": ""
     }, {
          "name": "region",
          "reference": "SalesRegion",
          "defaultValue": ""
     }, {
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "userAccessId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});