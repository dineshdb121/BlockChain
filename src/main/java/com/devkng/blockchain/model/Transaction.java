package com.devkng.blockchain.model;

public class Transaction {
    private String[] s ;
    private String UID ;
    public boolean vote ;
    public int votedPartyHash ;


    public Transaction(String UID, boolean vote, int votedPartyHash) {
        this.UID = UID;
        this.vote = vote;
        this.votedPartyHash = votedPartyHash;
    }

    public Transaction() {

    }

    @Override
    public String toString() {
        return "Transaction{" +
                "UID='" + UID + '\'' +
                ", vote=" + vote +
                ", votedPartyHash=" + votedPartyHash +
                '}';
    }
    public String toData() {
        return (UID+vote+votedPartyHash).toString();
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public int getVotedPartyHash() {
        return votedPartyHash;
    }

    public void setVotedPartyHash(int votedPartyHash) {
        this.votedPartyHash = votedPartyHash;
    }

}
