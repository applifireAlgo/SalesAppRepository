package sales.app.server.service.organization.locationmanagement;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.organization.locationmanagement.StateRepository;
import sales.app.shared.organization.locationmanagement.State;
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
import sales.app.shared.organization.locationmanagement.Country;
import sales.app.server.repository.organization.locationmanagement.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCapitalLatitude(10);
        country.setCurrencyName("iV3GhK3k7z1olS1VK9EvyaB0l9yWJq5Zwt9gm4SZ7dtrHf38i2");
        country.setCurrencyCode("BdG");
        country.setCountryFlag("5QnWg24OzKWx8hm1GPXT7Y8eXHm3BRAgBVQpy0RLCYPhHT5VF5");
        country.setIsoNumeric(720);
        country.setCountryName("3ffAOzUBujQ3ciKEIVVUiTH3RpdCthUxudktJjCjJ7zx2L3wFc");
        country.setCurrencySymbol("s2ZwyOQlQEJIhdjXQg6UCyCzhRxb8oKg");
        country.setCountryCode1("Ld1");
        country.setCapitalLongitude(11);
        country.setCountryCode2("SGU");
        country.setCapital("0xGZVGLAGBL7veqkXJd1BbItfCRIih0l");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCapitalLatitude(1);
        state.setStateFlag("W8wcgO2ApBsIBfBnRZxI01MPQompJkXtAoCNlY28YBApmqbzWJ");
        state.setStateName("CG3gXkVjj0GJkWyAqZ3cRI5CKtW8r1eozyHrho53NoZv8y8a0J");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCodeChar3("g7FWfQEPvzwNfOD3fKLOdQWJrvz9OPw6");
        state.setStateDescription("BjE9YGGh9ERscQsGeJhheOE8W7CStLtEOQmuCSiiLO3ag3rKZC");
        state.setStateCodeChar2("ITca1aJz1NU7G1Sqp4YcbU1dra50lcA8");
        state.setStateCapitalLongitude(9);
        state.setStateCode(2);
        state.setStateCapital("cISKps5zhOVmtsl9VnIW0Zzv3IzjZlSrZAsqE8V0feXD4Gl9WV");
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState(true);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCapitalLatitude(5);
            state.setVersionId(1);
            state.setStateFlag("NnBisuXEOBtBwpkJQOrKvoU1k568x4bontiJ9PHA0DpTJXGyAE");
            state.setStateName("33f8DrpFaqZkdfElUSnwy4ZYIiKHLJI1aOI5ed63qcOskvqeUq");
            state.setStateCodeChar3("cX7BbF3ao8xYI3ZXnLMBKMhSKG9NvZtC");
            state.setStateDescription("1ii0MpqEiRyK2BffRSI6NXK9CGyHZvPhLzFMifj2rhvzYQ4PPt");
            state.setStateCodeChar2("9Erxt58RjqSqKnrCObMTPB6fBBU3FeTU");
            state.setStateCapitalLongitude(7);
            state.setStateCode(2);
            state.setStateCapital("anejcO76rlYtfr9Kwfsa94Yn4YQd8zDRuKDkE1T7ySnt0cQdO6");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "FXcb8KCd4WJIGgmMoueBGpzNqcaEqhwPJemC8QoegDOEFvR2ewiHV446mfc2y3nzLcfpFrBt0FRdfui1z7jfdCXHxie1PwJZt3UWLtNpJo02KRj0oliuPURfYKT2A2GDUIOF7jaWdzWs1jNwfWHNQIFnTD9jayjjv7d41HGHJsqvZKU3OLkuudzhzl58pYUf2YXVO0eIuwwUxQmpXaYWvcddY7gwlVosLmeWrbzVAjimDkMPiWgAGRANTfCZpPna8"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "raYdjNaMU2qBxC5zushSiQhosDvrpxpDr"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "b9V947t4o2qJ3MyEjlSomgxcWkBaneMrI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "ZUDZt3BWrsBSqpv9ped0maxEocm8bHqI9zqDDCQT6dpxxAyGPPtWxFNNpc5iyR04W5kGb00cxBacMw2QCvChgGD6rOPLG3lVo35sR76Dnymp7wYTLhcBeRnxh9mYVN24MsNHvpryLhwxoYFfuJxhcwsvsYLlnuRIXFrwvQBzLMZq1v6JBcWy6rVPBvmidkezITH4KN7AUnRtAXPCQRhUhHHJDslgTQqsWprj8vybNRErWBJxJtuvsq8iOYsm5CtqP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "ppr42tHuYtZQ7NwejLftlXgiaUKHHyZD45HwRVcORJ04yyDJWArIIrzNNHm6L3zTkY3iyxjyOQT0c93szaivyfcv4PBgyVySxah1GYBMe7GgliNl3FI0zsE7CeCdgbaza"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "pkUdOWJpADQfyrE5NJuKrekawLgDJLTvX3e6SROS6fNQ07Klcn5OP0iCAsD3q8Y6EgOnJVEGJjDUH8M6Gbexq6GG3Dw4bZhuSJPilq8GeXajS1sUJa7opRe5LdY8vFRkV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 14));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 22));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = state.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
