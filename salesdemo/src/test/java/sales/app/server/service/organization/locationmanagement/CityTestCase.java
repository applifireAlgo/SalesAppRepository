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
import sales.app.server.repository.organization.locationmanagement.CityRepository;
import sales.app.shared.organization.locationmanagement.City;
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
import sales.app.shared.organization.locationmanagement.State;
import sales.app.server.repository.organization.locationmanagement.StateRepository;
import sales.app.shared.organization.locationmanagement.Country;
import sales.app.server.repository.organization.locationmanagement.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase extends EntityTestCriteria {

    @Autowired
    private CityRepository<City> cityRepository;

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

    private City createCity(Boolean isSave) throws Exception {
        State state = new State();
        state.setStateCapitalLatitude(1);
        state.setStateFlag("MxZ6bYkLgsYQLyqF8X7fWlSAgXJsfJ0Rwz1HJkdgPER2Qud34O");
        state.setStateName("0bxwnoK1pHokg9BC0UyhaPgHzniSmTJIcQvJNjG801SnjN1UOm");
        Country country = new Country();
        country.setCapitalLatitude(3);
        country.setCurrencyName("DemxqiOAauGCDtpogRcDMAIXFWX99Nfn9ifM2CbcLr7kkB8hsu");
        country.setCurrencyCode("GPI");
        country.setCountryFlag("L2di8IcmGNRzekaByDNO2rHWpOkTZakirPJvVGUMIaPr6vDbdo");
        country.setIsoNumeric(459);
        country.setCountryName("Mgo4wBfqR6I6M09yf1k6RHQq3ASFZ8SxVtr4AUYGgnYfGi15AM");
        country.setCurrencySymbol("nnzhDoOxBAdkg0wo7o3nhU9Dbkgp9AB7");
        country.setCountryCode1("Gp6");
        country.setCapitalLongitude(3);
        country.setCountryCode2("DHW");
        country.setCapital("Yvr57pGgi2Y6s5r5pCrFEdtVpMZQLzDI");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCapitalLatitude(5);
        state.setStateFlag("0oOjg5z8uuP0Qt7L0bXxWyXd4VmveOFVxQwYKoxXFTWBhUrv4v");
        state.setStateName("OND1T7MIeA9aMXZCm9K8FzRdKo5lGRtECNg4mL2lr7DRvnIqcR");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("HjWXBuxcYiiGOXwuzBw4DrDkhEYzrAoM");
        state.setStateDescription("icqLQl5kjFmBIl1pI7k0HrnNRjk0AvWZ2pnEEPLlSAiMegEWdW");
        state.setStateCodeChar2("9fy9MBLOzniaBQE585j4SD52pZU7l4eN");
        state.setStateCapitalLongitude(8);
        state.setStateCode(1);
        state.setStateCapital("uSaO6D2pNn7NIQznD7nDptrMMkEmysPuBd8CIXq5CzJC7fnWjj");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("lQvehjSz9DUMStoaSeDRVckTFNhnlxZQKX4aBnI5z0B1LNrAQl");
        city.setCityName("4hJL8Dj2VC0P6M5cVpiYcXUxe4IpcyNL6tlPIIWj3GaZ828wvW");
        city.setCityCode(1);
        city.setCityDescription("DT53zgDZ76gyZ029inU6kOIX5rCSJ1dGSsZRwpUEvxvywcagta");
        city.setCityLatitude(5);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        city.setCityCodeChar2("UlblWOiC4Sicgv7HsEd7QcaH3P1n7n2J");
        city.setCityLongitude(6);
        city.setEntityValidator(entityValidator);
        return city;
    }

    @Test
    public void test1Save() {
        try {
            City city = createCity(true);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityFlag("02CMbZ377hmn3EjqNLnj1uu9Q7YjWy2vuCvJXdKNygUtc34kPg");
            city.setCityName("AdYC0UU73KJ3OdWBiFA7D8PJDcArSxKnGEBT3H3vlUiW0cnz3u");
            city.setCityCode(3);
            city.setCityDescription("DLRPrinzA1bnJK4vWoIqW58rIFZSpPelqJbwdQAUepLTwoi2FV");
            city.setVersionId(1);
            city.setCityLatitude(10);
            city.setCityCodeChar2("XG5uOUJwUMigAKI28exv61uov4Ws8YfK");
            city.setCityLongitude(7);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCity(EntityTestCriteria contraints, City city) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            city.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            city.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            city.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            cityRepository.save(city);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "cityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "cityName", "f5QQF0aGmS7mIeiv4Wzdp07Y3F304VYg1Gkoe3MZNZKZwLlrClKxUOxjhF6oXnp0P5MzpqVOd1TIAfw2FYF2Kj7mSh8fpoRyAV81QziSS9mRYcbYqLKeHAkopm5v8e7xxWtwieyTCmfYsaFw76yRnie84IzMftPDLrrO3z8YCF0Y17rJgsLa6zomihvZA9caImUWTdvGleF53XkJRfyh6YS4ygRL14igS4h4FocLnPT5kQj4ut3K6w6xdxnq32VYM"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "cityCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "cityCodeChar2", "EWDrBS3P7keJqScsL9OgXsCr6luQbl7Gx"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "cityCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cityCode", 5));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "cityDescription", "wy3UtPft0KKdED2HhQKxGiRcROcPKq6eMAk14Z0eLzyZmhuQBmju1XClfFIiN6qA96UeScxF1mdEtBTsbQVKHvUk9rMoc3Lqohtrx5PQdXZxeqN7yzGZtFygE6ugkEAiF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "cityFlag", "J5JcEPH3y4QjUbY49zPWrj6sVAce7ChhAXI1o5HfhkWFl0b3Ny9xkJnZQfH13BLgJmrhVX3FnCXXD16TA1gnFFWvz8XZxkLmBdoaQg2BFjsq6NEAI1qucY62Hadt3uf7s"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "cityLatitude", 14));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "cityLongitude", 20));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                City city = createCity(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = city.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 2:
                        city.setCityName(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 4:
                        city.setCityCodeChar2(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 6:
                        city.setCityCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 7:
                        city.setCityDescription(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 8:
                        city.setCityFlag(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 9:
                        city.setCityLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 10:
                        city.setCityLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
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
