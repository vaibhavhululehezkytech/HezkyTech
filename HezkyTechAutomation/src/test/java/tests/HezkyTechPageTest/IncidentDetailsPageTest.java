package tests.HezkyTechPageTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import HezkyTechTestData.CustomerPanelTestData;
import pages.HezkyTech.HezkyTechPageBase;
import tests.TestBase;

public class IncidentDetailsPageTest extends TestBase {

	HezkyTechPageBase hezkyTechPageBase;
	CustomerPanelTestData customerPanelTestData = new CustomerPanelTestData();

	@Override
	@BeforeClass
	protected void initPageObject() {
		hezkyTechPageBase = new HezkyTechPageBase(driverManager);
	}
	@Test(description = "Verify Incident Details page is loaded properly", priority=1)
	public void IN_DE_001_verifyIncidentDetailsPageLoadedProperly() {}

	@Test(description = "Verify Status bar is showing all related data for incident", priority=2)
	public void IN_DE_002_verifyStatusBarShowsRelatedData() {}

	@Test(description = "Verify Incident acknowledged on Dashboard is reflected on Incident details page", priority=3)
	public void IN_DE_003_verifyIncidentAcknowledgedOnDashboardReflected() {}

	@Test(description = "Verify that an incident can be acknowledged by a user", priority=4)
	public void IN_DE_004_verifyIncidentCanBeAcknowledgedByUser() {}

	@Test(description = "Verify Incident is assigned to user it should be reflected on incident details page", priority=5)
	public void IN_DE_005_verifyIncidentAssignedToUserReflected() {}

	@Test(description = "Verify that an incident can be assigned to a user", priority=6)
	public void IN_DE_006_verifyIncidentCanBeAssignedToUser() {}

	@Test(description = "Verify user is getting notification for incident assigned", priority=7)
	public void IN_DE_007_verifyUserGetsNotificationForIncidentAssigned() {}

	@Test(description = "Verify status for incident is changed as per change in incident", priority=8)
	public void IN_DE_008_verifyIncidentStatusChangesCorrectly() {}

	@Test(description = "Verify User gets confirmation message before assigned user", priority=9)
	public void IN_DE_009_verifyConfirmationMessageBeforeAssigningUser() {}

	@Test(description = "Verify User assigned to Incident is updated in incident history", priority=10)
	public void IN_DE_010_verifyUserAssignedUpdatedInHistory() {}

	@Test(description = "Verify all notifies get notification for Incident closed", priority=11)
	public void IN_DE_011_verifyAllNotifiesGetNotificationForIncidentClosed() {}

	@Test(description = "Verify that the incident duration is calculated correctly when the incident status is changed to 'Closed'", priority=12)
	public void IN_DE_012_verifyIncidentDurationCalculatedCorrectly() {}

	@Test(description = "Verify that the incident log is updated when the status changes", priority=13)
	public void IN_DE_013_verifyIncidentLogUpdatedOnStatusChange() {}

	@Test(description = "Verify that the incident log is updated when the Severity increases", priority=14)
	public void IN_DE_014_verifyIncidentLogUpdatedOnSeverityIncrease() {}

	@Test(description = "Verify values are correct for following: 1.Triggered Time, 2.Threshold Value, 3.Severity", priority=15)
	public void IN_DE_015_verifyValuesForTriggeredTimeThresholdValueSeverity() {}

	@Test(description = "Verify that all incident details are visible and accessible", priority=16)
	public void IN_DE_016_verifyAllIncidentDetailsVisibleAndAccessible() {}

	@Test(description = "Verify 'Was products get impacted?' Dropdown selection make required changes in incident details Tab", priority=17)
	public void IN_DE_017_verifyWasProductsImpactedDropdownChanges() {}

	@Test(description = "Verify 'Was products get impacted?' Dropdown selected for yes make required changes in incident details Tab", priority=18)
	public void IN_DE_018_verifyWasProductsImpactedDropdownSelectedYes() {}

