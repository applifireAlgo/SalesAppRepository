package sales.app.server.service.salesboundedcontext.sales;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.salesboundedcontext.sales.SalesDataRepository;
import sales.app.shared.salesboundedcontext.sales.SalesData;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import sales.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import sales.app.shared.salesboundedcontext.sales.Channel;
import sales.app.server.repository.salesboundedcontext.sales.ChannelRepository;
import sales.app.shared.salesboundedcontext.sales.Material;
import sales.app.server.repository.salesboundedcontext.sales.MaterialRepository;
import sales.app.shared.salesboundedcontext.sales.Brand;
import sales.app.server.repository.salesboundedcontext.sales.BrandRepository;
import sales.app.shared.salesboundedcontext.sales.Category;
import sales.app.server.repository.salesboundedcontext.sales.CategoryRepository;
import sales.app.shared.salesboundedcontext.sales.Retailer;
import sales.app.server.repository.salesboundedcontext.sales.RetailerRepository;
import sales.app.shared.salesboundedcontext.sales.Distributor;
import sales.app.server.repository.salesboundedcontext.sales.DistributorRepository;
import sales.app.shared.salesboundedcontext.sales.SalesRegion;
import sales.app.server.repository.salesboundedcontext.sales.SalesRegionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class SalesDataTestCase extends EntityTestCriteria {

    @Autowired
    private SalesDataRepository<SalesData> salesdataRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private SalesData createSalesData(Boolean isSave) throws Exception {
        Channel channel = new Channel();
        channel.setChannelInformation("vS1LEzXzDoCMMOrOEyKIYw7AXIIYWbsyQ89CNR0oq5GDC8YCU6");
        Channel ChannelTest = new Channel();
        if (isSave) {
            ChannelTest = channelRepository.save(channel);
            map.put("ChannelPrimaryKey", channel._getPrimarykey());
        }
        Material material = new Material();
        Brand brand = new Brand();
        brand.setBranddesc("WbKR3rAKf34lGjp6m4406pR4lyyhGjXpCTCMRO6SeVE9g4HJBW");
        Category category = new Category();
        category.setCategoryInformation("InaGtINPn6sKhhNmlcL8PkcFW6nfSMn0TIkuUMnfcyUWLOlchI");
        Category CategoryTest = new Category();
        if (isSave) {
            CategoryTest = categoryRepository.save(category);
            map.put("CategoryPrimaryKey", category._getPrimarykey());
        }
        brand.setBranddesc("NVzEUaf0NS3lbjfZivUjKUBfwTnRgVIjbO6QojP2YFTdM3kIub");
        brand.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        Brand BrandTest = new Brand();
        if (isSave) {
            BrandTest = brandRepository.save(brand);
            map.put("BrandPrimaryKey", brand._getPrimarykey());
        }
        material.setBrandcode((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
        material.setMaterialdesc("zxKQjLoG4XHkA5f0j2IVeRyvsZFFkHI155btcSRZlHavHG7u9V");
        Material MaterialTest = new Material();
        if (isSave) {
            MaterialTest = materialRepository.save(material);
            map.put("MaterialPrimaryKey", material._getPrimarykey());
        }
        Retailer retailer = new Retailer();
        Distributor distributor = new Distributor();
        distributor.setLattitude(7340.0d);
        SalesRegion salesregion = new SalesRegion();
        salesregion.setRegionname("nKvb5N6IvPhQlDQKoTrwlcG92iM18mp25y5KOQRxzapTKLRYVC");
        SalesRegion SalesRegionTest = new SalesRegion();
        if (isSave) {
            SalesRegionTest = salesregionRepository.save(salesregion);
            map.put("SalesRegionPrimaryKey", salesregion._getPrimarykey());
        }
        distributor.setLattitude(6500.0d);
        distributor.setRegioncode((java.lang.String) SalesRegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        distributor.setDistributorname("pQSqodCN6m2C1S1zN75yDp06LyvafvdOVnCOsc2jkqdkGGZ8ta");
        distributor.setLongitude(100.0d);
        Distributor DistributorTest = new Distributor();
        if (isSave) {
            DistributorTest = distributorRepository.save(distributor);
            map.put("DistributorPrimaryKey", distributor._getPrimarykey());
        }
        retailer.setDistributorcode((java.lang.String) DistributorTest._getPrimarykey()); /* ******Adding refrenced table data */
        retailer.setRetailername("L4fSxyDLQwpLhTQo6llybHJR8QeWyurT3MzRufUCWdL88yxqqP");
        Retailer RetailerTest = new Retailer();
        if (isSave) {
            RetailerTest = retailerRepository.save(retailer);
            map.put("RetailerPrimaryKey", retailer._getPrimarykey());
        }
        SalesData salesdata = new SalesData();
        salesdata.setChannelId((java.lang.String) ChannelTest._getPrimarykey()); /* ******Adding refrenced table data */
        salesdata.setRetailername("WtZyF6Of35cv0LeCwBpyQdASbNy9uUTSE4NrYFiwCc66jYi72y");
        salesdata.setBranddescription("l");
        salesdata.setMaterialcode((java.lang.String) MaterialTest._getPrimarykey()); /* ******Adding refrenced table data */
        salesdata.setNetsalesamt(-2544.0d);
        salesdata.setBrandcode((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
        salesdata.setSalesyear(2147483647);
        salesdata.setSalesqty(-1940.0d);
        salesdata.setSalesdate(new java.sql.Date(123456789));
        salesdata.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        salesdata.setSalesmonth(2147483647);
        salesdata.setMaterialdescription("dtDkj9YLz7R8B7frIMW0dmtvGhDjrcImokNKT7D7n8UeVkjBWx");
        salesdata.setReatilercode((java.lang.String) RetailerTest._getPrimarykey());
        salesdata.setGrosssalesamt(-2600.0d);
        salesdata.setSalesinvoicenbr("pS6Y7rpVirEuGwtwzkgzgUfFKlyPG2qN5Rr179m1gY9TUFBtl9");
        salesdata.setEntityValidator(entityValidator);
        return salesdata;
    }

    @Test
    public void test1Save() {
        try {
            SalesData salesdata = createSalesData(true);
            salesdata.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            salesdata.isValid();
            salesdataRepository.save(salesdata);
            map.put("SalesDataPrimaryKey", salesdata._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ChannelRepository<Channel> channelRepository;

    @Autowired
    private MaterialRepository<Material> materialRepository;

    @Autowired
    private BrandRepository<Brand> brandRepository;

    @Autowired
    private CategoryRepository<Category> categoryRepository;

    @Autowired
    private RetailerRepository<Retailer> retailerRepository;

    @Autowired
    private DistributorRepository<Distributor> distributorRepository;

    @Autowired
    private SalesRegionRepository<SalesRegion> salesregionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("SalesDataPrimaryKey"));
            SalesData salesdata = salesdataRepository.findById((java.lang.Integer) map.get("SalesDataPrimaryKey"));
            salesdata.setRetailername("6UDS1fP3ASeZdraLHILaMUZju23OmzxW6NXnRR21A21GNRHchu");
            salesdata.setBranddescription("q");
            salesdata.setNetsalesamt(8200.0d);
            salesdata.setSalesyear(2147483647);
            salesdata.setVersionId(1);
            salesdata.setSalesqty(-8400.0d);
            salesdata.setSalesdate(new java.sql.Date(123456789));
            salesdata.setSalesmonth(2147483647);
            salesdata.setMaterialdescription("SVuyFYpXjTYKvH86QNuM1Rqzhh3xNQvQ5pH02XjOAws0mWXjct");
            salesdata.setGrosssalesamt(4384.0d);
            salesdata.setSalesinvoicenbr("pQj23BGDqBrOGaCJROuG6FSq6olqP4tiqPOr01JvcuN0EtB1E2");
            salesdata.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            salesdataRepository.update(salesdata);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBychannelId() {
        try {
            java.util.List<SalesData> listofchannelId = salesdataRepository.findByChannelId((java.lang.String) map.get("ChannelPrimaryKey"));
            if (listofchannelId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBymaterialcode() {
        try {
            java.util.List<SalesData> listofmaterialcode = salesdataRepository.findByMaterialcode((java.lang.String) map.get("MaterialPrimaryKey"));
            if (listofmaterialcode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBybrandcode() {
        try {
            java.util.List<SalesData> listofbrandcode = salesdataRepository.findByBrandcode((java.lang.String) map.get("BrandPrimaryKey"));
            if (listofbrandcode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycategoryId() {
        try {
            java.util.List<SalesData> listofcategoryId = salesdataRepository.findByCategoryId((java.lang.String) map.get("CategoryPrimaryKey"));
            if (listofcategoryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByreatilercode() {
        try {
            java.util.List<SalesData> listofreatilercode = salesdataRepository.findByReatilercode((java.lang.String) map.get("RetailerPrimaryKey"));
            if (listofreatilercode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("SalesDataPrimaryKey"));
            salesdataRepository.findById((java.lang.Integer) map.get("SalesDataPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("SalesDataPrimaryKey"));
            salesdataRepository.delete((java.lang.Integer) map.get("SalesDataPrimaryKey")); /* Deleting refrenced data */
            retailerRepository.delete((java.lang.String) map.get("RetailerPrimaryKey")); /* Deleting refrenced data */
            distributorRepository.delete((java.lang.String) map.get("DistributorPrimaryKey")); /* Deleting refrenced data */
            salesregionRepository.delete((java.lang.String) map.get("SalesRegionPrimaryKey")); /* Deleting refrenced data */
            materialRepository.delete((java.lang.String) map.get("MaterialPrimaryKey")); /* Deleting refrenced data */
            brandRepository.delete((java.lang.String) map.get("BrandPrimaryKey")); /* Deleting refrenced data */
            categoryRepository.delete((java.lang.String) map.get("CategoryPrimaryKey")); /* Deleting refrenced data */
            channelRepository.delete((java.lang.String) map.get("ChannelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateSalesData(EntityTestCriteria contraints, SalesData salesdata) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            salesdata.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            salesdata.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            salesdata.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            salesdataRepository.save(salesdata);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "retailername", "T6f4HUxLoZojpCKqlVKkQp2az3OF5NA19nqSxlJGvUnuvX3scV6p3jo2v7bAGJIU0"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 2, "salesdate", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "salesmonth", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "salesyear", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "salesinvoicenbr", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "salesinvoicenbr", "mkwTd03nSw7iYRcYsLrS6G7SRWna8iGJoRrmqQHa78JD5MafmShw63obUUSyI9SpK"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "materialdescription", "hiS6XELg52twY9Vo8vvwJITaTZhd9auHD7po6ud6W9R10ucXGsBupN8GYwXqYrQhB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "branddescription", "dHm"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 9, "salesqty", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "salesqty", 1.6896250390082654E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "netsalesamt", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "netsalesamt", 1.4013337826593298E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "grosssalesamt", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "grosssalesamt", 1.3635024089591663E19d));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                SalesData salesdata = createSalesData(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = salesdata.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        salesdata.setRetailername(contraints.getNegativeValue().toString());
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 2:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 6:
                        salesdata.setSalesinvoicenbr(contraints.getNegativeValue().toString());
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 7:
                        salesdata.setMaterialdescription(contraints.getNegativeValue().toString());
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 8:
                        salesdata.setBranddescription(contraints.getNegativeValue().toString());
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 9:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 10:
                        salesdata.setSalesqty(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 12:
                        salesdata.setNetsalesamt(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(salesdata, null);
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                    case 14:
                        salesdata.setGrosssalesamt(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateSalesData(contraints, salesdata);
                        failureCount++;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
