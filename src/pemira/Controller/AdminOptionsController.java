package pemira.Controller;

/**
 *
 * @author Gazali
 */

import Pemira.View.AdminOptions;
import Pemira.View.EnableVoting;
import Pemira.View.TerminateVoting;
import Pemira.View.ViewRecords;
import Pemira.View.AdminChart;
import Pemira.View.MainPage;

public class AdminOptionsController {
    private AdminOptions view;

    public AdminOptionsController(AdminOptions view) {
        this.view = view;
    }

    public void navigateToViewRecords() {
        new ViewRecords().setVisible(true);
        view.setVisible(false);
    }

    public void navigateToMainPage() {
        new MainPage().setVisible(true);
        view.setVisible(false);
    }

    public void navigateToAdminChart() {
        new AdminChart().setVisible(true);
        view.setVisible(false);
    }

    public void navigateToTerminateVoting() {
        new TerminateVoting().setVisible(true);
        view.setVisible(false);
    }

    public void navigateToEnableVoting() {
        new EnableVoting().setVisible(true);
        view.setVisible(false);
    }
}
