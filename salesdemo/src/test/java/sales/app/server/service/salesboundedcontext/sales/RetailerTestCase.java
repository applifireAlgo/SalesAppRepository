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
import sales.app.server.repository.salesboundedcontext.sales.RetailerRepository;
import sales.app.shared.salesboundedcontext.sales.Retailer;
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
import sales.app.shared.salesboundedcontext.sales.Distributor;
import sales.app.server.repository.salesboundedcontext.sales.DistributorRepository;
import sales.app.shared.salesboundedcontext.sales.SalesRegion;
import sales.app.server.repository.salesboundedcontext.sales.SalesRegionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RetailerTestCase extends EntityTestCriteria {

    @Autowired
    private RetailerRepository<Retailer> retailerRepository;

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

    private Retailer createRetailer(Boolean isSave) throws Exception {
        Distributor distributor = new Distributor();
        distributor.setLattitude(5700.0d);
        SalesRegion salesregion = new SalesRegion();
        salesregion.setRegionname("mDB7sqaI1I9fDSNyfwvnMCXPEw0GZzyZkxWTVDIOPDext4ogMk");
        SalesRegion SalesRegionTest = new SalesRegion();
        if (isSave) {
            SalesRegionTest = salesregionRepository.save(salesregion);
            map.put("SalesRegionPrimaryKey", salesregion._getPrimarykey());
        }
        distributor.setLattitude(830.0d);
        distributor.setRegioncode((java.lang.String) SalesRegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        distributor.setDistributorname("MLp3LimNIYRcPPuI34Y6rGFqE6wgimHBxPGZtmkShBHC3fthDe");
        distributor.setLongitude(-6200.0d);
        Distributor DistributorTest = new Distributor();
        if (isSave) {
            DistributorTest = distributorRepository.save(distributor);
            map.put("DistributorPrimaryKey", distributor._getPrimarykey());
        }
        Retailer retailer = new Retailer();
        retailer.setDistributorcode((java.lang.String) DistributorTest._getPrimarykey());
        retailer.setRetailername("pn2j2cPmHp3bcsm2972ivUfZolZMDNgU39vvkLTuCjSV2lRCk7");
        retailer.setEntityValidator(entityValidator);
        return retailer;
    }

    @Test
    public void test1Save() {
        try {
            Retailer retailer = createRetailer(true);
            retailer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            retailer.isValid();
            retailerRepository.save(retailer);
            map.put("RetailerPrimaryKey", retailer._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private DistributorRepository<Distributor> distributorRepository;

    @Autowired
    private SalesRegionRepository<SalesRegion> salesregionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RetailerPrimaryKey"));
            Retailer retailer = retailerRepository.findById((java.lang.String) map.get("RetailerPrimaryKey"));
            retailer.setVersionId(1);
            retailer.setRetailername("1Mua8dn8y9Jty9ANbGIWIUl7OHDLmFFchhLxi40DQSK0OX2vCx");
            retailer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            retailerRepository.update(retailer);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBydistributorcode() {
        try {
            java.util.List<Retailer> listofdistributorcode = retailerRepository.findByDistributorcode((java.lang.String) map.get("DistributorPrimaryKey"));
            if (listofdistributorcode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RetailerPrimaryKey"));
            retailerRepository.findById((java.lang.String) map.get("RetailerPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RetailerPrimaryKey"));
            retailerRepository.delete((java.lang.String) map.get("RetailerPrimaryKey")); /* Deleting refrenced data */
            distributorRepository.delete((java.lang.String) map.get("DistributorPrimaryKey")); /* Deleting refrenced data */
            salesregionRepository.delete((java.lang.String) map.get("SalesRegionPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRetailer(EntityTestCriteria contraints, Retailer retailer) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            retailer.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            retailer.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            retailer.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            retailerRepository.save(retailer);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "retailername", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "retailername", "BJWMNj4WeAumU7nixWF4Ut87ZPKeYmknhVJySjrMAt3SaiuHBIKDZ0rIUnkbKbGpFe6g4cd5TSTJ0zXg2YB2uNc1ndgMDCbF2XBaG8fGogGzqkOAKRAU3iIypOMgj1r5Ie8rek0YKHIVabEeJq9LenxcqSKlYeIHYw91C71JSgywkcgE8p4FcIO4EQkDGtaENs6QBx5iW0CiCdgRwYWkttOspI7TjK87YTiXz4AatU0hPYz5CYnDpHqqanFuqfJZL"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Retailer retailer = createRetailer(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = retailer.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(retailer, null);
                        validateRetailer(contraints, retailer);
                        failureCount++;
                        break;
                    case 2:
                        retailer.setRetailername(contraints.getNegativeValue().toString());
                        validateRetailer(contraints, retailer);
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
