package mx.com.geekflu.design.pattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Exercise{
    public static void main(String[] args){
        CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        System.out.println(cb);
    }
}

class CodeBuilder
{
    public String className;
    private String nl = System.lineSeparator();
    public List<Field>   fields = new ArrayList<>();
    
    public CodeBuilder(String className)
    {
        this.className = className;
    }
    
    public CodeBuilder addField(String name, String type)
    {
        this.fields.add(new Field(name, type));
        return this;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb0 = new StringBuilder();
        sb0
        .append(String.format("public class %s%s", this.className, this.nl))
        .append("{")
        .append(this.nl);
        for(Field f : this.fields){
            sb0.append(String.format("  public %s %s;%s", f.type, f.field, this.nl));
        }
        sb0.append("}");
        return sb0.toString();
    }
}

class Field {
    public String field;
    public String type;
    
    public Field(String field, String type){
        this.field = field;
        this.type = type;
    }
    
}