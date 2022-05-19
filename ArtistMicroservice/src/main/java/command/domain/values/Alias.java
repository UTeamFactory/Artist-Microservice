package command.domain.values;


public class Alias {

    private String value;
    private int MAX_LENGTH = 50;

    private Alias(String alias){
        value = alias;
    }

    protected Alias(){
        value = "";
    }


}