	@Test(description = "Verify user can make selection from 'Was the Impacted Product(s) immediately shifted to alternate Area? Dropdown", priority=19)
	public void IN_DE_019_verifyUserCanSelectImpactedProductsShiftedDropdown() {}

	@Test(description = "Verify user add incident details in 'Details' input field", priority=20)
	public void IN_DE_020_verifyUserCanAddIncidentDetails() {}

	@Test(description = "Verify 'Add Products' functionality", priority=21)
	public void IN_DE_021_verifyAddProductsFunctionality() {}

	@Test(description = "Verify '×' button close the popup for add products", priority=22)
	public void IN_DE_022_verifyCloseButtonClosesAddProductsPopup() {}

	@Test(description = "Verify 'Add affected Products manually' option functionality", priority=23)
	public void IN_DE_023_verifyAddAffectedProductsManuallyFunctionality() {}

	@Test(description = "Verify user can 'Add affected Products manually' by clicking on 'Done' button", priority=24)
	public void IN_DE_024_verifyUserCanAddAffectedProductsManually() {}

	@Test(description = "Verify Product name in popup is searchable input field", priority=25)
	public void IN_DE_025_verifyProductNameIsSearchable() {}

	@Test(description = "Verify user is able to select and add product in popup", priority=26)
	public void IN_DE_026_verifyUserCanSelectAndAddProduct() {}

	@Test(description = "Verify new product add row is added when user click on 'Enter' Button after adding a product with valid data", priority=27)
	public void IN_DE_027_verifyNewProductRowAddedOnEnter() {}

	@Test(description = "Verify Product row is Deleted by Using Delete icon button with correct validation popup message", priority=28)
	public void IN_DE_028_verifyProductRowDeletedWithValidation() {}

	@Test(description = "Verify user can navigate back to 'Add Products' Popup using Close button with validation message popup", priority=29)
	public void IN_DE_029_verifyUserCanNavigateBackToAddProductsPopup() {}

	@Test(description = "Verify NO. OF UNITS AFFECTED field accepts only Numericals", priority=30)
	public void IN_DE_030_verifyNoOfUnitsAffectedAcceptsNumericals() {}

	@Test(description = "Verify user can Download sample file", priority=31)
	public void IN_DE_031_verifyUserCanDownloadSampleFile() {}

	@Test(description = "Verify user can upload Products file in xlsx format", priority=32)
	public void IN_DE_032_verifyUserCanUploadProductsFile() {}

	@Test(description = "Verify Drag and Drop File functionality", priority=33)
	public void IN_DE_033_verifyDragAndDropFileFunctionality() {}

	@Test(description = "Verify User gets validation error If uploaded File has not valid data", priority=34)
	public void IN_DE_034_verifyValidationErrorForInvalidFileData() {}

	@Test(description = "Verify Mandatory fields must have '*' mark", priority=35)
	public void IN_DE_035_verifyMandatoryFieldsMarkedWithAsterisk() {}

	@Test(description = "Verify Sign and submit button in incident details", priority=36)
	public void IN_DE_036_verifySignAndSubmitButtonInIncidentDetails() {}

	@Test(description = "Verify Sign and submit Popup can be closed using 'x' button", priority=37)
	public void IN_DE_037_verifySignAndSubmitPopupClosesWithXButton() {}

	@Test(description = "Verify password is in masked form", priority=38)
	public void IN_DE_038_verifyPasswordIsMasked() {}

	@Test(description = "Verify user save the incident details", priority=39)
	public void IN_DE_039_verifyUserCanSaveIncidentDetails() {}

	@Test(description = "Verify Incident details not saved when user enter incorrect password and get validation error message", priority=40)
	public void IN_DE_040_verifyIncidentDetailsNotSavedWithIncorrectPassword() {}

	@Test(description = "Verify Password don’t show Suggestion for Sign and submit for saved user", priority=41)
	public void IN_DE_041_verifyPasswordNoSuggestionForSavedUser() {}

	@Test(description = "Verify user gets validation error message for missing data while saving Incident details", priority=42)
	public void IN_DE_042_verifyValidationErrorForMissingData() {}

