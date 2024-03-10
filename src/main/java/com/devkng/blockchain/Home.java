package com.devkng.blockchain;

import com.devkng.blockchain.model.Block;
import com.devkng.blockchain.model.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static com.devkng.blockchain.utility.utility.sha256;


public class Home {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Block> blockChain = new ArrayList<Block>();

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String gen = sha256(String.valueOf(timeStamp.hashCode()));

        String[] s = {"Dinesh sends 100 to DhanushRaj", "DhanushRaj sends 100 to Gokul"};
        String[] s1 = {"Gokul sends 1000 to DhanushRaj", "DhanushRaj sends 100 to Gokul"};
        String[] s2 = {"Gokul sends 1000 to Bharath", "Bharath sends 100 to Gokul"};


        Block b = new Block(timeStamp.hashCode(), s);
        Block b1 = new Block(b.getBlockHash(), s1);
        Block b2 = new Block(b1.getBlockHash(), s1);

/*
        System.out.println(b.getBlockHash());
        System.out.println(b1.getBlockHash());
        System.out.println(b1.getBlockHash());

        1234279082 -> 1413088279
        126835808 -> 1553762816

        blockChain.add(b);
        blockChain.add(b1);
        blockChain.add(b2);

        System.out.println(); -695162283 -695162283 -> 2063392943
        System.out.println("From b  : " + b.getPreviousHash() + " Current BlockHash Code  b : "+ b.getBlockHash());
        System.out.println("From b1 : " + b.getBlockHash() + " Current BlockHash Code b1 : " + b1.getBlockHash());
        System.out.println("From b2 : " + b1.getBlockHash() + " Current BlockHash Code b2 : " + b.getBlockHash());
         */
        int currentHash = 0;
        for (int i = 0; i < 10; i++) {
            // -1094262049 -> Dk ->  -1094262049 //-695162283 -> Dinesh -> -695162283 //461296306 9Rs ->
            Transaction t = new Transaction(gen + i*2,true,777471*i+675);
            String[] si = {"Dinesh sends " + i + " to DhanushRaj ", " DhanushRaj sends " + i + " to Gokul"};
            System.out.println();
            String[] de ={ t.toData()};
            System.out.println(t.toData());
            Block bi = new Block(currentHash,de);
            System.out.println("From block" + i + " : " + currentHash + " Current BlockHash Code of block"+i+ " : " + bi.getBlockHash());

            blockChain.add(bi);
            currentHash = blockChain.get(blockChain.size()-1).getBlockHash();
            System.out.println(currentHash);
            System.out.println(Arrays.toString(si));
            System.out.println();
            Thread.sleep(1000);

        }
        //blockChain.clear();  -1111219193 -> 532868221
        String[] si = {"Dinesh sends " + 8 + " to DhanushRaj ", " DhanushRaj sends " + 8 + " to Gokul"};
        System.out.println();
        Block bi = new Block(currentHash, si);
        System.out.println("From b" + 8 + " : " + currentHash + " Current BlockHash Code b2 : " + bi.getBlockHash());


    }

    static int value(int pre, int next, Block b){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String gen = sha256(String.valueOf(timeStamp.hashCode()));
        return (pre == 0) ? gen.hashCode() : b.getPreviousHash();
    }


}
