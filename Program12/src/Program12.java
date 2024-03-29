//Kyle Pineiro

import java.io.*;
import java.util.HashMap;

public class Program12
{
    public static void main(String[] args)
    {
        HashMap<String, Integer> hashMapDefault = new HashMap<>();
        processFile("dracula.txt", hashMapDefault);
        writeResults("results.txt", "Default", hashMapDefault);
        HashMap<String, Integer> hashMapWithCapacity = new HashMap<>(10000, 0.75f);
        processFile("dracula.txt", hashMapWithCapacity);
        writeResults("results.txt", "Capacity 10,000", hashMapWithCapacity);
        HashMap<String, Integer> hashMapWithCapacity20k = new HashMap<>(20000, 0.75f);
        processFile("dracula.txt", hashMapWithCapacity20k);
        writeResults("results.txt", "Capacity 20,000", hashMapWithCapacity20k);
    }

    private static void processFile(String fileName, HashMap<String, Integer> hashMap)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] words = line.toLowerCase().split("[^a-zA-Z']+");
                for (String word : words)
                {
                    hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void writeResults(String fileName, String header, HashMap<String, Integer> hashMap)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true)))
        {

            writer.println("Kyle Pineiro");
            writer.println(header + " Results:");
            writer.println("Time: " + System.currentTimeMillis());
            writer.println("Size: " + hashMap.size());
            writer.println("Number of Nodes: " + hashMap.entrySet().size());
            writer.println("Load Factor: " + calculateLoadFactor(hashMap));
            writer.println("The number of nodes in the hashing algorithm for program 11"
            + " is 100019, and 200013");
            writer.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static float calculateLoadFactor(HashMap<?, ?> hashMap)
    {
        return ((float) hashMap.size()) / hashMap.keySet().size();
    }
}



