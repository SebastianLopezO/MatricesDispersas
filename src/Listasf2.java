import javax.swing.JOptionPane;
public class Listasf2
{
    private NodoF2 cab;
    public Listasf2(int nf, int nc)
    {
        cab=new NodoF2(nf,nc,0);
        cab.setLigafila(cab);
        cab.setLigacol(cab);
    }

    public NodoF2 getCab()
    {
        return cab;
    }
    //Metodo para mostrar
    public String mostrar()
    {
        NodoF2 p=cab.getLigafila();
        String salida="";
        while(p!=cab)
        {
            salida+=p.getFila()+"    "+p.getCol()+"    "+p.getDato()+"\n";
            p=p.getLigafila();
        }
        return salida;
    }
    //Metodo para mostrar la matriz con ceros
    public String mostrarv2()
    {

        NodoF2 p=cab.getLigafila();
        String salida="<html><h2>";
        for(int k=0;k<cab.getFila();k++)
        {
            for(int j=0;j<cab.getCol();j++)
            {
                if(p!=cab&&p.getFila()==k&&p.getCol()==j)
                {
                    salida+=p.getDato()+"<&nbsp;&nbsp;&nbsp;";
                    p=p.getLigafila();
                }
                else
                {
                    salida+="0.0<&nbsp;&nbsp;&nbsp;";
                }
            }
            salida+="<BR>";
        }
        salida=salida+"</h2></html>";
        return salida;

    }
    //Metodo para ingresar los datos de la matriz dispersa
    public void ingresarDatos()
    {
        int f, c;
        float d;
        NodoF2 p,antf, antc;
        String rpa;
        rpa=JOptionPane.showInputDialog("desea ingresar un dato? s/n");
        while(rpa.equals("s"))
        {
            f=Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila"));
            c=Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna"));
            d=Float.parseFloat(JOptionPane.showInputDialog("Ingrese dato"));
            if(f>=0&&f<cab.getFila()&&c>=0&&c<cab.getCol()&& d!=0)
            {
                p=cab.getLigafila();
                antf=cab;
                antc=cab;
                while(p!=cab&&p.getFila()<f)
                {
                    antf=p;
                    p=p.getLigafila();
                }

                while(p!=cab&&p.getFila()<=f&&p.getCol()<c)
                {
                    antf=p;
                    p=p.getLigafila();
                }

                p=cab.getLigacol();
                while(p!=cab&&p.getCol()<c)
                {
                    antc=p;
                    p=p.getLigacol();
                }

                while(p!=cab&&p.getCol()<=c&&p.getFila()<f)
                {
                    antc=p;
                    p=p.getLigacol();
                }
                if(p!=cab&&p.getFila()==f&&p.getCol()==c)
                {
                    JOptionPane.showMessageDialog(null,"Ya existe un dato en esa posicion");
                }
                else
                {
                    NodoF2 x=new NodoF2(f,c,d);
                    x.setLigafila(antf.getLigafila());
                    antf.setLigafila(x);
                    x.setLigacol(antc.getLigacol());
                    antc.setLigacol(x);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No es una posicion valida");
            }
            rpa=JOptionPane.showInputDialog("desea ingresar un dato? s/n");
        }
    }
    //Metodo para sumar un dato
    public void sumarDato(int f,int c, float d)
    {
        NodoF2 p=cab.getLigafila(),antf=cab, antc=cab;
        if(f>=0&&f<cab.getFila()&&c>=0&&c<cab.getCol()&& d!=0)
        {
            while(p!=cab&&p.getFila()<f)
            {
                antf=p;
                p=p.getLigafila();
            }

            while(p!=cab&&p.getFila()<=f&&p.getCol()<c)
            {
                antf=p;
                p=p.getLigafila();
            }

            p=cab.getLigacol();
            while(p!=cab&&p.getCol()<c)
            {
                antc=p;
                p=p.getLigacol();
            }

            while(p!=cab&&p.getCol()<=c&&p.getFila()<f)
            {
                antc=p;
                p=p.getLigacol();
            }
            if(p!=cab&&p.getFila()==f&&p.getCol()==c)
            {
                if(p.getDato()+d!=0)
                {
                    p.setDato(p.getDato()+d);
                }
                else
                {
                    antf.setLigafila(p.getLigafila());
                    antc.setLigacol(p.getLigacol());
                    //delete(p) aca se elimina el nodo
                }
            }
            else
            {
                NodoF2 x=new NodoF2(f,c,d);
                x.setLigafila(antf.getLigafila());
                antf.setLigafila(x);
                x.setLigacol(antc.getLigacol());
                antc.setLigacol(x);
            }
        }
    }

    public Listasf2 transpuesta(){
        NodoF2 p=cab.getLigacol();
        Listasf2 trans=new Listasf2(cab.getCol(),cab.getFila());
        do{
            trans.sumarDato(p.getCol(),p.getFila(), p.getDato());
            System.out.println(p.getCol()+" "+p.getFila()+" "+p.getDato());
            p=p.getLigacol();
        }while(p.getDato()!=0);
        return trans;
    }

    public Listasf2 sumar(Listasf2 resultado){

        NodoF2 p = cab.getLigafila();

        do{
            resultado.sumarDato(p.getFila(),p.getCol(), p.getDato());
            p = p.getLigafila();

        }while(p.getDato()!=0);

        return resultado;
    }

    public Listasf2 multiplicar(Listasf2 resultado){

        NodoF2 p = cab.getLigacol();
        NodoF2 q = resultado.getCab().getLigacol();
        Listasf2 r = new Listasf2(cab.getFila(),resultado.getCab().getCol());
        do
        {
            do
            {
                if(p.getCol()==q.getFila())
                {
                    r.sumarDato(p.getFila(), q.getCol(), p.getDato()*q.getDato());
                }
                p = p.getLigacol();
            }while(p.getDato()!=0);
            q = q.getLigacol();
        }while(q.getDato()!=0);

        return r;
    }

}
