package sales.app.server.service.appbasicsetup.usermanagement;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import sales.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws Exception {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("jgpBSRHzNSRXBGG4CPZwx8UzUzibS0GQchQrhyHtlfn9UbnB8K");
        useraccessdomain.setDomainDescription("hFb9ZN9gRLmSjeD3X3bmRqEweNAFoPvhkx62vt1n02ozw5vLcc");
        useraccessdomain.setDomainHelp("hhOhVaMJFwY2qRPMwv2O4HNyoPiD0VZee8V5qRJedkm9j1VhVI");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("RUe6yoRl3H0uCQ2ilhEuIC3JbmGubu8wemPEc9VrAbEcjvo9Rr");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainIcon("Y5DZVO68EXfDGLjkEzTPQqSJu6zrRMMzfZGIntfW6fqbQ8K2L3");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainDescription("PGqqitOYiGZpiMbyVuU3LsUJK6GIr0kFGV7rCmk7EocEy3UVGX");
            useraccessdomain.setDomainHelp("0GZOl5Pn6JJimTqO2dx5nkjoiIt1a9VL36KbneTywqeiwbeVEq");
            useraccessdomain.setUserAccessDomain(67088);
            useraccessdomain.setDomainName("3DSYZTW1jIMhHZKpNcdCJlhm9UqiM1BCig8GL7GwlKEo8ZVA0l");
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 116204));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "UyT24bh0PusXRx4u5rneErdcWTKASbwHWCfhUt8MSsQHeA9yEIh4tgRTHnSAbtaf2hHBrMFnwiAl0ViRGmX2ZdLd89X90AhrTnBbDS2HIdc8CjPG9ith8bveoOVQ4AyHchOwGeWVy1feswnnrKCHeqKnErVH61ZSoL9jzbv427l1l4VYZ6a6cnoTkBFPgOFbTYc6inFGPM6oxUEMvhNblQGq2m9ZgvJyLrM3bhNFe5RgGqHKDttNaPBNTNwTG7gu7"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "bMDh4Tig3trVjQoxiMMX4WhwEYtOh5iwRWywcte6JsFk0kettcAl2yeuAkrLzqODY1g40ar8ofnrVSDHMiLVf9MKV3WiHu2DtuaeQbgNLiZgokaOyU2DGIcggNXdnz94GtoOxaMMPeCc91hjWcWPyoFVgqOCr5aab2qCx1NVKJklIffur0foTGreeLN9nYNIjnEJLaj9tq9hrDziCm3TZHZddUD0X6OWgs01zMH16M2bYVtba9ZX4vyhu3aERGgcI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "uaLi0fWM9chVUwICp6mkXW2qZNor4FoNbzv4wuK2r0oCaKfp1o1nc0fRvvUMgWjD1gp5YV7KXWUgpxY9us30j7P75XiDHhkWGBhOh6zP5X4aTAo0KgZ618bU8h1J4bVCjaN7h0VT3USW882gaZqdWDxVff3s9k3jYxNsCIw5ngFZeqM67luwNVx1schLUZFmRpXlzUfVm7J4qqjEPa5QxLW5F0BmI50vpJjGd1TKXJHJPj5miidoeLwKvFwHmCXUJ"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
