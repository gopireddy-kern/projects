class Message {
    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class MessagePrinter {
    public void print(Message message) {
        System.out.println(message.getContent());
    }
}

public class Single {
    public static void main(String[] args) {
        Message msg = new Message("Hello SOLID");
        MessagePrinter printer = new MessagePrinter();
        printer.print(msg);
    }
}
