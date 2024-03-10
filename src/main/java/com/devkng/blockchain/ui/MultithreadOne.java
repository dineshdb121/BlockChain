package com.devkng.blockchain.ui;

import com.devkng.blockchain.model.Block;
import com.devkng.blockchain.model.Transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.devkng.blockchain.ui.Prototype.blockChain;
import static com.devkng.blockchain.utility.utility.sha256;
import static java.lang.String.valueOf;

class MultithreadOne extends Thread {
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    String gen = sha256(valueOf(timeStamp.hashCode()));
    //public static int currentHashs ;

    public void run() {
        for (int i = 0; i < blockChain.size() + 1; i++) {

            Transaction tr = new Transaction(gen + i * 2, true, 777471 * i + 675);
            String[] si = {"Dinesh sends " + i + " to DhanushRaj ", " DhanushRaj sends " + i + " to Gokul"};
            //System.out.println();
            String[] de = {tr.toData()};
            //System.out.println(tr.toData());
            Block bi = new Block(Prototype.currentHashs, de);
            //System.out.println("From block" + i + " : " + currentHashs + " Current BlockHash Code of block" + i + " : " + bi.getBlockHash());


            blockChain.add(bi);
            Prototype.currentHashs = blockChain.get(blockChain.size() - 1).getBlockHash();


            // System.out.println(currentHashs);
            // System.out.println(Arrays.toString(si));
            //System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}