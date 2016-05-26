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
import sales.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import sales.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws Exception {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelDescription("Z0EtlRFBuAGj5Nqky8BBJBkpzEhjk0lsexKZjhLC8DQcSKtESu");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("bhC0XZNZKMgtpioQ1MPMvAUhwVtAJKQ9WxsE0BFqdtWSzEcj4b");
        useraccesslevel.setLevelName("5GW7J26OuVLSp0Tyd7QtM63pP7msjfBkJD8DYCbWVgSaUpXtiF");
        useraccesslevel.setLevelIcon("a4hyMEK46vHgwbyNuZzUhqVF42DwtugqUvpfY0uIAeDDGBoO86");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelDescription("aDWOQTQi3Ey3gifWeHNMSRzgQVNVvcWtpYGabyB29sO8xpmhEY");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setUserAccessLevel(72006);
            useraccesslevel.setLevelHelp("r95QiX4f2porvcg5m9kGCoy5qOyb65WBbVKxJBe6UrZR3VSXED");
            useraccesslevel.setLevelName("3Pwus9IQCaG7i55UIUVlGB1TOkrEIEcyVT8Ej7Mo74l1gCZnYJ");
            useraccesslevel.setLevelIcon("ckTHVOD0xaIliNaEtvbz5w7Bm1s2Dkoyssa55JxXPqv6uRWeRF");
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 111317));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "FijaVZtQZshxqxjZQKf0UKs1LKLorZ3pxI5bOn3lIb4jYYQIWfZtY74q1g2gJDMuIyaisDD4uW6xE2jCi39jIbIUM13vDxRkoZGtokPyZMlVq3cjMMBRUOgGLs1uGcznkiH2D6k6OWNNgMgqn5ZMuvJpDiXIYS0YNMKeuYKIOYuSlf0oTulPz2wTUqpNBSxkB0j81SL7VjmettwdO6IrZwrrihQjD8T3RbCUeYKvEsisMUQF2LQ4KQ9saa0Du336y"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "kTiRS4eSGaaDBmPouTT1I543eGIZZmuzeY9NGDskzmiM3p2nMGoEoAzMmHsSJwfOdl76W9diDoR3MoOG8shTgx2UNCzTvWHw6b64oafyrUSDRpuDrjAI2lcN6zdzdblyF8Hq2tFMB5pI5CZnaMisb7YIRV78xoS8BMf2STWPxPSyYB7pudOr61aWPCOVFYUFg9gu2EABPgCAupg7gL6HH2UlDeMARFqiNxALkEFUnERyLlPqjUH5B9HsWJhLfWNfs"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "6MNvrFYQTT76gaf9cZKHN6dtYV5WrpWsC72ivpYWq81npTJZtjoHgu4M66pxmLZW0u7gJC5i103iQPlQmWzsgEPLxgPBtLcuRrNHBLymv1W9oFAAtmGc6EGcpJP7XwQEM6gDLhdiN42QHZQs6xHW2MrJQk5jCviEv5Cf4ppAVjcFjsqekKxdye7jXX68FopFwT5TVwaEr6BA13qKuRa5JMD0TgWJUck9EW2EgANZ8uVAqbLsEwWP9MnAuKo37Ykyr"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
