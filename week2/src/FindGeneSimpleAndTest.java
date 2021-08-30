import edu.duke.*;
import java.lang.String;


public class FindGeneSimpleAndTest {

    public String findGeneSimple(String dna){
        // start codon is "ATG";
        // stop codon is "TAA";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
//        int endIndex = dna.indexOf("TAA"); // need to change to the below one so that TAA
        // won't come before ATG
        int endIndex = dna.indexOf("TAA", startIndex+3);
        if (endIndex == -1){
            return "";
        }
        if((endIndex - startIndex) % 3 == 0){
            return dna.substring(startIndex, endIndex+3);
        }else{
            return "";
        }
    }

    public void testGeneFinding(){
        String gene1 = ""; // not multiple of three
        String dna1 = "CTAGCTATGCCTAAACTGAT";
        String gene2 = "ATGTAA";
        String dna2 = "ATGTAA";
        String dna3 = "TAAATGCCCCTAACCC";
        String gene3 = "ATGCCCCTAA";
        if(findGeneSimple(dna3).equals(gene3)){
            System.out.println("You successfully find the gene!");

        }
    }

    public static void main(String[] args) {
        FindGeneSimpleAndTest gs = new FindGeneSimpleAndTest();
        gs.testGeneFinding();
    }
}
