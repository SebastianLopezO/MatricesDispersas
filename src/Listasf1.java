import javax.swing.JOptionPane;
public class Listasf1
{
    private Nodo cab;
    //Método conastructor
    public Listasf1(int nf, int nc)
    {
        cab=crearCabezas(nf,nc);
    }
    //Métod para crear la lista de Nodos cabeza
    public Nodo crearCabezas(int nf, int nc)
    {
        Nodo p,x,ult;
        int n,k;
        n=nf>nc?nf:nc;
        p=new Nodo(nf,nc,0);
        p.setLigafila(p);
        p.setLigacol(p);
        ult=p;
        for(k=0;k<n;k++)
        {
            x=new Nodo(k,k,0);
            x.setLigafila(x);
            x.setLigacol(x);
            ult.setLiga(x);
            ult=x;
        }
        ult.setLiga(p);
        return p;
    }
    //Método para mostrar los datos
    public String mostrar()
    {
        String salida="";
        Nodo p=cab.getLiga(),q;
        while(p!=cab)
        {
            q=p.getLigafila();//Para mostrar por fila
            while(q!=p)
            {
                salida+=q.getFila()+"  "+q.getCol()+"   "+q.getDato()+"\n";
                q=q.getLigafila();
            }
            p=p.getLiga();
        }
        return salida;
    }
    //Método para mostrar con ceros
    public String mostrarv2()
    {
        String salida="<html><h2>";
        int f,c;
        Nodo p=cab.getLiga(),q;
        for(f=0; f<cab.getFila();f++)
        {
            q=p.getLigafila();
            for(c=0; c<cab.getCol();c++)
            {
                if(q!=p &&f==q.getFila()&&c==q.getCol())
                {
                    salida+=q.getDato()+"       ";
                    q=q.getLigafila();
                }
                else
                {
                    salida+="0.0     ";
                }
            }
            salida+="<BR>";
            p=p.getLiga();
        }
        salida=salida+"</h2></html>";
        return salida;
    }
    //Método para ingresar los datos de la matriz dispersa
    public void ingresarDatos()
    {
        int f,c;
        float d;
        String rpa;
        Nodo p,q,x,antf,antc;
        rpa=JOptionPane.showInputDialog("Desea ingresar un dato? S/N");
        while(rpa.equalsIgnoreCase("S"))
        {
            f=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila"));
            c=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna"));
            d=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el dato"));
            if(f>=0 && f<cab.getFila() && c >=0 && c<cab.getCol()&& d!=0)
            {
                p=cab.getLiga(); //para buscar el nodo cabeza de la lista de la fila
                while(p!=cab && p.getFila()<f)
                {
                    p=p.getLiga();
                }
                antf=p;
                q=p.getLigafila();
                while(q!=p && q.getCol()<c)
                {
                    antf=q;
                    q=q.getLigafila();
                }

                p=cab.getLiga(); //para buscar el nodo cabeza de la lista de la columna
                while(p!=cab && p.getCol()<c)
                {
                    p=p.getLiga();
                }
                antc=p;
                q=p.getLigacol();
                while(q!=p && q.getFila()<f)
                {
                    antc=q;
                    q=q.getLigacol();
                }
                if(q!=p && q.getFila()==f && q.getCol()==c)
                {
                    JOptionPane.showMessageDialog(null,"Ya hay un dato en esa posición");
                }
                else
                {
                    x=new Nodo(f,c,d);
                    x.setLigafila(antf.getLigafila());
                    antf.setLigafila(x);
                    x.setLigacol(antc.getLigacol());
                    antc.setLigacol(x);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Datos no válidos");
            }
            rpa=JOptionPane.showInputDialog("Desea ingresar un dato? S/N");
        }
    }

    //Método para sumar un dato a la matriz dispersa
    public void sumarDato(int f, int c, float d)
    {
        Nodo p,q,x,antf,antc;
        if(f>=0 && f<cab.getFila() && c >=0 && c<cab.getCol()&& d!=0)
        {
            p=cab.getLiga(); //para buscar el nodo cabeza de la lista de la fila
            while(p!=cab && p.getFila()<f)
            {
                p=p.getLiga();
            }
            antf=p;
            q=p.getLigafila();
            while(q!=p && q.getCol()<c)
            {
                antf=q;
                q=q.getLigafila();
            }

            p=cab.getLiga(); //para buscar el nodo cabeza de la lista de la columna
            while(p!=cab && p.getCol()<c)
            {
                p=p.getLiga();
            }
            antc=p;
            q=p.getLigacol();
            while(q!=p && q.getFila()<f)
            {
                antc=q;
                q=q.getLigacol();
            }
            if(q!=p && q.getFila()==f && q.getCol()==c)
            {
                if(q.getDato()+d!=0)
                {
                    q.setDato(q.getDato()+d);
                }
                else
                {
                    antf.setLigafila(q.getLigafila());
                    antc.setLigacol(q.getLigacol());
                    //delete(q) aqui se libera el nodo
                }
            }
            else
            {
                x=new Nodo(f,c,d);
                x.setLigafila(antf.getLigafila());
                antf.setLigafila(x);
                x.setLigacol(antc.getLigacol());
                antc.setLigacol(x);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Datos no válidos");
        }

    }

    public Listasf1 transpuesta(){
        Nodo q,p;
        p=cab.getLiga();

        Listasf1 trans=new Listasf1(cab.getCol(),cab.getFila());
        while(p != cab)
        {
            q=p.getLigacol();
            while(q !=p)
            {
                trans.sumarDato(q.getCol(),q.getFila(), q.getDato());
                System.out.println(q.getCol()+" "+q.getFila()+" "+q.getDato());
                q=q.getLigacol();
            }
            p=p.getLiga();
        }
        return trans;
    }

    public int getnf()
    {
        Nodo p;
        p=cab;
        p.getFila();
        return(p.getFila());
    }
    public int getnc()
    {
        Nodo p;
        p=cab;
        p.getCol();
        return(p.getCol());
    }

    public Listasf1 sumar(Listasf1 B)
    {

        Nodo p,q,j,h;
        p=cab.getLiga();
        int nf,nc;
        float m;
        nf= p.getFila();
        nc= p.getCol();
        Listasf1 R = new Listasf1(nf,nc);

        String salida="";

        j=B.cab.getLiga();
        while(p!=cab && j != B.cab)
        {
            q=p.getLigafila();
            h=j.getLigafila();
            while(q!=p && h != j)
            {
                if(q.getFila() == h.getFila() &&  q.getCol() == h.getCol())
                {
                    m=q.getDato()+ h.getDato();
                    salida=salida+m+" ";
                    q=q.getLigafila();
                    h=h.getLigafila();
                }
            }
            p=p.getLiga();
            j=j.getLiga();
        }
        JOptionPane.showMessageDialog(null,"Datos de la matriz Dispersa\n"+salida);
        return (R);
    }

    public Listasf1 multiplicar(Listasf1 aux)
    {

        Nodo p,q,j,h,x,z;
        p=cab.getLiga();
        int nf,nc;
        float m,aux2=0;
        nf= p.getFila();
        nc= p.getCol();
        Listasf1 R = new Listasf1(nf,nc);
        String salida="";
        j=aux.cab.getLiga();

        for(int elbicho=0; elbicho < cab.getCol();elbicho++)
        {
            q=p.getLigafila();
            h=j.getLigafila();
            z=h;
            for(int i=0; i < aux.cab.getFila();i++)
            {
                while(q != p && h != j)
                {
                    m=q.getDato()*h.getDato();
                    aux2=aux2+m;
                    q=q.getLigafila();
                    h=h.getLigacol();

                }
                z=z.getLigafila();
                q=q.getLigafila();
                h=z;
                salida=salida+aux2+" ";
                aux2=0;
            }
            p=p.getLiga();
            j=j.getLiga();
        }
        JOptionPane.showMessageDialog(null,"Datos de la matriz Dispersa\n"+salida);
        return (R);
    }
}
