
package tests.HezkyTechPageTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import HezkyTechTestData.CustomerPanelTestData;
import pages.HezkyTech.HezkyTechPageBase;
import tests.TestBase;

public class IncidentPageTest extends TestBase {

	HezkyTechPageBase hezkyTechPageBase;
	CustomerPanelTestData customerPanelTestData = new CustomerPanelTestData();

	@Override
	@BeforeClass
	protected void initPageObject() {
		hezkyTechPageBase = new HezkyTechPageBase(driverManager);
	}
	@Test(description = "Verify Incident page is loaded properly", priority=1)
	public void IN_001_verifyIncidentPageLoadedProperly() {
	    
	}

	@Test(description = "Verify that the All active incidents are displayed correctly", priority=2)
	public void IN_002_verifyAllActiveIncidentsDisplayedCorrectly() {
	    
	}

	@Test(description = "Verify Different tabs are showing as per Severity for incident", priority=3)
	public void IN_003_verifyTabsShownAsPerSeverity() {
	    
	}

	@Test(description = "Verify click on Approved display correct incident list", priority=4)
	public void IN_004_verifyApprovedTabDisplaysCorrectList() {
	    
	}

	@Test(description = "Verify click on Pending display correct incident list", priority=5)
	public void IN_005_verifyPendingTabDisplaysCorrectList() {
	    
	}

	@Test(description = "Verify click on No action display correct incident list", priority=6)
	public void IN_006_verifyNoActionTabDisplaysCorrectList() {
	    
	}

	@Test(description = "Verify click on In progress display correct incident list", priority=7)
	public void IN_007_verifyInProgressTabDisplaysCorrectList() {
	    
	}

	@Test(description = "Verify click on Rejected display correct incident list", priority=8)
	public void IN_008_verifyRejectedTabDisplaysCorrectList() {
	    
	}

	@Test(description = "Verify show more button and show less button is working correctly in collapsible", priority=9)
	public void IN_009_verifyShowMoreAndShowLessButtonsWorkCorrectly() {
	    
	}

	@Test(description = "Verify that the incident details (assets, location, incident ID, active alarms, severity, triggered time, status, assigned to) are displayed correctly", priority=10)
	public void IN_010_verifyIncidentDetailsDisplayedCorrectly() {
	    
	}

	@Test(description = "Verify status for incident is changed as per change in incident", priority=11)
	public void IN_011_verifyIncidentStatusChangesCorrectly() {
	    
	}

	@Test(description = "Verify User gets confirmation message before assigned user", priority=12)
	public void IN_012_verifyConfirmationMessageBeforeAssigningUser() {
	    
	}

	@Test(description = "Verify that the incident can be assigned to user using 'Assigned To' dropdown", priority=13)
	public void IN_013_verifyIncidentCanBeAssignedToUser() {
	    
	}

	@Test(description = "Verify user Gets Notification when user assigned from the Assign to dropdown", priority=14)
	public void IN_014_verifyUserGetsNotificationOnAssignment() {
	    
	}

	@Test(description = "Verify that the search functionality works correctly", priority=15)
	public void IN_015_verifySearchFunctionalityWorksCorrectly() {
	    
	}

	@Test(description = "Verify that date filters work correctly", priority=16)
	public void IN_016_verifyDateFiltersWorkCorrectly() {
	    
	}

	@Test(description = "Verify Incident filter has required options", priority=17)
	public void IN_017_verifyIncidentFilterHasRequiredOptions() {
	    
	}

	@Test(description = "Verify Incident Status has required option with Checkbox", priority=18)
	public void IN_018_verifyIncidentStatusHasRequiredOptions() {
	    
	}

	@Test(description = "Verify Severity has required options with check box for High, Low, Medium", priority=19)
	public void IN_019_verifySeverityHasRequiredOptions() {
	    
	}

	@Test(description = "Verify Assets filter show all selectable checkbox values for available asset on location", priority=20)
	public void IN_020_verifyAssetsFilterShowsSelectableCheckboxValues() {
	    
	}

	@Test(description = "Verify Assigned To has Checkbox of Users as per selected location", priority=21)
	public void IN_021_verifyAssignedToHasCheckboxOfUsers() {
	    
	}

	@Test(description = "Verify filter popup has working Apply button", priority=22)
	public void IN_022_verifyFilterPopupHasApplyButton() {
	    
	}

	@Test(description = "Verify Filter popup should be closed automatically and shows filtered list", priority=23)
	public void IN_023_verifyFilterPopupClosesAutomatically() {
	    
	}

	@Test(description = "Verify filter popup has working close button", priority=24)
	public void IN_024_verifyFilterPopupHasCloseButton() {
	    
	}

	@Test(description = "Verify filter popup has working Reset button", priority=25)
	public void IN_025_verifyFilterPopupHasResetButton() {
	    
	}

	@Test(description = "Verify that the 'Active Incidents' section updates correctly based on incidents' severity", priority=26)
	public void IN_026_verifyActiveIncidentsSectionUpdatesCorrectly() {
	    
	}

	@Test(description = "Verify that the incident list updates correctly when an incident's status is changed", priority=27)
	public void IN_027_verifyIncidentListUpdatesOnStatusChange() {
	    
	}

	@Test(description = "Verify incident list should Update severity when increased", priority=28)
	public void IN_028_verifyIncidentListUpdatesSeverityWhenIncreased() {
	    
	}

	@Test(description = "Verify that the incident details page opens correctly when clicking on an incident Cards from All Active Incidents", priority=29)
	public void IN_029_verifyIncidentDetailsPageOpensFromCards() {
	    
	}

	@Test(description = "Verify that the incident details page opens correctly when clicking on an incident Name in incident list", priority=30)
	public void IN_030_verifyIncidentDetailsPageOpensFromName() {
	    
	}

	@Test(description = "Verify Incident Id column shows correct incident Id", priority=31)
	public void IN_031_verifyIncidentIdColumnShowsCorrectId() {
	    
	}

	@Test(description = "Verify 'Assigned To' column shows correct Alarms for Incident", priority=32)
	public void IN_032_verifyAssignedToColumnShowsCorrectAlarms() {
	    
	}

	@Test(description = "Verify ACTIVE ALARM column shows correct Alarms for Incident", priority=33)
	public void IN_033_verifyActiveAlarmColumnShowsCorrectAlarms() {
	    
	}

	@Test(description = "Verify severity column shows correct severity with color", priority=34)
	public void IN_034_verifySeverityColumnShowsCorrectSeverity() {
	    
	}

	@Test(description = "Verify Triggered Time column shows correct time of incident triggered", priority=35)
	public void IN_035_verifyTriggeredTimeColumnShowsCorrectTime() {
	    
	}

	@Test(description = "Verify Location column shows correct Location as per selected n-level location", priority=36)
	public void IN_036_verifyLocationColumnShowsCorrectLocation() {
	    
	}

	@Test(description = "Verify that pagination works correctly", priority=37)
	public void IN_037_verifyPaginationWorksCorrectly() {
	    
	}

	@Test(description = "Verify user is Assigned successfully after click on 'Confirm' option with message", priority=38)
	public void IN_038_verifyUserAssignedSuccessfully() {
	    
	}

	@Test(description = "Verify Popup is closed after click on 'Cancel' Option", priority=39)
	public void IN_039_verifyPopupClosesAfterCancel() {
	    
	}
}