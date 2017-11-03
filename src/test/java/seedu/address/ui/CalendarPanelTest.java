package seedu.address.ui;

import static guitests.guihandles.WebViewUtil.waitUntilCalendarLoaded;
import static org.junit.Assert.assertTrue;
import static seedu.address.testutil.EventsUtil.postNow;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import guitests.guihandles.CalendarPanelHandle;
import seedu.address.commons.events.ui.CalendarRequestEvent;

//@@author yilun-zhu

public class CalendarPanelTest extends GuiUnitTest {

    private CalendarPanel calendarPanel;
    private CalendarPanelHandle calendarPanelHandle;
    private CalendarRequestEvent calendarRequestEvent;

    @Before
    public void setUp() {
        calendarRequestEvent = new CalendarRequestEvent();

        guiRobot.interact(() -> calendarPanel = new CalendarPanel());
        uiPartRule.setUiPart(calendarPanel);

        calendarPanelHandle = new CalendarPanelHandle(calendarPanel.getRoot());
    }

    @Test
    public void display() throws Exception {

        postNow(calendarRequestEvent);

        //expected google login page
        URL expectedCalendarUrl = new URL("https://accounts.google.com/ServiceLogin?service=cl&"
                + "passive=1209600&osid=1&continue=https://calendar.google.com/calendar/render&followup="
                + "https://calendar.google.com/calendar/render&scc=1");

        waitUntilCalendarLoaded(calendarPanelHandle);
        assertTrue(expectedCalendarUrl.toString().equals(calendarPanelHandle.getLoadedUrl().toString()));
    }
}
