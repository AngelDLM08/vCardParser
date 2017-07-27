/**
 * Created by Angel on 26.07.2017.
 */
public class VCard {
    private String fam;
    private String name;
    private String otc;
    private String tel_cell;
    private String org;
    private String title;

    public String getFam() {return fam;}
    public String getName() {return name;}
    public String getOtc() {return otc;}
    public String getTel_cell() {return tel_cell;}
    public String getOrg() {return org;}
    public String getTitle() {return title;}

    public VCard setFam(String fam) {this.fam = fam;    return this;}
    public VCard setName(String name) {this.name = name;    return this;}
    public VCard setOtc(String otc) {this.otc = otc;    return this;}
    public VCard setTel_cell(String tel_cell) {this.tel_cell = tel_cell;    return this;}
    public VCard setOrg(String org) {this.org = org;    return this;}
    public VCard setTitle(String title) {this.title = title; return this;}

    public VCard(){

    }

    public VCard(String fam, String name, String otc, String tel_cell, String org, String title) {
        this.fam = fam;
        this.name = name;
        this.otc = otc;
        this.tel_cell = tel_cell;
        this.org = org;
        this.title = title;
    }

    @Override
    public String toString() {
        return "BEGIN:VCARD\n" +
                "VERSION:2.1\n" +
                "N;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:"
                + stringToBytesToHex(fam) + ";" + stringToBytesToHex(name) + ";" + stringToBytesToHex(otc) + ";;;\n" +
                "FN;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:"
                + stringToBytesToHex(fam) + "=20" + stringToBytesToHex(name) + "=20" + stringToBytesToHex(otc) + "\n" +
                "TEL;CELL:" + tel_cell + "\n" +
                "ORG;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:" + stringToBytesToHex(org) + "\n" +
                "TITLE:#" + title + "\n" +
                "END:VCARD"
                ;
    }


    public String stringToBytesToHex(String s) {
        byte[] bytes = s.getBytes();
        char[] val = new char[3 * bytes.length];
        String hex = "0123456789ABCDEF";
        for (int i = 0; i < bytes.length; i++) {
            int b = bytes[i] & 0xff;
            val[3 * i] = '=';
            val[3 * i + 1] = hex.charAt(b >>> 4);
            val[3 * i + 2] = hex.charAt(b & 15);
        }
        return String.valueOf(val);
    }


}
