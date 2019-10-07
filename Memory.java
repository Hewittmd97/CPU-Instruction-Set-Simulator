import java.io.*;

public class Memory
{
    static int[] memary = new int[2000];
    static BufferedReader Instread = null;
    static BufferedReader Fileread = null;
    static String str = null;

    public static void main(String[] args1)
    {
        try
        {
            Fileread = new BufferedReader(new FileReader(args1[0]));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("There was an error in Memory when opening the file.");
            System.exit(1);
        }
        try
        {
            String line = null;
            String[] arr;
            int temp = 0;
            while((line = Fileread.readLine()) != null)
            {
                if(line.contains("."))
                {
                    temp = Integer.parseInt(line.substring(1));
                    continue;
                }
                else if(line.contains(" "))
                {
                    arr = line.split(" ", -1);
                    for(int i = 0; i < arr.length; i++)
                    {
                        memary[temp++] = Integer.parseInt(arr[i]);
                        System.out.println(arr[i]);
                    }
                }
                else
                {
                    memary[temp++] = Integer.parseInt(line);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        System.out.println(memary[1000]);
        Instread = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            try
            {
                str = Instread.readLine();
            }
            catch(IOException e)
            {
                System.out.println("Error reading memory.");
            }
            if(str != null)
            {
                try
                {
                    System.out.println(memary[Integer.parseInt(str)]);
                }
                catch(NumberFormatException e)
                {
                    memary[Integer.parseInt(str.split(" ")[0])] = Integer.parseInt(str.split(" ")[1]);
                }

            }
        }
    }
}
