package ClassesBasicas;

public abstract class Vem {
    private String codigo;
    private Pessoa usuario;
    private EmpresaVem empresa;
    private double saldo;
    private boolean ativo;
    //Para ser criado um vem é necessario passar um codigo, um usuario e uma empresa responsavel pela fabricação do vem
    public Vem(String codigo, Pessoa usuario, EmpresaVem empresa)
    {
        this.codigo = codigo;
        this.usuario = usuario;
        this.empresa = empresa;
        this.saldo = 0;
        this.ativo = true;
    }
    public String getCodigo()
    {
        return this.codigo;
    }
    public Pessoa getUsuario() {
        return this.usuario;
    }
    public EmpresaVem getEmpresa()
    {
        return this.empresa;
    }
    public double getSaldo()
    {
        return this.saldo;
    }
    //como as subclasses não vão poder acessar os atributos diretamente, botei um setSaldo para as subclasses
    //poderem modificar o saldo quando implementarem os metodos recarregar e pagar
    protected void setSaldo(double valor)
    {
        this.saldo = valor;
    }
    public boolean getAtivo()
    {
        return this.ativo;
    }
    public void bloquearVem()
    {
        this.ativo = false;
    }
    public void desbloquearVem()
    {
        this.ativo = true;
    }
    //Esses metodos podem ser imprementadoss de forma diferente nas subclasses
    public abstract void recarregar(double valor);
    public abstract void pagar();


}
