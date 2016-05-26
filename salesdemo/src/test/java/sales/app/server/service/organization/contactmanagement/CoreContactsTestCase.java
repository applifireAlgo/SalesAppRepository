package sales.app.server.service.organization.contactmanagement;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import sales.app.shared.organization.contactmanagement.CoreContacts;
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
import sales.app.shared.organization.contactmanagement.Title;
import sales.app.server.repository.organization.contactmanagement.TitleRepository;
import sales.app.shared.organization.locationmanagement.Timezone;
import sales.app.server.repository.organization.locationmanagement.TimezoneRepository;
import sales.app.shared.organization.locationmanagement.Language;
import sales.app.server.repository.organization.locationmanagement.LanguageRepository;
import sales.app.shared.organization.contactmanagement.Gender;
import sales.app.server.repository.organization.contactmanagement.GenderRepository;
import sales.app.shared.organization.contactmanagement.CommunicationData;
import sales.app.shared.organization.contactmanagement.CommunicationType;
import sales.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;
import sales.app.shared.organization.contactmanagement.CommunicationGroup;
import sales.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;
import sales.app.shared.organization.locationmanagement.Address;
import sales.app.server.repository.organization.locationmanagement.AddressRepository;
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
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws Exception {
        Title title = new Title();
        title.setTitles("2ABVeY1QJZjbGEBg6c4IXfCpYnhu3fOgy6BZ3Ujlar4sjWR69s");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("gLxmUiiH2pUWf2OAjqasMNJqCZTvCrMZyFVlvMK6muG6dxyYgh");
        timezone.setGmtLabel("LIhlQCe6Zwi4XpzsAb6SwB3kgUUQT1iEGrzisbKtXFOKOBBBKz");
        timezone.setTimeZoneLabel("NkguJ2hiJjkl4fJerzW8wU7JTvSf6gBbbMFeO0nI607wIvgjsB");
        timezone.setUtcdifference(1);
        timezone.setCities("MvESCvtim0KSiF1FgrErAPK6R1pPwSlVsAEgrMK1YmoORlO0k5");
        Language language = new Language();
        language.setLanguageType("QcnPKJYaoXKsjIFnhVOOxiMYb0bcDheS");
        language.setAlpha4("nveT");
        language.setAlpha2("En");
        language.setAlpha3("xhU");
        language.setAlpha4parentid(1);
        language.setLanguageIcon("RuwhYI9sUyCN2jigEDgkXnniDCzkg9S45ZvPDEad8Ttr6Mo5I4");
        language.setLanguageDescription("R56dV2frfWjltmRcbQJYHGRXFV1TJ2TR2CRdcu1H3gB1uXSCXs");
        language.setLanguage("XzAhx3vAOtBCG47ZFyyDwWHUHZhurgDKChsNdvPHInr3ZlCMmw");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("jpCxpk0AaO1auemRGsvFNOrsdutYpmpGdzehuS7S3lEpCVxJB3");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setDateofbirth(new java.sql.Timestamp(1464159394885l));
        corecontacts.setNativeMiddleName("j7SC4l8eYCUCEuyMGza5loefDQoVIeFmUH78m8RC93xwW81t9R");
        corecontacts.setNativeFirstName("BfRh9XpUfmQZVJNNvJCdXSM72JOtZ12xNQDCtyEYsBvyAXqlEo");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1464159394885l));
        corecontacts.setMiddleName("poYcVxTFNo7yxbXMOwGNFYju8wYc2wEBZvcZ90t0bMr57lxUgn");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("jU5P8EJE72qbWq1q9yhF20oplKjYKhDj6WjWNpCDcj2e5hsbBY");
        corecontacts.setEmailId("JDAiqq1p5XYewJlTY6VKVJibyO7qbJcFtnXIqeTHDmGG5o5Nth");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeTitle("ZGbOhvhanAQJfV0Tu8CT5EKNGgFSuLAfjUbM0u8ooZPaXqgAsh");
        corecontacts.setAge(6);
        corecontacts.setNativeLastName("vYgTDaJbTw3RoZEs4u2oNF5jd8xorXP8MXRKVFvqVlQQgvflMG");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setPhoneNumber("an8qyGVnSyh1vJXk8wCB");
        corecontacts.setLastName("DXIbvPomGiX1zzI2vSAqDdlq2VBumsqJ5XLMGhg3hvh04zlCyk");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("WYJPk3UrlS");
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("oVQKLMjgFNlP3ay9L8GsbIg1j3PR3MTbfRL9L8D2yA5saea54x");
        communicationgroup.setCommGroupName("MeR8tUZaoXBV3PseWknNXlZhZ6HgLIx1c16SYdlVzBmC35iSHb");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("5WK3nGYnFBGzpeQbFrX1oHRwhMdRHv1uqxUxsIYLZ6VdKJq9IF");
        communicationtype.setCommTypeDescription("ahiOzZaK1M50GdFXXXCvb2Umg2swcy2Yk4lJRToUnTGmTdIzM4");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("0P2AX5XE4V");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress1("ppHDYoJDMDv4y7dWb2oAmbtePLLny0OmxJMqujI86rLRAba9HK");
        Country country = new Country();
        country.setCapitalLatitude(11);
        country.setCurrencyName("cq11HxyeCSZedh1vkDrYfEdc7bwk2A6k3EBAhpUAcY1biOwC4C");
        country.setCurrencyCode("hsi");
        country.setCountryFlag("Q9daOdzGZso84Ij0Ks0LihIlg7lHjYidfKJK2aJrR9tDUUBy1D");
        country.setIsoNumeric(152);
        country.setCountryName("uiGMPkn4IrP6HKyZmdiPlAOwsgrz4qNUhcBA3V5W6nNn93TdWx");
        country.setCurrencySymbol("qRFTaZFmPEuB2agPlcT5WoiRo6oGAI64");
        country.setCountryCode1("e0o");
        country.setCapitalLongitude(10);
        country.setCountryCode2("Q4t");
        country.setCapital("1eKjVqGo8eHpHb4Kytp3yZl1nfgmGDGF");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("FpfXjv5nKxbbZ4Kf0pNMC4vh1GPZCjzLPzPhgZqvAZFEHQ9Uja");
        addresstype.setAddressType("KBHOW81VBbmsuVmzJK8yUJnYR9oqDht5vbqWckMnUnKGVjEG6W");
        addresstype.setAddressTypeDesc("O4zHVcIlHQUuAiXpU0n2naZUtFwX6LONBlwm5Joqi9JZPvCgtI");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        State state = new State();
        state.setStateCapitalLatitude(2);
        state.setStateFlag("cVBfDUk4mgUiE1lW8g5lGzjCY8FqSN9QqFNx1OK2sNwoHxxbsR");
        state.setStateName("mtV6rjpBImLcH22g7Ouxkk2k68EJds4y3ZxDMYhP1G2Zv2MN43");
        state.setStateCapitalLatitude(7);
        state.setStateFlag("DKql50eKOcQcBEGq0azbRBwozxe5KnTSKXrOGIWUaESP5T13qF");
        state.setStateName("SbLkFvQaRdxrOhHy2jQWWCbsIJknZz74YvTb71WtsZJru12a98");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("tjbYlgNDmjIvB7ILbvQvtDNIWZHQQyXa");
        state.setStateDescription("uXnY2ywisxOyj23zQRlI9WNi2q7UwiJwaPg7SMICb6zp7Zs2C6");
        state.setStateCodeChar2("gMXOEfjTkVNo2nZDY9sIVsCRFz2HdpjN");
        state.setStateCapitalLongitude(8);
        state.setStateCode(2);
        state.setStateCapital("XHnBgA7I7z5yLH6852JOaPtivdwBRWUPmFBZ1CCZ8rBpZYsDte");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("Sy6l3M3pfv7SOZ0xaDsDg5caGrd7L7ASnC4s1BrAscQkc484oe");
        city.setCityName("pMpnlz8VJxRWX3zrT7Ta1un8hk0pYivqZETgpVFp2LT0AHbP2r");
        city.setCityCode(3);
        city.setCityDescription("okznmIKiOUY7x8nLiAXcnKPVjwTHPfbezkn0rWMNqmKWTXkN8O");
        city.setCityLatitude(3);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("5amGf9aRfDs3jqBtkmR7BYljIlZHOv5O");
        city.setCityLongitude(3);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddress1("9sSxcn0EATQKDRrvTMluaFCsX09HKfKRj3b7GbdzDHCW0OuSYw");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("pIIGMj");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("VwCpK365VnB7R6ghqGdgdL8fRNmBL5UEpeMnAfAAPlPC6SguPR");
        address.setAddressLabel("QFIXjBEWdjV");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
        address.setAddress2("ICbRxcOGmBLGvUAwmX2D1vVYhUfNUsvzS4hBJwVUEa9K4VAkfP");
        address.setLongitude("qU0kDDb2wrwaPZfqYsacWL5hcQVmxTn5U4eYNbOaMjCpZZjj1g");
        address.setLatitude("pHWj3m67Q5uDobkhmywbKWBtAy52DPzrztLxqHipcqbntxPxcX");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1464159395379l));
            corecontacts.setNativeMiddleName("lgnccKmCEbQwpHz9yCIh0DssG52qjUNfM9iXVmLM1layvSpD63");
            corecontacts.setNativeFirstName("4UesX6g3XHbaaK0HPO6MNAzPZJfoKcbu4axUc9IMsA4jtH6xkL");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1464159395432l));
            corecontacts.setVersionId(1);
            corecontacts.setMiddleName("CeRaamBRPTpYCMK09VWhJOp5JMJlv6hKB1ALTdqX0JdUGSQ5mS");
            corecontacts.setFirstName("d0L2VXMdIfvnKuVxZM3prRIVDtY1wlqU87ppGq5XuTdzy7q9Tv");
            corecontacts.setEmailId("cA6BHHBP7ptatvU78u2Mxw7T631d1DqKpS9P2KGHHiPUwZpAQG");
            corecontacts.setNativeTitle("d86n9kKtnjRF1JlC2AVEn1ibceWIce8qnLyafH6q2Z9B9yKAN1");
            corecontacts.setAge(32);
            corecontacts.setNativeLastName("yaHRZlE57Vf2JptfakLIVAUZphjh9e1CEMTmdNpxDYjlM4LgGM");
            corecontacts.setPhoneNumber("ENFUDhzCWHxtGylZbLjo");
            corecontacts.setLastName("guUOMvxOrLiwDhbMo91COBOjMVNY6N6GDDWxO5B2JCuAhLoJTf");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "6ka0HlnZ1LB4mZ9f2aackJVoM23fUm2aRRr0NkjrlgT2Du1U2h0UX6Z3r4NaWQbQ9HExX7D8H911sca08EXPTY3DiKAvTeIr8AK1PFnwR2UjxamvT5xIKruVh412s3qaAIblMZNJA63GIyC4XkZMmy02KAZ3VUvjrF2URO7mh8mZzX2EDfyP5Td8lqBXDsNeLjSZohBftmQIbHGXF0UiDhSNCHzpleQTNGw0sZVS2dKq7dc13pu2wOasiimrZrYWF"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "UNFYdZangms0rhf22dVk9rLgV1Y48NbFD3uGAAGTZXoWGbt7XSLnFQxr7tZA4QgsJhrH6IYSTr9yV7vv0SbfxfofeVu8cffcMWUSkdq82WBxXR85LXiew3SKztjtuswOvT2ZYYIlPT65rlJ8JMweHeMAmKtWr6bWcX6zLbl1eXSDSASfqarFBRWuicxAZe2e8XCrnKgLWYLKrRh2viiuHDXxZJtHEEK1loqeBzL6llpyp6zJr9YHAWae39y4pj9Vk"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "CLWZCOMVXhIVcdf64Ow1wBf2OTXU9JCT42RLXWcWLGhxbfAX0KCHS6MYPuVj0nsEleXgQGFE4iv0657JlO6QQD3J4hTxxYnx1fN0SEcbbb1oDmMA2ZmZAFU1MN17AsOgf153LU7DmnQiVoZIoOnaYbMA6RWkK1UTLzLmFyqiYIBSthLbxsuq41OSMVHrs67SbycKkP5fU0FzJUCZepkLmVA0TNnLxtDV7kDL0Kdif4ofjuechZEc0fMwbGaV8eaW1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "h5bkJsMazkn8rhyjLU2fmOvafvX1QwhKGz7eKSpqtyngTytWYeoX5g3wylTtsAOqa"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "HHycyLZ0Rc36nfs2FWsgTPfOoI4uUhu7pZySG9kUMtjJCr0HQ6Mo9NAO524aM8VimOcIaH6TLxWTyDAQqX9lycRotHntfSScPU5EPNBbt98I30gE6AC1RN1VqmWBrr0llCDQBLvVhc1KjynzADp9Ai9PdHhljU93Ta01gm1yLT24gWQIFOcvHIy8dRdbR8e9LaI6DTNwaaXDtmfoYkLyDmjMI75HxviusNt1aW2HTPKRfuajjwLCCi0LXiioBuSSx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "LSitd3ObvuM9uZVmd65EMANhhPlfArCOCfZw2ESMEkyF5174jp2QraPfTGE8dRxEJoBcVYiXGaIv1LUnrfsy6HaXJmDJBpPMf7ZkvNCgO9dljbmBtnzoV6sBKfpwWcYmnKZBDhei2VnMqVOOO4jRkbjn9dqp4JP6ExK5jile552PimDCUUXV5LpA9vx4BZrdIl8bguiIQJ1vYuZP8OHuFhgaLvmNfTgp1CXcP2x0CkWCmY4jNaPJuOY38E5pT7hVa"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "gQykoMqGv1iq1NkiiCE7PAqhD5EWIxrz1bvkjUGLuw3ob3CQ0ffmaVC0muBQNUlsnVfv8QOL9HR4r2K494COghiONxqEIim8X6UxeW8OMGVxkKbvTbmn14fJtlHstQDDLupIqnQydnYXxGRgHjXDXrxBCIOdDVCKzWnsSKSxRmC9b3N6W7xIoJKLcCbpALSOD9yVTBKa67PEfuDehddI6fhTVJHpDsWyDNR9yP8Ms8xsOHYJnLJNIF8vBuLJNDIlh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 135));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "CzEqS0uot6gesPXuXt9EP9MOa9tF77AINpeEmJmuHzHEo9zTSUClqsdufdbLpSVsiHnqtnBHM6BpKYjSRKs6ZEpiJ3DYvc6b0zJ1T4ZWuLORl263gx1x8kLSwdLkVcDJhBwc0dVBSP8979yHzA59vXQ0ji1ZKcciFW2gNvxAfcbJsUqIiD7eRbj5FTNXNgObNk5wHJuctyg9RHAJas5KJP6IyMt38N24e724CBrVSwYvdmcVIW6I4CSREINreCjhM"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "aZrQH5agCdJwMRMQRCV2m"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
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
