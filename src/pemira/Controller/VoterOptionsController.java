package pemira.Controller;

import Pemira.Model.TerminateVotingModel;
import Pemira.View.BarChart;
import Pemira.View.MainPage;
import Pemira.View.VoterInfo;
import Pemira.View.VoterOptions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import pemira.Model.VoterOptionsModel;

public class VoterOptionsController {
    private VoterOptionsModel model;
    private VoterOptions view;
    private String username;
    private TerminateVotingModel votingModel;

    public VoterOptionsController(VoterOptions view, String username) {
        this.model = new VoterOptionsModel();
        this.view = view;
        this.username = username;
        this.votingModel = new TerminateVotingModel();

        // Attach listeners to the view's buttons
        this.view.addToVoteButtonListener(new ToVoteButtonListener());
        this.view.addBackToMainButtonListener(new BackToMainButtonListener());
        this.view.addStatschartButtonListener(new StatschartButtonListener());
    }

    // ActionListener for the To Vote button
    class ToVoteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!votingModel.isVotingActive()) {
                view.showMessage("Masa Voting telah berakhir");
            } else {
                try {
                    if (model.hasUserAlreadyVoted(username)) {
                        view.showMessage("Anda telah melakukan voting");
                    } else {
                        navigateToVote(); // Call navigateToVote method
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    view.showMessage("Error: " + ex.getMessage());
                }
            }
        }
    }

    // Method to navigate to the Voting Information view
    public void navigateToVote() {
        if (votingModel.isVotingActive()) {
            new VoterInfo(username).setVisible(true);
            view.setVisible(false);
        } else {
            view.showMessage("Masa Voting telah berakhir");
        }
    }

    // ActionListener for the Back to Main button
    class BackToMainButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateToMainPage();
        }
    }

    // ActionListener for the Stats Chart button
    class StatschartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateToStatsChart();
        }
    }

    // Method to navigate to the Main Page view
    public void navigateToMainPage() {
        new MainPage().setVisible(true);
        view.setVisible(false); // Assuming `setVisible()` method exists in VoterOptions view
    }

    // Method to navigate to the Stats Chart view
    public void navigateToStatsChart() {
        new BarChart().setVisible(true);
        view.setVisible(false); // Assuming `setVisible()` method exists in VoterOptions view
    }
}
