package pemira.Controller;

/**
 *
 * @author Gazali
 */

import Pemira.View.VoterInfo;
import Pemira.View.VotingDone;
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

        boolean voteSuccessful = model.vote(name, nim, age, tingkat, kelas, email, candidate, username);

        if (voteSuccessful) {
            new VotingDone(view, true,username).setVisible(true);
            view.setVisible(false); // Hide the current view
        }
    }
}
