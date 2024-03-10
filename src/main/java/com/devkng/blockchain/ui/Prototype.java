package com.devkng.blockchain.ui;

import com.devkng.blockchain.model.Block;
import com.devkng.blockchain.model.Transaction;
import com.devkng.blockchain.model.User;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.devkng.blockchain.ui.Prototype.blockChain;
import static com.devkng.blockchain.utility.utility.sha256;
import static java.lang.String.valueOf;

public class Prototype {
    public static int currentHashs ;
    private static String loop = "y";
    private static ArrayList<User> uc;
    private static String USER;
    public static ArrayList<Block> blockChain = new ArrayList<Block>();

    public static boolean STOP = false ;

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String gen = sha256(valueOf(timeStamp.hashCode()));
        int currentHashs = 0;

        MultithreadOne b = new MultithreadOne();
        MultithreadInterfaces mi = new MultithreadInterfaces();
        b.start();
        mi.start();


        System.out.println("------------------------------------------------------");
        System.out.println("✩░▒▓▆▅▃▂▁  \uD835\uDDB6\uD835\uDDBE\uD835\uDDC5\uD835\uDDC5\uD835\uDDBC\uD835\uDDC8\uD835\uDDC6\uD835\uDDBE \uD835\uDDB3\uD835\uDDC8 \uD835\uDDA3\uD835\uDDBE\uD835\uDDCF\uD835\uDDC4\uD835\uDDC7\uD835\uDDC0 \uD835\uDDA1\uD835\uDDC5\uD835\uDDC8\uD835\uDDBC\uD835\uDDC4\uD835\uDDBC\uD835\uDDC1\uD835\uDDBA\uD835\uDDC2\uD835\uDDC7 \uD835\uDDAD\uD835\uDDBE\uD835\uDDCD\uD835\uDDD0\uD835\uDDC8\uD835\uDDCB\uD835\uDDC4  ▁▂▃▅▆▓▒░✩");
        System.out.println("------------------------------------------------------");
        System.out.println();





    }




}
