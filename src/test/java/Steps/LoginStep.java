package Steps;

import Base.BaseUtil;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransformer;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.junit.Assert;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil {
    private BaseUtil base;
    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        System.out.println("Navigate to login page");
        base.Driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
    }

    @And("^I enter the username as admin and password as admin$")
    public void iEnterTheUsernameAsAdminAndPasswordAsAdmin() throws Throwable {
        System.out.println("I enter the username as admin and password as admin, hardcoded");
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        LoginPage page = new LoginPage(base.Driver);
        page.ClickLogin();
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {

        Assert.assertEquals("It's not displayed", base.Driver.findElement(By.id("Initial")).isDisplayed(), true);

    }

    @And("^I enter again the username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iEnterAgainTheUsernameAsAndPasswordAs(String username, String password) throws Throwable {
        System.out.println("UserName is " + username + " and password is" + password);
    }

    @And("^I enter the following for login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {

        //Create an ArrayList
        List<User> users = new ArrayList<User>();
        //Store all the users
        users = table.asList(User.class);

        LoginPage page = new LoginPage(base.Driver);

        for (User user: users) {
            page.Login(user.username, user.password);
        }
    }

    @And("^I key in ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String username, String password) throws Throwable {
        System.out.println("Username is : " + username);
        System.out.println("Password is : " + password);
    }

    @And("^I enter the users email address as Email:([^\"]*)$")
    public void iEnterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) throws Throwable {
        System.out.println("The Email Address is " + email);
    }

    @And("^I verify the count of my salary digits for Rs (\\d+)$")
    public void iVerifyTheCountOfMySalaryDigitsForRs(@Transform(SalaryCountTransformer.class) int salary) throws Throwable {
        System.out.println("My Salary digits count is: " + salary);
    }

    public class User
    {
        private String username ;
        private String password;

        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }

}
