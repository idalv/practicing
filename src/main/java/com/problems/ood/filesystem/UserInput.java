package com.problems.ood.filesystem;

import java.io.Console;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/5/15
 * Time: 6:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserInput {
    private static Method cdMethod;
    private static Method mkDirMethod;
    private static Method rmDirMethod;
    private static Method lsMethod;
    private static Method cdUPMethod;

    static {
        try {
            cdMethod = FileSystem.class.getMethod("cd", String.class);
            mkDirMethod = FileSystem.class.getMethod("mkDir", String.class);
            rmDirMethod = FileSystem.class.getMethod("rmDir", String.class);
            lsMethod = FileSystem.class.getMethod("ls");
            cdUPMethod = FileSystem.class.getMethod("cdUP");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    enum Methods {
        cd(cdMethod),
        mkDir(mkDirMethod),
        rmDir(rmDirMethod),
        ls(lsMethod),
        cdUP(cdUPMethod);

        public Method method;

        Methods(Method method) {
            this.method = method;
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        FileSystem fs = new FileSystem();

        Scanner reader = new Scanner(System.in);
        reader.useDelimiter("\n");
        while (true) {
            fs.print();

            if (!reader.hasNext()) {
                continue;
            }

            String[] command = reader.next().split(" ");

            if (command[0].equalsIgnoreCase("exit")) {
                return;
            }

            Methods method = Methods.valueOf(command[0]);

            if (command.length == 1) {
                method.method.invoke(fs);
            } else {
                method.method.invoke(fs, command[1]);
            }
        }
    }
}
