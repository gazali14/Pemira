package pemira.Controller;

/**
 *
 * @author Gazali
 */

import Pemira.Model.TerminateVotingModel;
import Pemira.View.BarChart;
import Pemira.View.MainPage;
import Pemira.View.VoterInfo;
import Pemira.View.VoterOptions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        this.view.addToVoteButtonListener(new ToVoteButtonListener());
        this.view.addBackToMainButtonListener(new BackToMainButtonListener());
        this.view.addStatschartButtonListener(new StatschartButtonListener());
    }

    public void navigateToVote() {
        if (votingModel.isVotingActive()) {
            new VoterInfo(username).setVisible(true);
            view.setVisible(false);
        } else {
            view.showMessage("Masa Voting telah berakhir");
        }
    }

    class ToVoteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!votingModel.isVotingActive()) {
                view.showMessage("Masa Voting telah berakhir");
            } else {
                if (model.hasUserAlreadyVoted(username)) {
                    view.showMessage("Anda telah melakukan voting");
                } else {
                    navigateToVote();
                }
            }
        }
    }

    class BackToMainButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateToMainPage();
        }
    }

    class StatschartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateToStatsChart();
        }
    }

    public void navigateToMainPage() {
        new MainPage().setVisible(true);
        view.setVisible(false);
    }

    public void navigateToStatsChart() {
        new BarChart().setVisible(true);
        view.setVisible(false);
    }
}
