import src.tamagotchi.*;
    public class Principal
    {
        
    public static int getRandomNumber(int min, int max) 
    {
        return (int) ((Math.random() * (max - min)) + min);
    }
    
    
    public static void main(String[] args)
    {
        // inicializa variáveis de instância
        Teclado t = new Teclado();
        System.out.println("Seja bem vindo ao emulador de Tamagotchi");
        System.out.println("Vamos cadastrar o seu Tamagotchi");
        Tamagotchi pet = new Tamagotchi(t.leString("Digite o nome do seu pet"));
        
        while(pet.getVivo())
        {
            int desejo = getRandomNumber(1,4);
            switch(desejo)
            {
                case 1:
                    {
                        pet.sentirSono();
                        break;
                    }
                case 2: 
                    {
                        pet.sentirFome();
                        break;
                    }
                case 3: 
                    {
                        pet.sentirTedio();
                        break;
                    }
                default: 
                    System.out.println("OPCAO INVALIDA!!!");
            }
        }
       
    }
}
