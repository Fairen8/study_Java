package Paid_Lessons.Modules.Module_3.les1.les1_4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {
    public static void main(String[] args) {
        try {
            URL website = new URL("http://google.com");
            ReadableByteChannel rbs = Channels.newChannel(website.openStream());
            FileOutputStream file = new FileOutputStream("Paid_Lessons/Modules/Module_3/les1/les1_4/data.html");
            file.getChannel().transferFrom(rbs, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
