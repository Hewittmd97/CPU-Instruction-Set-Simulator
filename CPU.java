import java.io.*;
import java.util.Random;

import static jdk.nashorn.internal.runtime.ScriptingFunctions.exec;

public class CPU
{
    static BufferedReader buffRead = null;
    static Process mem = null;
    static PrintWriter printer = null;
    static String IR = "0";
    static int PC = 0;
    static int SP = 1000;
    static int AC;
    static int X;
    static int Y;
    static int timer = 0;
    static boolean interupt = true;

    public static void main(String[] args)
    {
        try
        {
            int timeout = Integer.parseInt(args[1]);
            System.out.println("Timer has been parsed and is set to " + timer + ".");
        }
        catch(Exception e)
        {
            System.out.println("Timer value could not be parsed.");
        }
        try
        {
            mem = Runtime.getRuntime().exec("java Memory " + args[0]);
            buffRead = new BufferedReader(new InputStreamReader(mem.getInputStream()));
            printer = new PrintWriter(new OutputStreamWriter(mem.getOutputStream()));
            while(true)
            {
                System.out.println(PC);
                printer.println(PC);
                printer.flush();
                try
                {
                    IR = buffRead.readLine();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                System.out.println(IR);
                if (IR != null && !IR.equals("")) {
                    try {
                        Integer.parseInt(IR);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        mem.destroy();
                    }

                    switch(Integer.parseInt(IR))
                    {
                        case 1:
                            System.out.println("1");
                            PC++;
                            printer.println(PC);
                            printer.flush();
                            try
                            {
                                AC = Integer.parseInt(buffRead.readLine());
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                            PC++;
                            break;
                        case 2:
                            System.out.println("2");
                            PC++;
                            printer.println(PC);
                            printer.flush();
                            try {
                                printer.println(buffRead.readLine());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            printer.flush();
                            try {
                                AC = Integer.parseInt(buffRead.readLine());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            PC++;
                            break;
                        case 3:
                            System.out.println("3");
                            PC++;
                            printer.println(PC);
                            printer.flush();
                            try {
                                printer.println(buffRead.readLine());
                                printer.flush();
                                printer.println(buffRead.readLine());
                                printer.flush();
                                AC = Integer.parseInt(buffRead.readLine());
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 4:
                            System.out.println("4");
                            PC++;
                            printer.println(PC);
                            printer.flush();
                            try {
                                printer.println(Integer.parseInt(buffRead.readLine()) + X);
                                printer.flush();
                                AC = Integer.parseInt(buffRead.readLine());
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 5:
                            System.out.println("5");
                            PC++;
                            printer.println(PC);
                            printer.flush();
                            try {
                                printer.println(Integer.parseInt(buffRead.readLine()) + Y);
                                printer.flush();
                                AC = Integer.parseInt(buffRead.readLine());
                                PC++;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 6:
                            System.out.println("6");
                            printer.println(SP + X);
                            printer.flush();
                            try {
                                AC = Integer.parseInt(buffRead.readLine());
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 7:
                            System.out.println("7");
                            try
                            {
                                PC++;
                                printer.println(PC);
                                printer.flush();
                                printer.println(buffRead.readLine() + " " + AC);
                                printer.flush();
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 8:
                            System.out.println("8");
                            Random rand = new Random();
                            try {
                                AC = rand.nextInt(99) + 1;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 9:
                            System.out.println("9");
                            try {
                                PC++;
                                printer.println(PC);
                                printer.flush();
                                if (Integer.parseInt(buffRead.readLine()) == 1) {
                                    System.out.print(AC);
                                } else {
                                    System.out.print((char) AC);
                                }
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 10:
                            System.out.println("10");
                            try {
                                AC = AC + X;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 11:
                            System.out.println("11");
                            try {
                                AC = AC + Y;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 12:
                            System.out.println("12");
                            try {
                                AC = AC - X;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 13:
                            System.out.println("13");
                            try {
                                AC = AC - Y;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 14:
                            System.out.println("14");
                            try {
                                X = AC;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 15:
                            System.out.println("15");
                            try {
                                AC = X;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 16:
                            System.out.println("16");
                            try {
                                Y = AC;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 17:
                            System.out.println("17");
                            try {
                                AC = Y;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 18:
                            System.out.println("18");
                            try {
                                SP = AC;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 19:
                            System.out.println("19");
                            try {
                                AC = SP;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 20:
                            System.out.println("20");
                            try {
                                PC++;
                                printer.println(PC);
                                printer.flush();
                                PC = Integer.parseInt(buffRead.readLine());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 21:
                            System.out.println("21");
                            try {
                                PC++;
                                if (AC == 0) {
                                    printer.println(PC);
                                    printer.flush();
                                    PC = Integer.parseInt(buffRead.readLine());
                                } else {
                                    PC++;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 22:
                            System.out.println("22");
                            try {
                                PC++;
                                if (AC != 0) {
                                    printer.println(PC);
                                    printer.flush();
                                    PC = Integer.parseInt(buffRead.readLine());
                                } else {
                                    PC++;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 23:
                            System.out.println("23");
                            try {
                                PC++;
                                if (SP > 500) {
                                    SP--;
                                    printer.println(SP + " " + (++PC));
                                    printer.flush();
                                    printer.println(--PC);
                                    printer.flush();
                                    PC = Integer.parseInt(buffRead.readLine());
                                } else {
                                    System.out.println("User stack is full. Unable to perform operation.");
                                    mem.destroy();
                                    System.exit(1);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 24:
                            System.out.println("24");
                            try {
                                printer.println(SP);
                                printer.flush();
                                PC = Integer.parseInt(buffRead.readLine());
                                SP++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 25:
                            System.out.println("25");
                            try {
                                X++;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 26:
                            System.out.println("26");
                            try {
                                X--;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 27:
                            System.out.println("27");
                            try {
                                if (SP > 500) {
                                    SP--;
                                    printer.println(SP + " " + AC);
                                    printer.flush();
                                    PC++;
                                } else {
                                    System.out.println("User stack is full. Unable to perform operation.");
                                    mem.destroy();
                                    System.exit(1);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 28:
                            System.out.println("28");
                            try {
                                printer.println(SP);
                                printer.flush();
                                AC = Integer.parseInt(buffRead.readLine());
                                SP++;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 29:
                            System.out.println("29");
                            try {
                                if (interupt == true) {
                                    printer.println("1999 " + SP);
                                    printer.println("1998 " + (++PC));
                                    printer.println("1997 " + AC);
                                    printer.println("1996 " + X);
                                    printer.println("1995 " + Y);
                                    PC = 1500;
                                    SP = 1995;
                                    interupt = false;
                                } else {
                                    PC++;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 30:
                            System.out.println("30");
                            try {
                                interupt = true;
                                if (SP < 2000) {
                                    printer.println(SP);
                                    printer.flush();
                                    Y = Integer.parseInt(buffRead.readLine());
                                    SP++;
                                    printer.println(SP);
                                    printer.flush();
                                    X = Integer.parseInt(buffRead.readLine());
                                    SP++;
                                    printer.println(SP);
                                    printer.flush();
                                    AC = Integer.parseInt(buffRead.readLine());
                                    SP++;
                                    printer.println(SP);
                                    printer.flush();
                                    PC = Integer.parseInt(buffRead.readLine());
                                    SP++;
                                    printer.println(SP);
                                    printer.flush();
                                    SP = Integer.parseInt(buffRead.readLine());
                                } else {
                                    System.out.println("System stack is empty.");
                                    mem.destroy();
                                    System.exit(1);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 31:
                            System.out.println("31");
                            try
                            {
                                AC = AC % Integer.parseInt(buffRead.readLine());
                                PC++;
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            break;
                        case 32:
                            System.out.println("32");
                            try
                            {

                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            break;
                        case 50:
                            System.out.println("50");
                            try {
                                printer.println("End");
                                System.exit(0);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            System.out.println("There was an error somewhere and no opcode was read.");
                            break;
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
