package pemira.Controller;

/**
 *
 * @author Gazali
 */

import Pemira.Model.TerminateVotingModel;
import Pemira.View.TerminateVoting;
import Pemira.View.AdminOptions;

public class TerminateVotingController {
    private TerminateVoting view;
    private TerminateVotingModel model;

    public TerminateVotingController(TerminateVoting view) {
        this.view = view;
        this.model = new TerminateVotingModel();
    }

    public void terminateVoting() {
        model.setVotingState(false);
        view.showTerminationMessage();
    }

    public void navigateToAdminOptions() {
        new AdminOptions().setVisible(true);
        view.setVisible(false);
    }
}