	@Test(description = "Verify 'Add products' Button changes to 'View products'", priority=43)
	public void IN_DE_043_verifyAddProductsButtonChangesToViewProducts() {}

	@Test(description = "Verify popup is open for saved affected products for Incident", priority=44)
	public void IN_DE_044_verifyPopupForSavedAffectedProducts() {}

	@Test(description = "Verify All saved data is visible in Incident Details tab", priority=45)
	public void IN_DE_045_verifyAllSavedDataVisibleInIncidentDetails() {}

	@Test(description = "Verify Sign and submit popup not show previous Validation message", priority=46)
	public void IN_DE_046_verifySignAndSubmitPopupNoPreviousValidationMessage() {}

	@Test(description = "Verify 'Submitted by User name' should be visible at the end of Incident details tab after saving incident details", priority=47)
	public void IN_DE_047_verifySubmittedByUserNameVisible() {}

	@Test(description = "Verify user is able to navigate to 'Investigation & CAPA' Tab", priority=48)
	public void IN_DE_048_verifyUserCanNavigateToInvestigationCAPATab() {}

	@Test(description = "Verify Reason Of Excursion Dropdown", priority=49)
	public void IN_DE_049_verifyReasonOfExcursionDropdown() {}

	@Test(description = "Verify user can manually add Reason Of Excursion", priority=50)
	public void IN_DE_050_verifyUserCanManuallyAddReasonOfExcursion() {}

	@Test(description = "Verify 'Please mention the details & cause' Input Field", priority=51)
	public void IN_DE_051_verifyDetailsAndCauseInputField() {}

	@Test(description = "Verify 'Details' input Field", priority=52)
	public void IN_DE_052_verifyDetailsInputField() {}

	@Test(description = "Verify scroll is available in 'Please mention the details & cause' and 'Details' input field for text exceeding the expected length in text fields", priority=53)
	public void IN_DE_053_verifyScrollAvailableInDetailsFields() {}

	@Test(description = "Verify File Attachment for CAPA Implementation", priority=54)
	public void IN_DE_054_verifyFileAttachmentForCAPAImplementation() {}

	@Test(description = "Verify user have option to cancel file upload", priority=55)
	public void IN_DE_055_verifyUserCanCancelFileUpload() {}

	@Test(description = "Verify 'Download file' Option available instead of choose file After Submit 'Investigation & CAPA'", priority=56)
	public void IN_DE_056_verifyDownloadFileOptionAvailable() {}

	@Test(description = "Verify User can view attached file", priority=57)
	public void IN_DE_057_verifyUserCanViewAttachedFile() {}

	@Test(description = "Verify CAPA Implementation Date Picker", priority=58)
	public void IN_DE_058_verifyCAPAImplementationDatePicker() {}

	@Test(description = "Verify Mandatory fields must have '*' mark", priority=59)
	public void IN_DE_059_verifyMandatoryFieldsMarkedWithAsterisk2() {}

	@Test(description = "Verify Validation on Empty Form Submission", priority=60)
	public void IN_DE_060_verifyValidationOnEmptyFormSubmission() {}

	@Test(description = "Verify Sign and submit button in 'Investigation & CAPA' Tab", priority=61)
	public void IN_DE_061_verifySignAndSubmitButtonInInvestigationCAPA() {}

	@Test(description = "Verify 'Submitted by User name' should be visible at the end of Incident details tab after saving 'Investigation & CAPA'", priority=62)
	public void IN_DE_062_verifySubmittedByUserNameVisibleAfterInvestigationCAPA() {}

	@Test(description = "Verify the default selection of the 'Product disposition' dropdown", priority=63)
	public void IN_DE_063_verifyDefaultSelectionOfProductDispositionDropdown() {}

	@Test(description = "Verify 'Product disposition' dropdown showing correct data", priority=64)
	public void IN_DE_064_verifyProductDispositionDropdownShowsCorrectData() {}

	@Test(description = "Verify Select value from 'Product disposition' dropdown", priority=65)
	public void IN_DE_065_verifySelectValueFromProductDispositionDropdown() {}

