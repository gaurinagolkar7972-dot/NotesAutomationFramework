package tests.ui;

import base.BaseTest;
import drivers.DriverManager;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NotesPage;

public class DeleteNoteTest extends BaseTest {

    @Test
    public void deleteNoteTest() {

        DriverManager.getDriver()
                .get("https://practice.expandtesting.com/notes/app/login");

        LoginPage loginPage = new LoginPage();

        loginPage.enterEmail("gaurinagolkar@gmail.com");
        loginPage.enterPassword("Gauri@123");
        loginPage.clickSignIn();

        NotesPage notesPage = new NotesPage();
        notesPage.clickDeleteButton();
        notesPage.confirmDelete();

        System.out.println("Note Deleted Successfully");
    }
}
