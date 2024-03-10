package com.devkng.blockchain.ui;

import com.devkng.blockchain.model.Block;
import com.devkng.blockchain.model.Transaction;
import com.devkng.blockchain.model.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static com.devkng.blockchain.ui.Prototype.STOP;
import static com.devkng.blockchain.ui.Prototype.blockChain;
import static com.devkng.blockchain.utility.utility.sha256;

class MultithreadInterfaces extends Thread {
        public void run() {
            //Parties Adding
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ArrayList<User> parties = new ArrayList<User>();
            User pat = new User();
            int n;
            Scanner sc = new Scanner(System.in);
            System.out.print("How many parties want to participate : ");

            n = sc.nextInt();


            for (int i = 0; i < n; i++) {

                Scanner s = new Scanner(System.in);
                System.out.print("Enter party name : ");
                String ns = s.next();
                pat = new User();
                pat.setAadhar(ns);
                pat.setUid(sha256(sha256(ns)).hashCode());
                parties.add(pat);
            /*
            User{aadhar='dk', uid=581364843}
            User{aadhar='kd', uid=1930455419}
             */


            }

            // Adding the n number of Users
            int temp = 0;
            ArrayList<User> userslistloop = new ArrayList<User>();
            User us = new User();

            Scanner stemp = new Scanner(System.in);
            System.out.print("Enter Your Aadhaar number to Login : ");
            String USER = stemp.next();
            us.setAadhar(USER);
            us.setUid(sha256(sha256(USER)).hashCode());
            userslistloop.add(us);


            // Ask Vote
            System.out.println("participated candidates parties are : ");
            for (int i = 0; i < n; i++) {
                System.out.println(i + ") : " + parties.get(i).getAadhar() + "\t");
            }

            Scanner vote = new Scanner(System.in);
            System.out.print("Enter party name to vote : ");
            String vo = vote.next();
            System.out.println(vo);
            System.out.println();
            for (int i = 0; i < parties.size(); i++) {
                if (Objects.equals(parties.get(i).getAadhar(), vo)) {
                    Transaction t = new Transaction();
                    t.setUID(String.valueOf(us.getUid()));
                    t.setVote(true);
                    t.setVotedPartyHash(parties.get(i).getUid());
                    System.out.println("You Voted Successfully T : " + t.toData());
                    String[] strings = {t.toData()};
                    Block b = new Block(Prototype.currentHashs,t);
                    //b.setPreviousHash(blockChain.get(blockChain.size() - 1).getBlockHash());
                    //b.setTransaction(t);
                    System.out.println( blockChain.size() - 1 + "  You Voted Successfully Block Hash code : " + blockChain.get(blockChain.size() - 1).getBlockHash());
                    blockChain.add(b);
                   // blockChain.add(b);
                    //Prototype.currentHashs = blockChain.get(blockChain.size()-1).getBlockHash();
                    System.out.println(Prototype.currentHashs);
                    Prototype.currentHashs = b.getBlockHash();

                }

            }


            // Output
            System.out.println("\uD835\uDDB4\uD835\uDDCC\uD835\uDDBE\uD835\uDDCB\uD835\uDDCC \uD835\uDDBA\uD835\uDDCB\uD835\uDDBE  : ");
            for (int i = 0; i <  1; i++) {
                System.out.println(userslistloop.get(i));
            }
            System.out.println("\uD835\uDDAF\uD835\uDDBA\uD835\uDDCB\uD835\uDDCD\uD835\uDDC2\uD835\uDDBE\uD835\uDDCC \uD835\uDDBA\uD835\uDDCB\uD835\uDDBE : ");
            for (int i = 0; i < n; i++) {
                System.out.println(parties.get(i).toString());
            }
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            STOP=true;
            System.out.println();
            for (int i = 0; i < blockChain.size(); i++) {
               System.out.println("From " + i + ": "+ blockChain.get(i).getPreviousHash() + " To : " +  blockChain.get(i).getBlockHash());
            }



        }
    }