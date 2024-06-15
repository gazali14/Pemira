/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pemira.Controller;

/**
 *
 * @author U53R
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