	@Test(description = "Verify 'Impact Assessment' input Field", priority=66)
	public void IN_DE_066_verifyImpactAssessmentInputField() {}

	@Test(description = "Verify scroll is available in 'Impact Assessment' input field for text exceeding the expected length in text fields", priority=67)
	public void IN_DE_067_verifyScrollAvailableInImpactAssessmentField() {}

	@Test(description = "Verify Mandatory fields must have '*' mark", priority=68)
	public void IN_DE_068_verifyMandatoryFieldsMarkedWithAsterisk3() {}

	@Test(description = "Verify validation Error message will display for mandatory field", priority=69)
	public void IN_DE_069_verifyValidationErrorForMandatoryField() {}

	@Test(description = "Verify 'Submitted by User name' should be visible at the end of Incident details tab after saving 'Evaluation & Disposition'", priority=70)
	public void IN_DE_070_verifySubmittedByUserNameVisibleAfterEvaluationDisposition() {}

	@Test(description = "Verify Approve and Reject option is added on tab after sign submit for User as per selected Role", priority=71)
	public void IN_DE_071_verifyApproveAndRejectOptionAdded() {}

	@Test(description = "Verify Final Approval and rejection option is only visible to Selected role", priority=72)
	public void IN_DE_072_verifyFinalApprovalAndRejectionVisibleToSelectedRole() {}

	@Test(description = "Verify tab should be reset after form is Rejected", priority=73)
	public void IN_DE_073_verifyTabResetAfterFormRejected() {}

	@Test(description = "Verify Timestamp for Sign and submit and Approve, reject", priority=74)
	public void IN_DE_074_verifyTimestampForSignAndSubmitAndApproveReject() {}

	@Test(description = "Verify User is navigated to 'History' Tab", priority=75)
	public void IN_DE_075_verifyUserNavigatedToHistoryTab() {}

	@Test(description = "Verify 'Incident created' log is updated with timestamp in History", priority=76)
	public void IN_DE_076_verifyIncidentCreatedLogUpdatedInHistory() {}

	@Test(description = "Verify 'Status' changed by username log is updated with timestamp in History", priority=77)
	public void IN_DE_077_verifyStatusChangedLogUpdatedInHistory() {}

	@Test(description = "Verify 'Acknowledgement' by Status log is updated with timestamp in History", priority=78)
	public void IN_DE_078_verifyAcknowledgementLogUpdatedInHistory() {}

	@Test(description = "Verify Incident 'Assigned to' user and assigned by user log is updated with timestamp in History", priority=79)
	public void IN_DE_079_verifyIncidentAssignedLogUpdatedInHistory() {}

	@Test(description = "Verify 'Incident Details' sign and submitted by user log is Updated in incident History as per Timestamp", priority=80)
	public void IN_DE_080_verifyIncidentDetailsSignAndSubmitLogUpdatedInHistory() {}

	@Test(description = "Verify 'Investigation & CAPA' sign and submitted by user log is Updated in incident History as per Timestamp", priority=81)
	public void IN_DE_081_verifyInvestigationCAPASignAndSubmitLogUpdatedInHistory() {}

	@Test(description = "Verify 'Evaluation & Disposition' sign and submitted by user log is Updated in incident History as per Timestamp", priority=82)
	public void IN_DE_082_verifyEvaluationDispositionSignAndSubmitLogUpdatedInHistory() {}

	@Test(description = "Verify 'Comment' added by user is updated in Incident History", priority=83)
	public void IN_DE_083_verifyCommentAddedByUserUpdatedInHistory() {}

	@Test(description = "Verify User mentioned in 'Comment' by user updated in Incident History", priority=84)
	public void IN_DE_084_verifyUserMentionedInCommentUpdatedInHistory() {}

	@Test(description = "Verify 'File' Uploaded in Comment log updated in Incident History as per Timestamp", priority=85)
	public void IN_DE_085_verifyFileUploadedInCommentLogUpdatedInHistory() {}

	@Test(description = "Verify Increased Severity and closed incident Log is updated in incident History as per timestamp", priority=86)
	public void IN_DE_086_verifyIncreasedSeverityAndClosedIncidentLogUpdatedInHistory() {}

