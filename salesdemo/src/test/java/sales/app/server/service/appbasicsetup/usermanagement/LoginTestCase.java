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
import sales.app.server.repository.appbasicsetup.usermanagement.LoginRepository;
import sales.app.shared.appbasicsetup.usermanagement.Login;
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
import sales.app.shared.organization.contactmanagement.CoreContacts;
import sales.app.server.repository.organization.contactmanagement.CoreContactsRepository;
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
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

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

    private Login createLogin(Boolean isSave) throws Exception {
        User user = new User();
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1464159402033l));
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("3NlF1wjG3WVzqKFeP1Ho49fVmLyHvgpljxnVkhKy5e7zYCwVdn");
        useraccessdomain.setDomainDescription("bYsaW0aWJevt0N2SO652qv7aA5cF6LBrFizloEGVMJv22WVIlh");
        useraccessdomain.setDomainHelp("xhjlPmJqwifJvv513mAubAeyepPVxBNlAGCWDRV9UJBxJ08j4o");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("OmwAm1yOcZUnQ6Ig8ERCl8eNXH0KzKs1u9QZhxRux5WNFfGs1h");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelDescription("41x5gVJ06cSXTCspVyodGzDpruFFGNfV6dU7yObIaGpj1mES1R");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("JcobBL94PS2LF8nuXTsbjnSMzySiGNqnZS83CZ9yiwrbyM4GMq");
        useraccesslevel.setLevelName("IzHqr5qBqb333kTN59LLVhBegj42Hr8CMd4M4fLocgZobYqFdU");
        useraccesslevel.setLevelIcon("a6TRFD3WQm8YnlG0GrOjbzC0cCVTzWS9skkjSlDiaAv5gOIjhl");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1464159402060l));
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsDeleted(1);
        user.setSessionTimeout(1743);
        user.setGenTempOneTimePassword(1);
        user.setChangePasswordNextLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1464159402119l));
        user.setUserAccessCode(33109);
        user.setAllowMultipleLogin(1);
        user.setIsLocked(1);
        user.setPasswordAlgo("nSi6cjOaNT9S7RvRSn9VlwT3Ffnyco9DpcvZbGtcz6BkFeyaZV");
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("LpvL7vVk2ZU2yHz2AOipuijQB6LYV8uJ2Hs2VyGlCHNJZBLVzb");
        Question question = new Question();
        question.setQuestionDetails("aPlqAueXW5");
        question.setQuestion("0qt7ncdzfmkDImTlkzf35VfV1btZRb6wPmn7egYKMoubxalT35");
        question.setQuestionIcon("keB2i7rpuAzAxfTN4KzwmgLKcafRZRvrVHTcX1Qo6Iyxqnj5zR");
        question.setLevelid(3);
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setAnswer("hbvNz76vcKbTvP9x7KIgOKh2Fu8EfDKi1XiosfdkYLBr6PUhbs");
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordExpiry(4);
        userdata.setPassword("OxXz0ud6TDH6Mb3veLGftdpVnMf8ykRNFCG5FzeB8JofdDs4TB");
        userdata.setOneTimePassword("1YSygpRKhfft12R8OPHtkdcSCwxRhst9");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1464159402268l));
        userdata.setOneTimePasswordExpiry(10);
        userdata.setPassword("aididsF2GmfhSCe2QsAt6EcNpDr6h0prDVcTZmqtAjgcK8MBCE");
        userdata.setOneTimePassword("ePQOh6tVFct2BT4aHst744akoFU9Pg91");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1464159402287l));
        userdata.setUser(user);
        userdata.setLast5Passwords("iY1FTuBY9mebeny4p1ZI0GqBfmfDYw94SX2fN2RBjwQAco7zXI");
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setDateofbirth(new java.sql.Timestamp(1464159402369l));
        corecontacts.setNativeMiddleName("gObSlwFQsGumbwoQODRdTnmS9WfkRJzBT30KrPYxPI8Iy35glD");
        corecontacts.setNativeFirstName("XHags9EWSYnIAwDlSeEWou0XDglEqu3etD0svoaAq9F5nBLODw");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1464159402369l));
        corecontacts.setMiddleName("W1SMd4f1eBg3fdGTZ1oA3fNWS4UmIFrUGuZDYtqX3p2zeNsgvZ");
        Title title = new Title();
        title.setTitles("Mwm0ksV5Synv0LP2vJOuyiqDYxlekSsPGAabzZ730D1NUzU85D");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("z8EyJWSKNDOscdhpXtpWujLAUGnVzojixbKlD6drb8rbRqNaT7");
        timezone.setGmtLabel("2n8ZmmbkYmZsM5cMvlJmxVRfYXyLKyAxsAF7FfSOhccnkC0biY");
        timezone.setTimeZoneLabel("suTI9kT8VRXrs7J9MkLvhaXdHKG9HmtFvKkvCgNI9IJCBGGSUU");
        timezone.setUtcdifference(4);
        timezone.setCities("NIzuyrIfZ1sQIpJsyMAe0pFgAs0ZgpnKXj5YU0uDOAFQ4O9ySU");
        Language language = new Language();
        language.setLanguageType("lRpwxswF4hhEUy4rXkrKY1l7ZEyMmYzE");
        language.setAlpha4("BiRF");
        language.setAlpha2("aP");
        language.setAlpha3("qch");
        language.setAlpha4parentid(4);
        language.setLanguageIcon("XVKis4NdFqVbDsWE8Yqhv5bm2U73uogAuSwOYe566mKRSVyuTq");
        language.setLanguageDescription("o7v2ovIj7yKir2tmXY0wJUYgYO6ZI3mvN2WnZ2Ezp9zfw0fun1");
        language.setLanguage("OMWPA1aEdeGgUjQtyWNOwks1bXhQartnO9pzMe7mtkxULJxgE5");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("jJBpxYcVdzMI4W8cHw3D5AoLtF5fBxgJyBRGQV640fxn7n3S8U");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        corecontacts.setDateofbirth(new java.sql.Timestamp(1464159402388l));
        corecontacts.setNativeMiddleName("MUiaxdbYc5A8oT4rvmeplcxzAP3Tb8X8Y6ECPuo42fOYQIGOdS");
        corecontacts.setNativeFirstName("1AvRirdLbhSm9cvdKY3QvS6XpqrNqDyLdTICCyGYWeToJ5ifAH");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1464159402388l));
        corecontacts.setMiddleName("6gQZ7VX1EIwUpxHVjSa2mgy6rU2ItihZKUmNnzzrf6W6TLeBQR");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("s5yPHbjKuIQfnfMnFzqyLnCyuD7IftnMTgKto5K1KCARO239Sd");
        corecontacts.setEmailId("mzSQEzZ9ZaLQP6UIn6QMVvQcvxuozMmTrVUSzre3UMmnTvZihU");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setNativeTitle("tEQvnq5KVB9ie1Y3YnfyyrjV2odYmlHz1suisFJncnDhIpTAgs");
        corecontacts.setAge(69);
        corecontacts.setNativeLastName("62nDiY7QLi2d1uTJS3DYyBiKCY9oVOGrIwkbxk6RqX69vmW1qE");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setPhoneNumber("FujdnYujLGNrD4jG810S");
        corecontacts.setLastName("yS1VDmAMCd2MB7QzdRvziwMZDk2iN7XFioRQpb4tM6FhP8Rmse");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("1H7in3OTnD");
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("FP4YWQJFWBNKxCVkxkXVPz5oesi4Ui40SyptvkePPbRYr1ia1a");
        communicationgroup.setCommGroupName("phvIx70YFBbyE6qrRzg8qtl6pGTfiTZJI7cZezqhVGpFXoew1p");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("jZ192o3t9qeQsTczvqbn69yemRuvv7MTVKfdQDR0rvhVgx8GE0");
        communicationtype.setCommTypeDescription("MT16u0QFCURM617G6P0dn8tltxCjoAk8uAtgk7nBpjtyndX6le");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("3z67qfmRNi");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress1("o7jf1Vgv7bDlUzE3MiRX10qvndg6QcDT63CP7AbBidRaaQukju");
        Country country = new Country();
        country.setCapitalLatitude(6);
        country.setCurrencyName("4eEhQhFbbppkJ4kWAv3Qh7nWXq13kTMISEhKNUOUSNO8Rqu3C3");
        country.setCurrencyCode("ZXY");
        country.setCountryFlag("hq596adq4wpc46sA24ImAHPCRVeGxsWNP14rcXE74LVrO9wEBi");
        country.setIsoNumeric(700);
        country.setCountryName("6DnHcPr3FPxSYpRtZCniNeJ5qtowWI6CUDBilXihBlF8a1rvLU");
        country.setCurrencySymbol("QlDLBfeZXyL54gy41NRhCJxLvOpApQdr");
        country.setCountryCode1("Lb9");
        country.setCapitalLongitude(4);
        country.setCountryCode2("l66");
        country.setCapital("VANuOrX62Mz9bIxpVRRgbVQZexJXxScT");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("S5e1U4yIom97uuXXuS2pU7Pl63F14maj1MFxn4aPJkFvA8OjTi");
        addresstype.setAddressType("rNn2js8f85ZN4GEdOes6cbA0VzISGIP5XwwXSSOR0i7JeI3whm");
        addresstype.setAddressTypeDesc("mnnWhHqB1r8TwRPWagwrCvv8UiXyhLaBUtnrgWpncaDzLdOBkX");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        City city = new City();
        State state = new State();
        state.setStateCapitalLatitude(4);
        state.setStateFlag("9vNU1pF1ceA8DHHwvScYdRl08s1OQY7jjcxczwDhp9y8MdLvPA");
        state.setStateName("vCu24Lasp26J0SaKC3wMo42wiAw7wF5WShc2oBAlP0mbVZnugT");
        state.setStateCapitalLatitude(7);
        state.setStateFlag("fFMEwAphqhV5kvBr89ECSs87LAL5KouqFanXJtzSvFm5pAvvaI");
        state.setStateName("SuHzlqpwWnJpvntLgYW1paQdz1KAhqbPu25bQ7NL6yKejBboZz");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("3VM2bJF81U2iZSC4rAuhonMcfQLRyBEG");
        state.setStateDescription("sLcwGtqqEwKqqHdCGfRf7h6d8yjSumpM9EzRS3Y5VRDr3IWxiB");
        state.setStateCodeChar2("iheHLVBnd886E5Zeag8eiAic0LvqoRFs");
        state.setStateCapitalLongitude(9);
        state.setStateCode(1);
        state.setStateCapital("rfHRsLSwyAnHHj2TIl5Gd3lgAh1nOM7npaBPZudZD1xC9Axi7J");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("hZjI9ElOkhBV2LVIjnK1xZLr1EML514txOYOlI3ZhwT0QPbHp7");
        city.setCityName("hOTdoT5ia0aFEnMf1ft74mreJH368FNnTVXNEZJnX77yT23xcf");
        city.setCityCode(2);
        city.setCityDescription("CE4RMezLpIQoOmkwoAiu27WJulNbviDHnYRCC6Z6ui583MomVq");
        city.setCityLatitude(7);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("3XFvo6XVnevQLtqW6wK7iC7pENJrdTAx");
        city.setCityLongitude(11);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddress1("9eV0qbyX7Aq5FP7HSEPMV4sNq7X5coZWkZImL1HXrvDKHWE7AU");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("smrRMv");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("DPiRVxx328EVBsJpNjmu4FcEF1kClzizyXfzDJzJCA43Ct6DOT");
        address.setAddressLabel("Bku07LjEDaU");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
        address.setAddress2("pGL11AOkUK5V7jg2Pzc6DFSIoJkSTvSID1b1CKFbeM5WJ1T3hZ");
        address.setLongitude("PE8A4AAhnpWlzkOSwYtap9IGWp9IzTLrxQdfDigp6u3ppB7Uvs");
        address.setLatitude("syE5WJTHQiQcH3HS5sqzcjaTeHs8h2n2qHhwtEqIHLAg411vC6");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        Login login = new Login();
        user.setUserId(null);
        login.setUser(user);
        login.setServerAuthText("ivC8JDlBYJUaR7gE");
        login.setLoginId("mFY7mceBgPmQZxsflzj4YdNTWkexmFp78NE5hxLvrT5pp3mWvh");
        login.setIsAuthenticated(true);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setFailedLoginAttempts(7);
        login.setServerAuthImage("x3CcByVXIIwsBu5f3nMcByHQ5xf7arKh");
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
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
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setVersionId(1);
            login.setServerAuthText("ilYHk3LmZa2NsagO");
            login.setLoginId("A7XxFgtnbQKSRLoDOQK4MQ7VtRlTjcq0nMUNfisM8FdPhFXZxy");
            login.setFailedLoginAttempts(1);
            login.setServerAuthImage("tMmGFbgW8j8VvwvlkGqIUESHXXl6JJUq");
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "BaZ1zWsN1WkJPWQjsPomjJNnBkGniFDhLRyvvhFzXyxJaGYWWu6uklN39r5Kg0cSooookNPtAYYxFjlPbpjosHa4RUhrSkrYM30MTWsMZ9tZCb1I7RKYyfWKiGbUXDG8Pgx6MInBXiXaLNZdPRHXPLcjLK0tnmajQepgjSqLAcPY89S1cMpnSouHhCdpNZlxewWWHAiUV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "P4ZP98vkTOcB6xCG4sgDueNbhfUMIjDGJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "1RCHA13YrNcXwh8Gm"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 16));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
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
