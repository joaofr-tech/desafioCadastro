package cadastro;

public class Pet {
    public static final String enderecoNumeroNaoInformado = "NAO_INFORMADO";
    public String nome;
    public Tipo tipo;
    public Sexo sexo;
    public Endereco endereco = new Endereco();
    public Float idade;
    public Float peso;
    public String raca;

    public Pet(){
        this.endereco = new Endereco();
    }

    public enum Tipo{
        CACHORRO,
        GATO
    }

    public enum Sexo{
        MACHO,
        FEMEA
    }

    public class Endereco{
        public String rua;
        public String numeroDaCasa;
        public String cidade;
    }

}
