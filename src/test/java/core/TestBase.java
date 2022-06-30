package core;

import Browser.LocalDriverInstance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.PartnerGroup.PartnerGroup;
import pages.HealthCareGovPages.*;
import utils.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/**
 * Class contains the Pre-requisite setup before running a Test Case
 *
 * @author siri
 */
public class TestBase {

    private static final Logger log = LogManager.getLogger(TestBase.class);
    protected ThreadLocal<LocalDriverInstance> appInstance = new ThreadLocal<>();
    public String scenarioName = "";
    public static String testDataFileName = Constants.QA_TEST_DATA;
    protected WebDriver driver;
    public static Method methodName = null;
    public static String methodN = null;
    private static File jsonFile = new File("src/test/resources/TestData/QAData.json");
    public static String baseUrl = "app.sidecarhealth.com/";
    public static String previewCovUrl = "https://qa-"+baseUrl+"previewCoverage";

    // ***** Sauce Labs ***********
    public static final String SAUCE_USERNAME = "sidecarhealth";
    public static final String SAUCE_ACCESS_KEY = "9dc2c607-ad6c-4e99-8c29-c2724ac26ed4";
    //public static final String tunnel = "dde489428a3e4121a0d7a85c17c9fa52";
    public static final String SAUCE_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    protected SoftAssert logger;

    public PartnerGroup partnerGroup = null;
    public CareHomePage careHomePage = null;
    public CreateAccountPage createAccountPage = null;
    public YopMailPage yopMailPage = null;
    public LoginPage loginPage = null;
    public StartMyApplicationPage startMyApplicationLocators = null;
    public VerifyYourIdentityPage verifyYourIdentityPage = null;
    public PrivacyPolicyPage privacyPolicyPage = null;
    public BeforeGetStartedPage beforeGetStartedPage = null;
    public ContactInfoPage contactInfoPage = null;
    public VerifyAddressPage verifyAddressPage = null;
    public ValidateHomeAddressPage validateHomeAddressPage = null;
    public MailingAddressPage mailingAddressPage = null;
    public ContactPreferencesPage contactPreferencesPage = null;
    public PreferredLanguagePage preferredLanguagePage = null;
    public ContactInformationPage contactInformationPage = null;
    public ApplicationHelpPage applicationHelpPage = null;
    public WhoNeedsCoveragePage whoNeedCoveragePage = null;
    public HouseHoldMemPage houseHoldMemPage = null;
    public MaritalStatusPage maritalStatusPage = null;
    public TaxRelationshipsPage taxRelationshipsPage = null;
    public ParentsAndCaretakerRelativesPage parentsAndCaretakerRelativesPage = null;
    public HouseholdInformationPage householdInformationPage = null;
    public pages.HealthCareGovPages.MemberInformationPage MemberInformationPage = null;
    public MemberInfoSSNPage MemberInfoSSNPage = null;
    public CitizenshipStatusPage CitizenshipStatusPage = null;
    public MembersCitizenshipPage MembersCitizenshipPage = null;
    public DisabilitiesAndHelpPage DisabilitiesAndHelpPage = null;
    public MedicaidPage MedicaidPage = null;
    public ChangesInCoveragePage ChangesInCoveragePage = null;
    public HouseholdIncomePage HouseholdIncomePage = null;
    public HouseholdExpensesPage HouseholdExpensesPage = null;
    public MembersIncomePage MembersIncomePage = null;
    public MemberIncomeReviewPage memberIncomeReviewPage = null;
    public CurrentCoveragePage currentCoveragePage = null;
    public HealthCareBenefitsThroughJobPage healthCareBenefitsThroughJobPage = null;
    public HRATypesPage hraTypesPage = null;
    public IndividualCoverageHRAPage individualCoverageHRAPage = null;
    public JobBasedHealthCoverageOffersPage jobBasedHealthCoverageOffersPage = null;
    public LifeEventsAndCoverageChangesPage lifeEventsAndCoverageChangesPage = null;
    public HRAOffersPage hraOffersPage = null;
    public RecentCoverageChangesPage recentCoverageChangesPage = null;
    public UpcomingCoverageChangesPage upcomingCoverageChangesPage = null;
    public LifeChangesPage lifeChangesPage = null;
    public IncarcerationReleasePage incarcerationReleasePage = null;
    public IncarcerationReleasedMemberPage incarcerationReleasedMemberPage = null;
    public ReviewApplicationPage reviewApplicationPage = null;
    public ReadAndAgreePage readAndAgreePage = null;
    public SignAndSubmitPage signAndSubmitPage = null;
    public EligibilityResultsPage eligibilityResultsPage = null;
    public EligibleToEnrollMarketplacePage eligibleToEnrollMarketplacePage = null;
    public UseYourTaxPage useYourTaxPage = null;
    public TobaccoUsePage tobaccoUsePage = null;
    public SeeDoctorsFacilitiesPage seeDoctorsFacilitiesPage = null;
    public AddDoctorsFacilities addDoctorsFacilities = null;
    public HelpComparingPlansPage helpComparingPlansPage = null;
    public pages.LoginPages.LoginPage loginPages = null;
    public pages.BillingPages.BillingPage billingPage = null;
    public pages.AdminCarePages.AdminCarePage adminCarePage = null;
    public pages.AdminHomePages.AdminHomePage adminHomePage = null;
    public pages.CarePages.CarePage carePage = null;
    public pages.DoctorsPages.DoctorsPage doctorsPage = null;
    public pages.SignUpPages.SignUpPage signUpPage = null;
    public pages.PaymentPages.PaymentPage paymentPage = null;
    public pages.AdminCarePages.AdminLoginPage adminloginPage = null;
    public pages.AdminCarePages.AdminDashBoardPage adminDashBoardPage = null;
    public StartGuidingQuestionFlow startGuidingQuestionFlow = null;

