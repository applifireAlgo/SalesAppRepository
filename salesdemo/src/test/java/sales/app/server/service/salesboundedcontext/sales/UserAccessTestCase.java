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
import sales.app.server.repository.salesboundedcontext.sales.UserAccessRepository;
import sales.app.shared.salesboundedcontext.sales.UserAccess;
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
import sales.app.shared.appbasicsetup.usermanagement.User;
import sales.app.server.repository.appbasicsetup.usermanagement.UserRepository;
import sales.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import sales.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import sales.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import sales.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import sales.app.shared.appbasicsetup.usermanagement.PassRecovery;
import sales.app.shared.appbasicsetup.usermanagement.Question;
import sales.app.server.repository.appbasicsetup.usermanagement.QuestionRepository;
import sales.app.shared.appbasicsetup.usermanagement.UserData;
import sales.app.shared.salesboundedcontext.sales.SalesRegion;
import sales.app.server.repository.salesboundedcontext.sales.SalesRegionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessRepository<UserAccess> useraccessRepository;

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

    private UserAccess createUserAccess(Boolean isSave) throws Exception {
        User user = new User();
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1464160175922l));
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("2yX5pWLUUTnDuT5lFv1QART9e5SO2sWUyhnLogoI2xjp3cnPpZ");
        useraccessdomain.setDomainDescription("fiFGhMP38gH5gWta83Z6qmm6URSbXjjn8VRWgmXvPaxjn7sv6r");
        useraccessdomain.setDomainHelp("V1DpHVhv36W3fMFZYaHb6XYgEP8v9LzYuP7JXO5SHwatGTedOv");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("OFOwWIJk9DyvISx9YvxWA12JbsdEKZWOubSC0KnDeLdHuVdBrN");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelDescription("pvRDVCZ1wfAy3VwV8MNWSx3cBFpXQ3y9pIJO940MZwBliFGlKE");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("PB7uxtMBYCpOlwSEpcOyvT4tsUeQWRvO9snhyHifmkhznsz9m1");
        useraccesslevel.setLevelName("Q5SZxGmOlTxZdugDtqbbCHoqRPaiJ3sG38XYFxbIWRvrsSTStw");
        useraccesslevel.setLevelIcon("ZCadZD9h0bxkI6BcaYemMIirkOWuHxupLH26wpCKHPISvGX4DH");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1464160175929l));
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsDeleted(1);
        user.setSessionTimeout(1200);
        user.setGenTempOneTimePassword(1);
        user.setChangePasswordNextLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1464160175978l));
        user.setUserAccessCode(33592);
        user.setAllowMultipleLogin(1);
        user.setIsLocked(1);
        user.setPasswordAlgo("opxCFTW4HWJYlywfQJsYF93WzNWAQnw9wl8p129dOgn32ha1BG");
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("5AWpEWKfIKzgf9aqZq17RCqqKDQuKdSouLG9k6tkBIygV4uLRn");
        Question question = new Question();
        question.setQuestionDetails("i9q2OcODK1");
        question.setQuestion("xGomla1S2udvRPEbt1HlqQWanZKZnPooIbB4ZXjwzpn6qjFAOj");
        question.setQuestionIcon("tk8gozSvB5NhUIbPdmf73Q0vMPSif4zMB7r8Ushdu5WCQkk51x");
        question.setLevelid(3);
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setAnswer("HTJrfQx9IEAc27Enzx41Vg6I4BKFpyxYFv5iDkU9az0YfUf3Ga");
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordExpiry(3);
        userdata.setPassword("rFc0lLF3raxvzqoSFVt5NFUSOLGeZplk9kqPTgzYdpIH7RhCNb");
        userdata.setOneTimePassword("XEK3BU2I2YjIQfedz6KwE40Ut9vFKe3t");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1464160176122l));
        userdata.setOneTimePasswordExpiry(8);
        userdata.setPassword("sZmW8UY0W788fm83DxuaZyZf11vq6SiDWTfioNE7wPKbBathoq");
        userdata.setOneTimePassword("RR294Aw5vueq1YwTJ6DbdWNQWlXUebW8");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1464160176127l));
        userdata.setUser(user);
        userdata.setLast5Passwords("IRX9hKNU65L5YFO05QW4e8NeQldUaC8zdyWUHNwTWzoksD9fMA");
        user.setUserData(userdata);
        User UserTest = new User();
        if (isSave) {
            UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
        }
        SalesRegion salesregion = new SalesRegion();
        salesregion.setRegionname("jPVuGNsryJLGuNqS7bzg9QHGIHyLQAF0WLbHuNEWvIAqMF8ZTt");
        SalesRegion SalesRegionTest = new SalesRegion();
        if (isSave) {
            SalesRegionTest = salesregionRepository.save(salesregion);
            map.put("SalesRegionPrimaryKey", salesregion._getPrimarykey());
        }
        UserAccess useraccess = new UserAccess();
        useraccess.setUserId((java.lang.String) UserTest._getPrimarykey()); /* ******Adding refrenced table data */
        useraccess.setRegion((java.lang.String) SalesRegionTest._getPrimarykey());
        useraccess.setEntityValidator(entityValidator);
        return useraccess;
    }

    @Test
    public void test1Save() {
        try {
            UserAccess useraccess = createUserAccess(true);
            useraccess.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccess.isValid();
            useraccessRepository.save(useraccess);
            map.put("UserAccessPrimaryKey", useraccess._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private SalesRegionRepository<SalesRegion> salesregionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessPrimaryKey"));
            UserAccess useraccess = useraccessRepository.findById((java.lang.Integer) map.get("UserAccessPrimaryKey"));
            useraccess.setVersionId(1);
            useraccess.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessRepository.update(useraccess);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<UserAccess> listofuserId = useraccessRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregion() {
        try {
            java.util.List<UserAccess> listofregion = useraccessRepository.findByRegion((java.lang.String) map.get("SalesRegionPrimaryKey"));
            if (listofregion.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessPrimaryKey"));
            useraccessRepository.findById((java.lang.Integer) map.get("UserAccessPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessPrimaryKey"));
            useraccessRepository.delete((java.lang.Integer) map.get("UserAccessPrimaryKey")); /* Deleting refrenced data */
            salesregionRepository.delete((java.lang.String) map.get("SalesRegionPrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccess(EntityTestCriteria contraints, UserAccess useraccess) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccess.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccess.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccess.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessRepository.save(useraccess);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
    }
}