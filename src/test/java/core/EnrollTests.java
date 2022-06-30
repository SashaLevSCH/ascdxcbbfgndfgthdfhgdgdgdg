package core;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import utils.Constants;
import utils.ExcelUtil;
import utils.Utilities;

import java.util.Map;

public class EnrollTests extends TestBase {

    @Test
    public void enrollTest(ITestContext context) {
        ExcelUtil excelUtil = new ExcelUtil("ridp_test_data.xlsx", 0);
        Map<String, String> map = excelUtil.getListOfFilteredRecordAsHashMap("STATE", "OH").get(0);
      String Email = "testarscqa" + Utilities.genertaeRandomNumbers(5) + "@yopmail.com";




        careHomePage.clickApply();
       createAccountPage.createaccount(map, "Ohio",
                Email,
                Constants.Passwd);
        yopMailPage.maillogin(Email);
        loginPage.login(Email, Constants.Passwd);
        startMyApplicationLocators.selectStateAndStartApplication("OH");
        map.replace("ZIP", "44004");
        verifyYourIdentityPage.enterIdentityDetails(map);
        privacyPolicyPage.checkPrivacypolicy();
        beforeGetStartedPage.apply();
        contactInfoPage.fillcontactinfo();
        verifyAddressPage.verifyaddress();
        validateHomeAddressPage.verifyHomeaddress();
        mailingAddressPage.verifymailingaddress();
        contactInformationPage.ContactInformationPage();
        preferredLanguagePage.Languageselection();
        contactPreferencesPage.setcontactpref();
        applicationHelpPage.professionalHelpAndContinue();
        whoNeedCoveragePage.setcoverage();
        houseHoldMemPage.continuepage();
        maritalStatusPage.setapplicationhelp();
        taxRelationshipsPage.clickOnFederal();
        taxRelationshipsPage.clickOnDependent();
        taxRelationshipsPage.clickOnDependent2();
        parentsAndCaretakerRelativesPage.clickOnFederal();
        parentsAndCaretakerRelativesPage.clickOnSavebtn();
        householdInformationPage.clickOnCurrentlyInCarcerated();
        householdInformationPage.clickOnYes();
        householdInformationPage.clickOnPendingDispositionAndContinue();
        MemberInformationPage.inputMemberInfo("No");
        MemberInformationPage.inputMemberInfo("white");
        MemberInformationPage.saveAndContinue();
        MemberInfoSSNPage.clickNoSsn();
        MemberInfoSSNPage.clickSaveAndContinue();
        CitizenshipStatusPage.setIsCitizenOrNational("Yes");
        CitizenshipStatusPage.clickSaveAndContinue();
        MembersCitizenshipPage.setIsNaturalizedOrDerived("No");
        MembersCitizenshipPage.clickSaveAndContinue();
        DisabilitiesAndHelpPage.clickSaveAndContinue();
        MedicaidPage.setMedicaidDenial("No");
        MedicaidPage.clickSaveAndContinue();
        ChangesInCoveragePage.setChangesInCoverage("No");
        ChangesInCoveragePage.clickSaveAndContinue();
        HouseholdIncomePage.setMemberOneIncome();
        HouseholdIncomePage.clickSaveAndContinue();
        HouseholdExpensesPage.clickSaveAndContinue();
        MembersIncomePage.selectMembersIncomeType("Job");
        MembersIncomePage.enterEmployerName("CARSON MASONRY");
        MembersIncomePage.enterIncomeAmount("20000");
        //MembersIncomePage.setHowOftenIncomePaid("Yearly");
         MembersIncomePage.HowOftenIncomePaid();
        MembersIncomePage.enterPhoneNumber("2167616672");
        MembersIncomePage.clickSaveAndContinue();
        memberIncomeReviewPage.verifyincome();
        currentCoveragePage.memberscoverage();
        healthCareBenefitsThroughJobPage.verify();
        hraTypesPage.verifyhra();
        individualCoverageHRAPage.individualhra();
        jobBasedHealthCoverageOffersPage.verify();
        lifeEventsAndCoverageChangesPage.verify();
        hraOffersPage.hraoffers();
        recentCoverageChangesPage.verifymembercoverage();
        upcomingCoverageChangesPage.verifymembercoverage();
        lifeChangesPage.lifechanges();
        incarcerationReleasePage.selectMemberAndContinue();
        incarcerationReleasedMemberPage.enterIncarcerationReleaseDateAndContinue();
        reviewApplicationPage.clickSaveAndContinue();
        readAndAgreePage.agreeAndProceed();
        signAndSubmitPage.signAndSubmit();
        eligibilityResultsPage.viewNoticeAndContinue();
        eligibleToEnrollMarketplacePage.decideToLowerPremium();
        useYourTaxPage.selectAllAndContinue();
        tobaccoUsePage.reportNoTobaccoAndContinue();
        seeDoctorsFacilitiesPage.continueWithDoctorsFacilities();
        addDoctorsFacilities.clickOnSkip();
        helpComparingPlansPage.clickCloseBtn();
        enrollPlansPage.clickEnroll();
        enrollGroupPage.clickEnrollgroup();
        enrollGroupConfirmPage.clickgroupconfirm();
        enrollGroupAttestPage.clickGroupAttest();
        enrollStatementsAgreePage.clickAndAgreeStatements();


    }
}
