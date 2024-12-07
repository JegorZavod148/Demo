public class sSchool {

    String couchName;
    int studentNum;
    int lessonNum;
    static int couchNum = 0;

    public void plusCouch(String couchName) {
        this.couchName = couchName;

        while (couchName != " "){
            couchNum++;
        }
    }


}
