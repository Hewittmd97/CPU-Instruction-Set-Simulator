import java.io.*;
import java.util.Random;

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
                            Random rand = new Random();
                            try {
                                AC = rand.nextInt(99) + 1;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 9:
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
                            try {
                                AC = AC + X;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 11:
                            try {
                                AC = AC + Y;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 12:
                            try {
                                AC = AC - X;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 13:
                            try {
                                AC = AC - Y;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 14:
                            try {
                                X = AC;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 15:
                            try {
                                AC = X;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 16:
                            try {
                                Y = AC;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 17:
                            try {
                                AC = Y;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 18:
                            try {
                                SP = AC;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 19:
                            try {
                                AC = SP;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 20:
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
                            try {
                                X++;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 26:
                            try {
                                X--;
                                PC++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 27:
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
