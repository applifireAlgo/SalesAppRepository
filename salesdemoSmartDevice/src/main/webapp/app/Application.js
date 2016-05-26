/**
 * The main application class. An instance of this class is created by app.js when it calls
 * Ext.application(). This is the ideal place to handle application launch and initialization
 * details.
 */
Ext.define('Salesdemo.Application', {
    extend: 'Ext.app.Application',
    
    name: 'Salesdemo',
requires : ["Ext.button.*","Ext.container.*","Ext.dashboard.*","Ext.dd.*","Ext.dom.*","Ext.event.*","Ext.flash.*","Ext.form.*","Ext.fx.*","Ext.grid.*","Ext.layout.*","Ext.menu.*","Ext.panel.*","Ext.picker.*","Ext.plugin.*","Ext.resizer.*","Ext.rtl.*","Ext.selection.*","Ext.slider.*","Ext.sparkline.*","Ext.state.*","Ext.tab.*","Ext.tip.*","Ext.toolbar.*","Ext.tree.*","Ext.util.*","Ext.view.*","Ext.window.*","Ext.Action","Ext.Component","Ext.ComponentLoader","Ext.ElementLoader","Ext.EventManager","Ext.FocusManager","Ext.Img","Ext.LoadMask","Ext.ProgressBar","Ext.ProgressBarWidget","Ext.ZIndexManager","Salesdemo.view.smartdevice.reportview.ReportMainView","Salesdemo.view.smartdevice.reportview.ReportMainView","Salesdemo.view.smartdevice.reportview.ReportMainView","Salesdemo.salesdemo.smartdevice.sales.view.salesboundedcontext.sales.DistributorMain","Salesdemo.salesdemo.smartdevice.sales.view.salesboundedcontext.sales.SalesDataMain","Salesdemo.salesdemo.smartdevice.sales.view.salesboundedcontext.sales.RetailerMain","Salesdemo.view.smartdevice.reportview.ReportMainView","Salesdemo.view.smartdevice.reportview.ReportMainView","Salesdemo.view.smartdevice.reportview.ReportMainView","Salesdemo.view.smartdevice.reportview.ReportMainView","Salesdemo.salesdemo.smartdevice.sales.view.salesboundedcontext.sales.BrandMain","Salesdemo.salesdemo.smartdevice.sales.view.salesboundedcontext.sales.CurrentMonthMain","Salesdemo.view.smartdevice.reportview.ReportMainView","Salesdemo.view.smartdevice.reportview.ReportMainView","Salesdemo.salesdemo.smartdevice.sales.view.salesboundedcontext.sales.CategoryMain","Salesdemo.salesdemo.smartdevice.sales.view.salesboundedcontext.sales.ChannelMain","Salesdemo.salesdemo.smartdevice.sales.view.salesboundedcontext.sales.SalesRegionMain","Salesdemo.salesdemo.smartdevice.sales.view.salesboundedcontext.sales.MaterialMain"],

    stores: [
        // TODO: add global / shared stores here
    ],
    
    launch: function () {
        // TODO - Launch the application
    }
});
