package editor.cn;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Predicate;

public class test {

    public static void main(String[] args) throws IOException {
        HashMap<Integer,Integer> map = new HashMap();
        map.put(1,1);
        map.put(1,2);
        map.put(1,3);
        System.out.println(map.get(1));

    }
}
