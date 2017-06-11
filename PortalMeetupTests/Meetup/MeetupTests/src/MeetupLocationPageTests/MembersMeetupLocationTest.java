package MeetupLocationPageTests;
import org.junit.Assert;
import org.junit.Test;
import BaseTests.CommonTest;
import MeetupLocationPageFeatures.MeetupLocationPage;

/*
 * @author Anjali
 */

/*
 * A meetup location should be added prior to this test.
 * Checks navigation to the members page of a Meetup location
 */
public class MembersMeetupLocationTest extends CommonTest
{

	@Test
	public void test() 
	{
		Assert.assertEquals(true, MeetupLocationPage.IsAtMembers());
	}

}
