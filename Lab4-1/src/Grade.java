public class Grade {

    private String name;
    private int java, web, os;

    Grade(String name, int java, int web, int os) {
        this.name = name; this.java = java; this.web = web; this.os = os;
    }

    public String getName() {
        return name;
    }

    public int getAverage() {
        return  (java + web + os) / 3;
    }
}
