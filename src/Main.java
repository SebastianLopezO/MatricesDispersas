import javax.swing.JOptionPane;

public class Main
{
    public static void main(String[] args) throws InterruptedException {
        boolean App=true, Ope;
        int nf,nc,cd;
        String option,caso;
        while(App){
            option=Menu();
            Ope=true;
            switch(option){
                case "Tripleta":
                    Tripletas M1,M2,MS,tras;
                    nf=GetNum("Indique número de filas de la matriz 1: ");
                    nc=GetNum("Indique número de columnas de la matriz 1: ");
                    cd=GetNum("Cuántos datos tiene la matriz 1: ");
                    M1=new Tripletas(nf,nc,cd);
                    M1.ingresarDatos(cd);
                    JOptionPane.showMessageDialog(null,"Datos de la matriz\n"+M1.mostrar()+"\nMatriz con ceros\n"+M1.mostrarv2());

                    while(Ope)
                    {
                        caso=MenuOpe();
                        switch (caso){
                            case "Transpuesta":
                                tras=M1.traspuesta();
                                JOptionPane.showMessageDialog(null,"Datos de la matriz\n"+tras.mostrar()+"\nMatriz con ceros\n"+tras.mostrarv2());
                                break;
                            case "Sumar Matrices":
                                nf=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas de la matriz dispersa"));
                                nc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas de la matriz dispersa"));
                                cd=Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos diferentes de cero tiene la matriz dispersa"));
                                M2=new Tripletas(nf,nc,cd);
                                M2.ingresarDatos(cd);
                                MS=M1.sumar(M2);
                                JOptionPane.showMessageDialog(null,"Datos de la matriz\n"+MS.mostrar()+"\nMatriz con ceros\n"+MS.mostrarv2());

                                break;
                            case "Multiplicar Matrices":
                                nf=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas de la matriz dispersa"));
                                nc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas de la matriz dispersa"));
                                cd=Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos diferentes de cero tiene la matriz dispersa"));
                                M2=new Tripletas(nf,nc,cd);
                                M2.ingresarDatos(cd);
                                //mdt.mostrar();
                                MS=M1.multiplicacion(M2);
                                JOptionPane.showMessageDialog(null,"Datos de la matriz\n"+MS.mostrar()+"\nMatriz con ceros\n"+MS.mostrarv2());
                                break;
                            case "Volver":
                                System.out.println("Regresando...");
                                Thread.sleep(2000);
                                Ope=false;
                                break;
                        }
                    }
                    break;
                case "Fomar#1":
                    Listasf1 Mf1,trasF1,mdl1aux;;
                    nf=GetNum("Indique número de filas de la matriz 1: ");
                    nc=GetNum("Indique número de columnas de la matriz 1: ");

                    Mf1=new Listasf1(nf,nc);

                    Mf1.ingresarDatos();
                    JOptionPane.showMessageDialog(null,"Datos de la matriz\n"+Mf1.mostrar()+"\nDatos de la matriz incluyendo los ceros\n"+Mf1.mostrarv2());

                    while(Ope)
                    {
                        caso=MenuOpe();
                        switch (caso){
                            case "Transpuesta":
                                trasF1=Mf1.transpuesta();
                                JOptionPane.showMessageDialog(null,"Datos de la matriz\n"+trasF1.mostrar()+"\nDatos de la matriz incluyendo los ceros\n"+trasF1.mostrarv2());
                                break;
                            case "Sumar Matrices":
                                nf=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas de la matriz dispersa"));
                                nc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas de la matriz dispersa"));
                                mdl1aux=new Listasf1(nf, nc);
                                mdl1aux.ingresarDatos();
                                if(Mf1.getnf()==mdl1aux.getnf()&&Mf1.getnc()==mdl1aux.getnc())
                                {
                                    Mf1.sumar(mdl1aux);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"No se pueden sumar");
                                }
                                break;
                            case "Multiplicar Matrices":
                                nf=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas de la matrz dispersa"));
                                nc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas de la matrz dispersa"));
                                mdl1aux=new Listasf1(nf, nc);
                                mdl1aux.ingresarDatos();
                                if(Mf1.getnc() == mdl1aux.getnf())
                                {
                                    Mf1.multiplicar(mdl1aux);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"No se pueden multiplicar");
                                }
                                break;
                            case "Volver":
                                System.out.println("Regresando...");
                                Thread.sleep(2000);
                                Ope=false;
                                break;
                        }
                        break;
                    }
                    break;
                case "Fomar#2":

                    Listasf2 Mf2,trasF2,Mf2aux;
                    nf=GetNum("Indique número de filas de la matriz 1: ");
                    nc=GetNum("Indique número de columnas de la matriz 1: ");

                    Mf2=new Listasf2(nf,nc);

                    Mf2.ingresarDatos();
                    JOptionPane.showMessageDialog(null,"Datos de la matriz\n"+Mf2.mostrar()+"\nDatos de la matriz incluyendo los ceros\n"+Mf2.mostrarv2());


                    while(Ope)
                    {
                        caso=MenuOpe();
                        switch (caso){
                            case "Transpuesta":
                                trasF2=Mf2.transpuesta();
                                JOptionPane.showMessageDialog(null,"Datos de la matriz\n"+trasF2.mostrar()+"\nDatos de la matriz incluyendo los ceros\n"+trasF2.mostrarv2());
                                break;
                            case "Sumar Matrices":
                                nf=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas de la matriz dispersa"));
                                nc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas de la matriz dispersa"));
                                Mf2aux=new Listasf2(nf, nc);
                                Mf2aux.ingresarDatos();
                                JOptionPane.showMessageDialog(null,"Datos de la matriz\n"+Mf2aux.mostrar()+"\nDatos de la matriz incluyendo los ceros\n"+Mf2aux.mostrarv2());

                                Listasf2 maux=Mf2.sumar(Mf2aux);
                                JOptionPane.showMessageDialog(null,"Datos de la matriz\n"+maux.mostrar()+"\nDatos de la matriz incluyendo los ceros\n"+maux.mostrarv2());
                                break;
                            case "Multiplicar Matrices":
                                nf=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas de la matrz dispersa"));
                                nc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas de la matrz dispersa"));
                                Mf2aux=new Listasf2(nf, nc);
                                Listasf2 muulti;
                                Mf2aux.ingresarDatos();
                                Mf2aux.mostrarv2();
                                muulti=Mf2.multiplicar(Mf2aux);
                                JOptionPane.showMessageDialog(null,"Datos de la matriz\n"+muulti.mostrar()+"\nDatos de la matriz incluyendo los ceros\n"+muulti.mostrarv2());
                                break;
                            case "Volver":
                                System.out.println("Regresando...");
                                Thread.sleep(2000);
                                Ope=false;
                                break;
                        }
                    }
                    break;

                case "Salir":
                    System.out.println("Saliendo...");
                    Thread.sleep(2000);
                    App=false;
                    break;
            }


        }

    }

    public static String Menu() {
        String[] Options = {
                "Tripleta",
                "Forma#1",
                "Fomar#2",
                "Salir"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la Opcion: ",
                "Matrices Dispersas",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String MenuOpe() {
        String[] Options = {
                "Transpuesta",
                "Sumar Matrices",
                "Multiplicar Matrices",
                "Volver"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la Opcion: ",
                "Menu Operaciones",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static int GetNum(String Option) {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog(Option));
                return num;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "No se ha insertado un numero.");
                System.out.println("No ha insertado un numero, error" + ex);
            }
        }
    }

}
