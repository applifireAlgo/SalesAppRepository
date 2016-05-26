package sales.app.server.service.appbasicsetup.userrolemanagement;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;
import sales.app.shared.appbasicsetup.userrolemanagement.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws Exception {
        AppMenus appmenus = new AppMenus();
        appmenus.setAutoSave(true);
        appmenus.setRefObjectId("gOFNvvsrdqmDQSuC8MHgXUDUbtXRsOYolaluijqwdXxDRnQmA2");
        appmenus.setAppType(1);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuIcon("rkXPj2wUn1mVFks06Ezhm6XuT5ceyEViXLQWM1wOOlRui4S4n6");
        appmenus.setMenuLabel("ZU843gMwxeUwOwUCWPc7Uah4Qioti3SW82ynKZ1pbp0wFklq0g");
        appmenus.setMenuAccessRights(10);
        appmenus.setMenuCommands("aOkW5XXPct5wqCZtDNdZY95neAzqNU73SELHvqVhF0ineh38w8");
        appmenus.setMenuTreeId("oZ33DmWmFs5d6L9UYexYXpveQP7rgliywYM8rp1K81bgA7D0Ex");
        appmenus.setMenuHead(true);
        appmenus.setUiType("DyI");
        appmenus.setAppId("8cXJay9JTxXtSA7bDrMle5uL3qnYadvhwugaVfORtJt7IQBNwt");
        appmenus.setMenuAction("2JwK0kxbJSOEPwrMIspk3YUuxHA7pi0DO27DT3cl5BmgGgS81u");
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setVersionId(1);
            appmenus.setRefObjectId("yG3gbvPCRHd8CXOfRnx0Rd38mlfJJOWjwmRzNxMYoReBpMlXXd");
            appmenus.setAppType(1);
            appmenus.setMenuIcon("7ebYm6dGnH6JkNWBCpiLhsbSIXTcNdnndztVhiQI7ZUZvhj2tz");
            appmenus.setMenuLabel("8piVpMGduLnuCBu8mryGHWyL6CMy7pp9lppSa0uhAPAidGQqSS");
            appmenus.setMenuAccessRights(10);
            appmenus.setMenuCommands("SjWhiasbbardrNx7kgEfFyUb0aUUCsGwSFQtBxkEIhqzSPSEy0");
            appmenus.setMenuTreeId("rA0RlVqj4zlHKKKi4JmmnhMMkrpPmwWGNHwxd3fSNfGnSm8wWf");
            appmenus.setUiType("mxX");
            appmenus.setAppId("tvHnr5iM5hjIO2XyebyGtA94xmhI8EHu2CvegSI4ou6fbdDNuC");
            appmenus.setMenuAction("x1mqVX3cU9xIa3ehv8oXhwLpw5JeCp3ewFLrVqyJR4SvG7980p");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "Po7veKycY8MCAL8b2Mx5h8Jgp1XkvVIg5umZuBayU81GdlAti2fZydHlSDPUb2KMYFZUHvBPUNMRoeDOysAwTdTHfj46kNtbsSqBfvopzYpokAD6GxeckjGJN2tZ2PyfBCPP7jWAUODG1bJJtvPO53UsrfSBtOUFVc2tpyCDBSxb3GFKE1zGtWELenN6H59m2NnklI57DUnrmQNKbfOVDAukWpmG7iyMFG2yPTXQDTrbhxLOFwR5bROrUuLYvvvcX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "C8zSXlUNf4ZacRaNeou3Dj2vRrZ17OakEB1o4giKls3l9aQqcLpdc3whPiNy6fTNR1SDjkv3PRiNJ6KGECRp4erZpSoWZC8QCKN6mtmRo7FmM28SfxOmthtWrfEnr2twAQoXoO7sZOM4RDGVlxYynjA5GfGFApgQfY2yb5QMbwbok3HJtC0HU6N4KgRRcAmdqIvI2FSmXRRsTtNJghW80CQzIjZhHUcXBKJT9laiqGcSK7T3LTtpl3wk0yzzH4WUn"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "GzpZJQWj9793lio5j7bte7gJvj4u4NY0sDdYgUcbUjJQH872vwK0s05fyRGeFpCtViJkmjBJiOOJJPDOub8GRkHHnCbNhDqtjwNfFCG6RodIimfqsnWwZdbfBEyHeMCRA5NOgu43UzaymATMcoj2JsgeaILDwE5vkQ0XyJnkh8DFgUnQR0Kx13FvIEgUml7Jn439xJYeoNfEzusJDOyiBetj3yqIuIE80PXzurkV3mZlOegtVck7XysRVdRaE6SPz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "jkXy2p2PFK8gZzbQmJDOM08DWNK1l2lQbScydGXIuNyj4T1sztxYXqx7pVREQXLTZ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "lnrMyBT51JsF3IFisH2TXbn63HV2OBACg2mZvrIlxIK2qQhhJnhGGhJo7JWRXFJ1qPRKEwVyIeidLIwgITYcAzXlgbmRDuYT06JSaX9OOd1yIXBscBzJ5cGo0hhj56SVzPFakPAmFNNXsMK9x3hBWMuPR3LaTuFmIrY5kvsyZEL7SuVl7lO7ggXuZpPuoyNDoRvS7CPSOUEtWkQCTkYlTq7czNjeP5ZrWFQDoLxRXRTXfvwKz7X4gjc7t1ARKp4dZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "ggKp"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "DsiZNTj8vBYDq3LL2Omrfu7IB67ZPwBxnezJIHQrUKTfAlYpyesMXC6IOS422D9EYcqJSijzLYYRdR6ZDAd2bdjuhaQZ6gdz7wEdWaXjOm8GQILJXkJBcbN3FdVKziWHsokPVzgj3lbNzN9nb8omIRgsBz4MJVQVEIIAfvwwLZtO5p0LY2JfaoZ3Onaz6CPQZ8UZp1SzmrxbGn0jkxncoZ2prwzFFSxUlLVxfL3qtHlKgFhpxVK6j9Mrj65JE1oWd"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "vlWrc52vbLpHUWiKYAxtDSrTF90a3Oqpwu0XNxMzJ8DTdISIioRhqqSC2L7trGLd2lF6TDxNQMqwh7JIduOiA0V4rH7jXkSALNBEbfxJQ1i2ZZqqpmvkCFRfoGRfabxlaIb88bTsnfYZt6AxDDf9VaiYxrGdlYNPpoU22B6XtigpWkD55Y9vrZpf4Cn2g7fREG0w89wQgmd01JCXpHl6h937FH5ayDEaTeFmBKupPQRFlO0FHm0gfywl2PSVpw8tO"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
