package Pemira.Model;

/**
 *
 * @author Gazali
 */

public class TerminateVotingModel {
    private static boolean votingState = true; // true means voting is active

    public boolean isVotingActive() {
        return votingState;
    }

    public void setVotingState(boolean state) {
        votingState = state;
    }
}
