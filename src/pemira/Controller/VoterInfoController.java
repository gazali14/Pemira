package pemira.Controller;

import Pemira.View.VoterInfo;
import Pemira.View.VotingDone;
import java.sql.SQLException;
import pemira.Model.VoterInfoModel;

public class VoterInfoController {

    private VoterInfoModel model;
    private VoterInfo view;
    private String username;

    public VoterInfoController(VoterInfo view, String username) {
        this.model = new VoterInfoModel();
        this.view = view;
        this.username = username;
    }

    public void voteButtonClicked() {
        String name = view.getNama();
        String nim = view.getNim();
        int age = view.getAge();
        String tingkat = view.getTingkat();
        String kelas = view.getKelas();
        String email = view.getEmail();
        String candidate = view.getCandidate();

        try {
            model.vote(name, nim, age, tingkat, kelas, email, candidate, username);
            new VotingDone(view,true ).setVisible(true);
        } catch (SQLException e) {
            view.showMessage("Error while voting: " + e.getMessage());
        }
    }
}
