package cadastro;

public class Pet {
    public String nome;
    public Tipo tipo;
    public Sexo sexo;


    public enum Tipo{
        CACHORRO,
        GATO
    }

    public enum Sexo{
        MASCULINO,
        FEMININO
    }
}
