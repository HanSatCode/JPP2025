public class Memo {
    private String name, time, content;

    public Memo(String name, String time, String content) {
        this.name = name;
        this.time = time;
        this.content = content;
    }
    public boolean isSameName(Memo b) {
        return name.equals(b.name);
    }

    public String getName() {
        return name;
    }

    public void show() {
        System.out.println(name + ", " + time + " " + content);
    }

    public int length() {
        return content.length();
    }
}
