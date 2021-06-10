package src.tamagotchi;


/**
 Classe que instancia os objetos do tipo tamagotchi
 */
public class Tamagotchi
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome;
    private int idade = 0;
    private int peso = 1;
    private int acordado =0;
    private boolean vivo = true;
    
    public boolean getVivo()
    {
        return vivo;
    }

    public Tamagotchi(String n)
    {
        // inicializa variáveis de instância
        nome = n;
        System.out.println("Tamagotchi criado!!!!!");
    }
    
    public void linha()
    {
        System.out.println("=====================================================");
    }
    
    public void mostraStatus()
    {
        linha();
        System.out.println("STATUS DO TAMAGOTCHI");
        System.out.println("Idade: "+idade+" dias.");
        System.out.println("Peso: "+peso+" Kg.");
        linha();
    }
    
    public boolean sentirSono()
    {
        System.out.println("O seu Tamagotchi esta com sono, o que deseja fazer ?");
        System.out.println("1) Dormir");
        System.out.println("2) Permanecer acordado");
        Teclado t = new Teclado();
        switch(t.leInt()){
        case 1:
            {
                dormir();
                break;
            }
        case 2:
            {
                ficaAcordado();
                break;
            } 
        default:
            {
                System.out.println("Voce digitou uma opcao invalida");
            }
        
        }
        return vivo;
    }
    
    public boolean sentirFome()
    {
        System.out.println("O seu Tamagotchi esta com fome, o que deseja fazer ?");
        System.out.println("1) Comer Muito!");
        System.out.println("2) Comer Pouco!");
        System.out.println("3) Nao Comer!");
        Teclado t = new Teclado();
        switch(t.leInt()){
        case 1:
            {
                comerMuito();
                break;
            }
        case 2:
            {
                comerPouco();
                break;
            }
        case 3:
            {
                naoComer();
                break;
            }    
        default:
            {
                System.out.println("Voce digitou uma opcao invalida");
            }
        
        }
        return vivo;
    }
    
     public boolean sentirTedio()
    {
        System.out.println("O seu Tamagotchi esta entediado, o que deseja fazer ?");
        System.out.println("1) Correr 10 minutos");
        System.out.println("2) Caminhar 10 minutos");
        Teclado t = new Teclado();
        switch(t.leInt()){
        case 1:
            {
                correr10();
                break;
            }
        case 2:
            {
                caminhar10();
                break;
            }
        default:
            {
                System.out.println("Voce digitou uma opcao invalida");
            }
        
        }
        return vivo;
    }
    
    
    public void dormir()
    {
        acordado = 0;
        idade++;
        if (idade >= 15)
        {
            morreu();
        }
        else
        {
            mostraStatus();
        }
    }
    
    public void morreu()
    {
        System.out.println("R.I.P Tamagotchi!");
        vivo = false;
    }
    
    public void explodiu()
    {
        System.out.println("KABUM!!!");
        System.out.println("R.I.P Tamagotchi!");
        vivo = false;
    }
    
    public void desnutriu()
    {
        System.out.println("No ceu tem pao?");
        System.out.println("E morreu!!");
        vivo = false;
    }
    
    public void ficaAcordado()
    {
        acordado++;
        if(acordado>=5)
        {
            dormir();
        } 
        else
        {
            System.out.println("Tamagotchi ficou acordado");
            mostraStatus();
        }
    }
            
    public void comerMuito()
    {
        peso = peso + 5;
        if(peso >= 20)
        {
            explodiu();
        } else
        {
            dormir();
        }
    }
    
    public void comerPouco()
    {
        peso++;
        if(peso >= 20)
        {
            explodiu();
        } else
        {
            mostraStatus();
        }
    }
    
    public void naoComer()
    {
        peso = peso - 2;
        if(peso <= 0)
        {
            desnutriu();
        } else
        {
            mostraStatus();
        }
    }
    
    public void correr10()
    {
        peso = peso - 4;
        if(peso <= 0)
        {
            desnutriu();
        } else
        {
            System.out.println("Apos a corrida, "+nome+" comeu muito!!");
            comerMuito();
        }
    }
    
    public void caminhar10()
    {
        peso = peso - 1;
        if(peso <= 0)
        {
            desnutriu();
        } else
        {
            mostraStatus();
            System.out.println("Apos a corrida, "+nome+" vai sentir fome!!");
            sentirFome();
        }
    }
}