    public  EnrollPlansPage  enrollPlansPage  = null;
    public  EnrollGroupConfirmPage enrollGroupConfirmPage = null;
    public EnrollGroupPage  enrollGroupPage  = null;
    public  EnrollGroupAttestPage  enrollGroupAttestPage   = null;
    public   EnrollPayForHealthPlanPage enrollPayForHealthPlanPage   = null;
    public  EnrollStatementsAgreePage  enrollStatementsAgreePage = null;

    private void initializeAllClasses() {
        partnerGroup = new PartnerGroup(driver);
        enrollGroupConfirmPage = new EnrollGroupConfirmPage(driver);
        enrollGroupPage = new EnrollGroupPage(driver);
        enrollPlansPage   = new EnrollPlansPage (driver);
        enrollStatementsAgreePage  = new EnrollStatementsAgreePage(driver);
        enrollGroupAttestPage  = new EnrollGroupAttestPage(driver);
        enrollPayForHealthPlanPage= new EnrollPayForHealthPlanPage(driver);
        startGuidingQuestionFlow = new StartGuidingQuestionFlow(driver);
        adminloginPage  = new pages.AdminCarePages.AdminLoginPage(driver);
        adminDashBoardPage  = new pages.AdminCarePages.AdminDashBoardPage(driver);
        loginPages  = new pages.LoginPages.LoginPage(driver);
        paymentPage = new pages.PaymentPages.PaymentPage(driver);
        signUpPage = new pages.SignUpPages.SignUpPage(driver);
        doctorsPage = new pages.DoctorsPages.DoctorsPage(driver);
        adminHomePage = new pages.AdminHomePages.AdminHomePage(driver);
        adminCarePage = new pages.AdminCarePages.AdminCarePage(driver);
        billingPage =new pages.BillingPages.BillingPage(driver);
        careHomePage = new CareHomePage(driver);
        createAccountPage = new CreateAccountPage(driver);
        yopMailPage = new YopMailPage(driver);
        loginPage = new LoginPage(driver);
        startMyApplicationLocators = new StartMyApplicationPage(driver);
        verifyYourIdentityPage = new VerifyYourIdentityPage(driver);
        privacyPolicyPage = new PrivacyPolicyPage(driver);
        beforeGetStartedPage = new BeforeGetStartedPage(driver);
        contactInfoPage = new ContactInfoPage(driver);
        verifyAddressPage = new VerifyAddressPage(driver);
        validateHomeAddressPage = new ValidateHomeAddressPage(driver);
        mailingAddressPage = new MailingAddressPage(driver);
        preferredLanguagePage = new  PreferredLanguagePage(driver);
        contactInformationPage = new ContactInformationPage(driver);
        contactPreferencesPage = new ContactPreferencesPage(driver);
        applicationHelpPage = new ApplicationHelpPage(driver);
        whoNeedCoveragePage = new WhoNeedsCoveragePage(driver);
        houseHoldMemPage = new HouseHoldMemPage(driver);
        maritalStatusPage = new MaritalStatusPage(driver);
        taxRelationshipsPage = new TaxRelationshipsPage(driver);
        parentsAndCaretakerRelativesPage = new ParentsAndCaretakerRelativesPage(driver);
        householdInformationPage = new HouseholdInformationPage(driver);
        MemberInformationPage = new MemberInformationPage(driver);
        MemberInfoSSNPage = new MemberInfoSSNPage(driver);
        CitizenshipStatusPage = new CitizenshipStatusPage(driver);
        MembersCitizenshipPage = new MembersCitizenshipPage(driver);
        DisabilitiesAndHelpPage = new DisabilitiesAndHelpPage(driver);
        MedicaidPage = new MedicaidPage(driver);
        ChangesInCoveragePage = new ChangesInCoveragePage(driver);
        HouseholdIncomePage = new HouseholdIncomePage(driver);
        HouseholdExpensesPage = new HouseholdExpensesPage(driver);
        MembersIncomePage = new MembersIncomePage(driver);
        memberIncomeReviewPage = new MemberIncomeReviewPage(driver);
        currentCoveragePage = new CurrentCoveragePage(driver);
        healthCareBenefitsThroughJobPage = new HealthCareBenefitsThroughJobPage(driver);
        hraTypesPage = new HRATypesPage(driver);
        individualCoverageHRAPage = new IndividualCoverageHRAPage(driver);
        jobBasedHealthCoverageOffersPage = new JobBasedHealthCoverageOffersPage(driver);
        lifeEventsAndCoverageChangesPage = new LifeEventsAndCoverageChangesPage(driver);
        hraOffersPage = new HRAOffersPage(driver);
        recentCoverageChangesPage = new RecentCoverageChangesPage(driver);
        upcomingCoverageChangesPage = new UpcomingCoverageChangesPage(driver);
        lifeChangesPage = new LifeChangesPage(driver);
        incarcerationReleasePage = new IncarcerationReleasePage(driver);
        incarcerationReleasedMemberPage = new IncarcerationReleasedMemberPage(driver);
        reviewApplicationPage = new ReviewApplicationPage(driver);
        readAndAgreePage = new ReadAndAgreePage(driver);
        signAndSubmitPage = new SignAndSubmitPage(driver);
        eligibilityResultsPage = new EligibilityResultsPage(driver);
        eligibleToEnrollMarketplacePage = new EligibleToEnrollMarketplacePage(driver);
        useYourTaxPage = new UseYourTaxPage(driver);
        tobaccoUsePage = new TobaccoUsePage(driver);
        seeDoctorsFacilitiesPage = new SeeDoctorsFacilitiesPage(driver);
        addDoctorsFacilities = new AddDoctorsFacilities(driver);
        helpComparingPlansPage = new HelpComparingPlansPage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethodTestBase() {
        log.info("afterMethodTestBase() called");
        driver.quit();
    }



    @BeforeMethod(alwaysRun = true)
    private static void executeTest() {
        PropertiesReader pr = new PropertiesReader();
        pr.loadPropertiesFile(Constants.MainConfig);
        PropValue.MainConfig = pr.prop;
        File jsonFile = new File("src/test/resources/TestData/QAData.json");


    }
    public JSONObject testData = new JSONObject();
    public JSONObject partnercredentials = new JSONObject();

    @BeforeMethod(alwaysRun = true)
    private  void ReadJsonTestData() throws Exception {
        String jsonString =  Utilities.readTestData("signup","src/test/resources/TestData/QAData.json").toString();
        testData = new JSONObject(jsonString);
        System.out.println(testData);

    }




    @BeforeMethod(alwaysRun = true)
    public void beforeMethodTestBase() {
        log.info("beforeMethodTestBase() called");
       appInstance.set(new LocalDriverInstance());
       appInstance.get().start();
       driver = appInstance.get().getWebDriver();
      initializeAllClasses();

        }





    private static String getLogFileName() throws UnknownHostException {
        String DATE_FORMAT_NOW = "yyyy-MM-dd";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_NOW);
        return "Sidecar" + InetAddress.getLocalHost().getHostName() + "_" + simpleDateFormat.format(cal.getTime())
                + ".log";
    }
    /**
     * Check and create folder.
     *
     * @param folderName
     *            Method which creates all the required folders for the
     *            framework to work.
     * @return true, if successful
     */
    private static boolean checkAndCreateFolder(String folderName) {
        File folder = new File(folderName);
        try {
            if (folder.exists()) {
                return true;
            } else {
                if (folder.mkdirs()) {
                    return true;
                } else {
                    System.out.println("Problem in creating" + folderName + "folder, please check the permission.");
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Problem in creating " + folderName + " : " + e.getMessage());
            return false;
        }
    }
    @BeforeSuite(alwaysRun = true)
    public void ReadRunParameters() throws IOException {
        try {

            Constants.LOGFILENAME = getLogFileName();
            if (checkAndCreateFolder(Constants.LOGSDIR) && checkAndCreateFolder(Constants.TESTOUTPUT)
                    && checkAndCreateFolder(Constants.REPORTSDIR))
            {
                Constants.LOGFILENAME = getLogFileName();
                Logs.LOGGER.info("-------------------------------------------------");
                Logs.LOGGER.info("******** Starting Automation *********");
                //initializeAllClasses().iClass = new initializeAllClasses()();
                //PropValue.iclass = iClass;
                PropertiesReader pr = new PropertiesReader();
                pr.loadPropertiesFile(Constants.TEST_CONFIG_PATH);
                PropValue.MainConfig = pr.prop;


                try {

                } catch (Exception e) {
                    System.out.println("Not able to fetch the user details for partner");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            Logs.LOGGER.log(Level.SEVERE, "Check the environment properties: " + " "+ e);
        } finally {

            // TODO:
        }

    }




    @DataProvider(name = "EnrollTestData")
    public static Object[][] EnrollTestData(){
        JSONArray jsonArray = JsonUtils.toJsonArray("EnrollTestData.json");
        List<Map> list = JsonUtils.getFilteredRecordListFromJsonArray(jsonArray, "state", "OH");
        Map<String, String> data = list.get(0);
        return new Object[][]{{data}};
    }


}
