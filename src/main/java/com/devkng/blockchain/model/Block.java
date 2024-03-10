package com.devkng.blockchain.model;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static com.devkng.blockchain.utility.utility.sha256;


public class Block {
    private int previousHash;
    public String[] transactions ;
    private int blockHash ;
    private Transaction transaction ;
    //private int nextHash ;

    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    String gen = sha256(String.valueOf(timeStamp.hashCode()));


    public Block(int previousHash, String[] transactions) {
        this.previousHash = previousHash;
        this.transactions = transactions;

        Object[] contents = {Arrays.hashCode(transactions),previousHash};
        this.blockHash = Arrays.hashCode(contents);
    }

    public Block(int previousHash, Transaction transactions) {
        this.previousHash = previousHash;
        this.transaction = transactions;

        Object[] contents = {transactions.toString(),previousHash};
        this.blockHash = Arrays.hashCode(contents);
    }



    public Block() {
    }

    public int getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(int previousHash) {
        this.previousHash = previousHash;
    }

    public String[] getTransactions() {
        return transactions;
    }

    public void setTransactions(String[] transactions) {
        this.transactions = transactions;
    }

    public int getBlockHash() {
        return blockHash;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
