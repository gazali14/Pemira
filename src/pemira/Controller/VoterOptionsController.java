package pemira.Controller;

import Pemira.View.BarChart;
import Pemira.View.MainPage;
import Pemira.View.TerminateVoting;
import Pemira.View.VoterInfo;
import Pemira.View.VoterOptions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pemira.Model.VoterOptionsModel;

public class VoterOptionsController {
    private VoterOptionsModel model;
    private VoterOptions view;
    private String username;

    public VoterOptionsController(VoterOptions view, String username) {
        this.model = new VoterOptionsModel();
        this.view = view;
        this.username = username;

        // Attach listeners to the view's buttons
        this.view.addToVoteButtonListener(new ToVoteButtonListener());
        this.view.addBackToMainButtonListener(new BackToMainButtonListener());
        this.view.addStatschartButtonListener(new StatschartButtonListener());
    }

    // ActionListener for the To Vote button
    class ToVoteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!TerminateVoting.statebutton) {
                view.showMessage("Masa Voting telah berakhir");
            } else {
                try {
                    if (model.hasUserAlreadyVoted(username)) {
                        view.showMessage("Anda telah melakukan voting");
                    } else {
                        navigateToVoterInfo(username);
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    view.showMessage(ex.getMessage());
                }
            }
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
    
    public void navigateToVoterInfo(String username) {
        new VoterInfo(username).setVisible(true);
        view.setVisible(false);
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