	@Test(description = "Verify Input field open with '@' mention function in comment", priority=87)
	public void IN_DE_087_verifyInputFieldWithMentionFunctionInComment() {}

	@Test(description = "Verify User should Able to attach file in Comment", priority=88)
	public void IN_DE_088_verifyUserCanAttachFileInComment() {}

	@Test(description = "Verify graph is loaded for incident", priority=89)
	public void IN_DE_089_verifyGraphLoadedForIncident() {}

	@Test(description = "Verify graph is changes as per selected Days", priority=90)
	public void IN_DE_090_verifyGraphChangesAsPerSelectedDays() {}

	@Test(description = "Verify Date range picker for Graph", priority=91)
	public void IN_DE_091_verifyDateRangePickerForGraph() {}

	@Test(description = "Verify Last readings are changed as per change in graph", priority=92)
	public void IN_DE_092_verifyLastReadingsChangeAsPerGraph() {}

	@Test(description = "Verify that the Last readings are accurate and up-to-date", priority=93)
	public void IN_DE_093_verifyLastReadingsAccurateAndUpToDate() {}

	@Test(description = "Verify User can select sensor from Last reading dropdown", priority=94)
	public void IN_DE_094_verifyUserCanSelectSensorFromLastReadingDropdown() {}

	@Test(description = "Verify Temperature, Humidity, Pressure Is display in Last reading table as per triggered incident", priority=95)
	public void IN_DE_095_verifyTemperatureHumidityPressureDisplayedInLastReading() {}

	@Test(description = "Verify Scroll option available in Last reading", priority=96)
	public void IN_DE_096_verifyScrollOptionAvailableInLastReading() {}

	@Test(description = "Verify Graph and sensor are same in graph and in Last readings", priority=97)
	public void IN_DE_097_verifyGraphAndSensorSameInGraphAndLastReadings() {}

	@Test(description = "Verify Graph Is displaying for incident from Incident triggered to Incident Closed", priority=98)
	public void IN_DE_098_verifyGraphDisplayedFromIncidentTriggeredToClosed() {}

	@Test(description = "Verify 'Comment' section in history is visible only to 'Admin' Access users", priority=99)
	public void IN_DE_099_verifyCommentSectionVisibleToAdminOnly() {}

	@Test(description = "Display options for each product line item", priority=100)
	public void IN_DE_100_verifyDisplayOptionsForProductLineItem() {}
	@Test(description = "Display options for each product line item", priority=100)
	public void IN_DE_100_displayOptionsForProductLineItem() {
	    
	}

	@Test(description = "Select 'Reject' for a product", priority=101)
	public void IN_DE_101_selectRejectForProduct() {
	    
	}

	@Test(description = "Select 'Release' for a product", priority=102)
	public void IN_DE_102_selectReleaseForProduct() {
	    
	}

	@Test(description = "Manage multiple product disposition (partial release)", priority=103)
	public void IN_DE_103_manageMultipleProductDisposition() {
	    
	}

	@Test(description = "Verify product disposition changes are saved", priority=104)
	public void IN_DE_104_verifyProductDispositionChangesSaved() {
	    
	}

	@Test(description = "Prevent saving if no disposition is selected", priority=105)
	public void IN_DE_105_preventSavingIfNoDispositionSelected() {
	    
	}

	@Test(description = "Display confirmation before saving partial release", priority=106)
	public void IN_DE_106_displayConfirmationBeforeSavingPartialRelease() {
	    
	}

	@Test(description = "Ensure proper filtering in product line items based on status", priority=107)
	public void IN_DE_107_ensureProperFilteringInProductLineItems() {
	    
	}

	@Test(description = "Prevent editing dispositions after final approval", priority=108)
	public void IN_DE_108_preventEditingDispositionsAfterFinalApproval() {
	    
	}

	@Test(description = "Record disposition changes in incident history", priority=109)
	public void IN_DE_109_recordDispositionChangesInIncidentHistory() {
	    
	}
}

	