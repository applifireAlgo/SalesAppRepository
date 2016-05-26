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
import sales.app.server.repository.organization.locationmanagement.AddressRepository;
import sales.app.shared.organization.locationmanagement.Address;
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
import sales.app.shared.organization.locationmanagement.AddressType;
import sales.app.server.repository.organization.locationmanagement.AddressTypeRepository;
import sales.app.shared.organization.locationmanagement.City;
import sales.app.server.repository.organization.locationmanagement.CityRepository;
import sales.app.shared.organization.locationmanagement.State;
import sales.app.server.repository.organization.locationmanagement.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

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

    private Address createAddress(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCapitalLatitude(5);
        country.setCurrencyName("Wxii0hVSNrwF9K5QBY6A45u6eoDXmMxc0d451baphY6Miym8qD");
        country.setCurrencyCode("brR");
        country.setCountryFlag("bFEd5DYxaLMO4miMBcK4Q4nxRHBDnOrC3DOT0gnCBrcvHP2zAh");
        country.setIsoNumeric(471);
        country.setCountryName("QwQCUe3lWtNNAMFWbkW9DTp0sDWQntTq1PV3A0awwmp3yFm2v6");
        country.setCurrencySymbol("nV2wTmUi2bc9DN3JLvnzebMZrRhuqMjb");
        country.setCountryCode1("eAe");
        country.setCapitalLongitude(5);
        country.setCountryCode2("Wzp");
        country.setCapital("Tq2JOH7V5uPUUts2y5N1ImuEFoov870p");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("c1MfXzWkSxXgkkFPcyFfbDbJGSjQASa7wEUu3k3XaPQaTwxytW");
        addresstype.setAddressType("Uc2LrE0va9iTjF5fxFXMD31C0XfcriMUhuwMHF9wep4DgC2KP1");
        addresstype.setAddressTypeDesc("ltLPaGItzGx0o9KxBEcpE5TUP1S9Le3UX14PyZdTPMrauFftrQ");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        State state = new State();
        state.setStateCapitalLatitude(8);
        state.setStateFlag("Bqy2Stc6MBVTatW73LeAUCqGh4Z27yZgZf823o21snpiI6GwMF");
        state.setStateName("Kt0O8mtjtExGro09C38iRlcbq7CO0l5DEqCOgrC4ONeoxRmJfW");
        state.setStateCapitalLatitude(5);
        state.setStateFlag("GRjwqy71guq8pFxNogQB3cDqP5R37oNNi0Ygpwcu6baKRvdLr7");
        state.setStateName("4G2H02rnfO7IKZG1e3Cyfz0EqgBxBGcI1LY9Y3J1e934Q373kn");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("pU0ZiCC6HWyuFS7FDoQSilZwX8Mfeekz");
        state.setStateDescription("cPSNSSP05i1E3MmCvAZnOSCBNTqgEPkRrJTgOBzrJwNfZ8UcCE");
        state.setStateCodeChar2("6Svmy6kX1mpa8lgiLpuiUUqTL0QAJm46");
        state.setStateCapitalLongitude(5);
        state.setStateCode(1);
        state.setStateCapital("DOSrV1UvkzkpaAsCb5dvIPwjkNcRiekvjsH67MVRWwIP84rLap");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("u4FsmvkAq6oeNIOJiy3FQP8AHRBB5Rar98bqOGAYDMV7jRKBJG");
        city.setCityName("1gD1vfa0dfXUrBJZpt8a7QzxE68nVuf7qL6JfchvWkhOVwUNxb");
        city.setCityCode(2);
        city.setCityDescription("Dl9jn8d38STlzinwc1L43JX4auDiXsLJ97l3bTdGTAZrkg5Fdv");
        city.setCityLatitude(1);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("M3fFZy8WK0jfUIy0L0QmqSepzBuIrZpL");
        city.setCityLongitude(6);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        Address address = new Address();
        address.setAddress1("2j5IATJgTE7GA4Qaj1b4VN6KhHTFlfsRlfrOyeaMwiFnFtacFb");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("05qWfS");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("C16uDQwrY2HteHj9KMPvIoRPQ23ObNkLBTa5WeNC7CUVW6pBIx");
        address.setAddressLabel("YUee1J30coE");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
        address.setAddress2("UkEpmIx5W7n2x2S9dVr6tT9p8Z25N2z1kdfTjwBdbJZFIBE5Qz");
        address.setLongitude("vxFZ1thrVTkIhxOGGi8BgaI92RQVcuvQHBJ90P5u3kswzvEZzv");
        address.setLatitude("ljbPzBTvXXkNIcJJYsCqXnhBtPGsBsdxZa1cAzU4pMzdrmky0a");
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("IHv22MpZIkgl4OOF07dOKJdixiUjNp09GsmlkalyVYdDCtxBuw");
            address.setZipcode("T121RV");
            address.setAddress3("mvfNmR8GWl7tWdJQ3gGvDvhepYy36R6qiGkZjOKfougbHbOYUT");
            address.setAddressLabel("NaMtkKZ2FWX");
            address.setVersionId(1);
            address.setAddress2("K34Q9uU90UJP8wPnxPZFxZiGTWifOfWsn4TDn6OwowwlALqZrp");
            address.setLongitude("1XyjBYMu9fQ73PuL38i0jWOT862ER2XDiwWrJwEwnscxp9Gdu9");
            address.setLatitude("BrmtuPY1SbWCyFdmIhrx0ayCC2iXjcjsu2Ue74JqJmTSjcG3Xs");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "EyjWZJJ65Ie4"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "xRN3rS3K1dGVLtvuVx16xdECw84ToWZhsDWo0a3N2RjXBkZv49cT8tgGf"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "TX8KQHPIV5IuYh4RGZstSnb1Ub8LVxbv0LmurVKguIzNF13MSLdalbt0m"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "hrIli1hffpYBoJOiOJx6OMmkJ3NHePzb85x0RydwPomn6KKJ3qLJyHtUq"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "pwT23tV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "vsqJLMdow4zIV7CDyXEbnQtwozNmlRP2VFGqjB7gAqw6ceeIXuWzGtzUDMjFuBs8m"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "XnOfIAv1LcsUB8fC85kMtStjbzJB29ip8CmyBDE9eJDU1yR82meFacdjhhCl4p1i5"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
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
