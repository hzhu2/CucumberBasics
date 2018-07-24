package Steps;

import Base.BaseUtil;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransformer;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

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
    }

    @And("^I enter the username as admin and password as admin$")
    public void iEnterTheUsernameAsAdminAndPasswordAsAdmin() throws Throwable {
        System.out.println("I enter the username as admin and password as admin, hardcoded");
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {

    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {
        System.out.println("The driver is : " + base.StepInfo);
        System.out.println("I should see userform page");
    }

    @And("^I enter again the username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iEnterAgainTheUsernameAsAndPasswordAs(String username, String password) throws Throwable {
        System.out.println("UserName is " + username + " and password is" + password);
    }

    @And("^I enter the following for login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
/*        List<List<String>> data = table.raw();

        System.out.println("The Value1 is : " + data.get(0).get(0));
        System.out.println("The Value1 is : " + data.get(0).get(1));
        System.out.println("The Value2 is : " + data.get(1).get(0));
        System.out.println("The Value2 is : " + data.get(1).get(1));
        System.out.println("The Value3 is : " + data.get(2).get(0));
        System.out.println("The Value3 is : " + data.get(2).get(1));*/

        //Create an ArrayList
        List<User> users = new ArrayList<User>();
        //Store all the users
        users = table.asList(User.class);

        for (User user: users) {
            System.out.println("The username is " + user.username);
            System.out.println("The password is " + user.password);
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
