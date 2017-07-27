import java.io.*;

/**
 * Created by Angel on 26.07.2017.
 */
public class Parser {
    Parser(){
        try {
            String[] ss = readTextFile("list.tsv").split("\n");
            String[] tmp;
            String[] result= new String[ss.length];
            VCard[] vCards = new VCard[ss.length];
            for (int i=0; i<ss.length; i++){
                System.out.println(ss[i]);
                tmp=ss[i].split("\t");
                vCards[i]=new VCard(tmp[0],tmp[1],tmp[2],tmp[3], tmp[4], tmp[5]);
                result[i] = vCards[i]+"";
            }

            writeTextFile(result,"contacts.vcf");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //System.out.println(new VCard("Фамилия","Имя","Отчество","+71234567890","Компания","Должность"));
        //System.out.println(new VCard().setFam("Фамилия").setName("Имя").setOtc("Отчество").setTel_cell("+71234567890").setOrg("Компания").setTitle("Должность"));

    }


    public static String readTextFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        if (file.exists()) {
            try {
                BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                } finally {
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sb.toString();
    }

    public static void writeTextFile(String[] text, String fileName) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                for (int i=0;i<text.length;i++){
                    out.println(text[i]);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
