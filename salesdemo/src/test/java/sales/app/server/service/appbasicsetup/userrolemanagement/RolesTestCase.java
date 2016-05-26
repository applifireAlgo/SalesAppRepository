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
import sales.app.server.repository.appbasicsetup.userrolemanagement.RolesRepository;
import sales.app.shared.appbasicsetup.userrolemanagement.Roles;
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
import sales.app.shared.appbasicsetup.userrolemanagement.RoleMenuBridge;
import sales.app.shared.appbasicsetup.userrolemanagement.AppMenus;
import sales.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase extends EntityTestCriteria {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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

    private Roles createRoles(Boolean isSave) throws Exception {
        Roles roles = new Roles();
        roles.setRoleIcon("PNBEfwxSKWNBFiA7S7yCIQleQicOalK890218IM698DLtvAhJZ");
        roles.setRoleName("AmKpMe6mc3bZWU2jfXqHEJBBtPRi2VCKkrKPoGCg0gOMuODc02");
        roles.setRoleHelp("EZFwUkpm41ivcfH0XrjK25hLWiUXeWfDNlhyKSLH5HdZuBYyVt");
        roles.setRoleDescription("G4GHTDMOijGcG7ZBFcKlaS3myTGxPRCMpHNV4PIKMU67WDOsi6");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsExecute(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setAutoSave(true);
        appmenus.setRefObjectId("TUpa64ZsD5uwV5g9TehzC2x502mAh1c8nRd0ZHesPacmQMG0rK");
        appmenus.setAppType(1);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuIcon("5EVIqIxx3KywNmxQWJ4bK1oLELHvY9lQkx4DJKttdFkz6TIDOH");
        appmenus.setMenuLabel("qTpIBnfutf8GtvtEM9YbU6QsNPnA6qay51BJENBCf3CBMYSCGH");
        appmenus.setMenuAccessRights(8);
        appmenus.setMenuCommands("ut06OmsuUM4obsGJzkeluVXfDv2Gy8b6t1bdrwxCbjy3Pf3noD");
        appmenus.setMenuTreeId("34jG46oIakGbwRzzFfNTHRIVoCXGCJ2JzVHKEq7spo69JPunIX");
        appmenus.setMenuHead(true);
        appmenus.setUiType("rVz");
        appmenus.setAppId("NtKwyja2jldIPMjS685hpwb8kQdm3Z9CSkpgvPZ3yKg4HaE98y");
        appmenus.setMenuAction("EkqDM4b9f5kKCtuToy2XmBQXapPP4kDtM2owA76jIf3Xw5Q6LU");
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setRoles(roles);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setIsRead(true);
        rolemenubridge.setIsWrite(true);
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles(true);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleIcon("rJFjzT8Ao5m389sbipYQZUzsYW7j0pvsOh5SbQBVBc99dpORcl");
            roles.setRoleName("DnhMXwUckQK2sCm6J8CwNpRB5pmI8wZerTEf311TfnNG4sOJM9");
            roles.setRoleHelp("7Ku6NLk4sqGsYjzib18afMyNXRPcmbbyA5xQlSfW1jbrGHApxt");
            roles.setRoleDescription("pZsSDbxHocKu23ttmkgK1y9XMMom4tYX95aGUxHNAIQEd2kSpM");
            roles.setVersionId(1);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "75nU0re4VKOp2VksezRElyMwQApWFxQXtRRnAYE3FkDIIaa9mvoGtIgtMeyT5KBszE0YR2e8HjGrMBmOtsDU2LDZ3lc0Q7XRt73NzzomQpn9g86VCsS4qbKRDsvJoNS5kquw5emtXN85QBykkUlpepRP5XosVhaL6OiAL8UYnEC2QixBSSoicEoEiLKMNlcJjo2vfL0X0iDMg4ryoPmCkEeYtmiFFnlR30nHw52UT3latGGv7Kx5zp6hxbiPlQnKS"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "3H3xcDHR6yIlKZ6CJJLhklJzwPJbm5vPk8rORD4ncn5QwYngKx5atkc10aOTb6MAFPa0dnp4rnpWff4syI46WgYWUXlBqzloGwOtCrOPknlLURFA4Cyh96bvc9BfQcuSQb0rCHtA2xns7of5gm5JyOJazha2zloesWcjoRugX0mpWgEaxBKCbwkZd1MYDe5PAh1H8Ftu5fs4tCjOrCw1w9X1Wush3hGJecSWqOK2NI6pLMYGFU8m6fhEjPE5TZ3sn"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "Vcvmn6oygj4tQ2Ym1AFW1MLJCIWAJHN2SKzO4hxu6wttSfZst9kx3rztWJvdDqptx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "VbofijWjQR5ll3oTjJilD2diRIQTeQHsaxCstpipAouZaogqFN60glL4vbhLBE9HcwK9futg9KcOgKefjOlibxp1UskRDnVgOSgbCMsID7Pp1RtFUI8vcLxAvvCc0xNpF3y65eXY1dW2ZyyyR5DBr4lMHQxcyuiCWLYrD2qWzrKJoZsF3d6qqbaTxefRdHlAxrl0Ya8wKPRtWVJUJHwt9RSaVXGitEONtrF92wstGzbQdZzcgNlRiIqWfNwVoyO3y"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = roles.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 2:
                        roles.setRoleName(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 4:
                        roles.setRoleDescription(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 5:
                        roles.setRoleIcon(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 6:
                        roles.setRoleHelp(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
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
