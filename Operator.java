/**
* Clasa abstracta Operator folosita pentru factory si pentru a extinde ge, gt, etc
*/
public abstract class Operator {
    private String ref;
    private String argument;
    private String type;

    public abstract int apply();


    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getType() {
        return type;
    }

    public String getRef() {
        return ref;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public void setType(String type) {
        this.type = type;
    }
}
