package by.epam.task5.code.entity;

public class Message {
    private int id;
    private String to;
    private String from;
    private String heading;
    private String body;

    public Message() {
    }

    public Message(int id, String to, String from, String heading, String body) {
        this.id = id;
        this.to = to;
        this.from = from;
        this.heading = heading;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message product = (Message) o;

        if (id != product.id) return false;
        if (to != null ? !to.equals(product.to) : product.to != null) return false;
        if (from != null ? !from.equals(product.from) : product.from != null) return false;
        if (heading != null ? !heading.equals(product.heading) : product.heading != null) return false;
        return body != null ? body.equals(product.body) : product.body == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (heading != null ? heading.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message:" +
                "id=" + id +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", heading='" + heading + '\'' +
                ", body='" + body + '\'' + "\n";
    }
}