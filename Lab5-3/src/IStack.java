public interface IStack {
    int capacity();
    int length();
    boolean push(String val);

    String pop();
}
