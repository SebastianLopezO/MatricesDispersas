import javax.swing.JOptionPane;
public class Tripletas
{
    private int nfilas;
    private int ncol;
    private int nt;
    private float listaTrip[][];
    //Método constructor
    public Tripletas(int nfilas, int ncol, int cd)
    {
        this.nfilas=nfilas;
        this.ncol=ncol;
        nt=cd+1;
        listaTrip=new float[nt][3];
        listaTrip[0][0]=nfilas;
        listaTrip[0][1]=ncol;
        listaTrip[0][2]=cd;
    }

    public int getNfilas() {
        return nfilas;
    }

    public int getNcol() {
        return ncol;
    }

    public int getNt() {
        return nt;
    }
    //Método para mostrar sin ceros
    public String mostrar()
    {
        String salida="";
        for(int k=1; k<listaTrip[0][2]+1;k++)
        {
            salida+=listaTrip[k][0]+"  "+listaTrip[k][1]+" "+listaTrip[k][2]+"\n";
        }
        return salida;
    }
    //Método para mostrar con ceros
    public String mostrarv2()
    {
        String salida="<html><h2>";
        int f,c,t=1;
        for(f=0; f<listaTrip[0][0];f++)
        {
            for(c=0; c<listaTrip[0][1];c++)
            {
                if(t<listaTrip[0][2]+1&&f==listaTrip[t][0]&& c==listaTrip[t][1])
                {
                    salida+=listaTrip[t][2]+"       ";
                    t++;
                }
                else
                {
                    salida+="0.0     ";
                }
            }
            salida+="<BR>";
        }
        salida=salida+"</h2></html>";
        return salida;
    }
    //Método para ingresar los datos
    public void ingresarDatos(int cd)
    {
        int cont,k,j,f,c;
        float d;
        for(cont=0;cont<cd;cont++)
        {
            f=Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila"));
            c=Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna"));
            d=Float.parseFloat(JOptionPane.showInputDialog("Ingrese dato"));
            if(f>=0 && f<nfilas && c>=0 && c<ncol&& d!=0)
            {
                k=1;
                //para encontar la posición de la fila
                while(k<listaTrip[0][2]+1 && listaTrip[k][0]<f&& listaTrip[k][2]!=0)
                {
                    k++;
                }
                //para encontar la posición de la columna
                while(k<listaTrip[0][2]+1 && listaTrip[k][0]<=f&& listaTrip[k][1]<c&& listaTrip[k][2]!=0)
                {
                    k++;
                }
                if(k<listaTrip[0][2]+1 && listaTrip[k][0]==f&& listaTrip[k][1]==c&& listaTrip[k][2]!=0)
                {
                    JOptionPane.showMessageDialog(null,"Ya hay un dato en esa posición");
                    cont--;
                }
                else
                {
                    for(j=(int)listaTrip[0][2];j>k;j--)
                    {
                        listaTrip[j][0]=listaTrip[j-1][0];
                        listaTrip[j][1]=listaTrip[j-1][1];
                        listaTrip[j][2]=listaTrip[j-1][2];
                    }
                    listaTrip[k][0]=f;
                    listaTrip[k][1]=c;
                    listaTrip[k][2]=d;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Datos no válidos");
                cont--;
            }

        }
    }
    //Método para sumar un dato a la matriz
    public void sumarDato(int f, int c, int d)
    {
        int k=1,j;
        if(f>=0 && f<nfilas && c>=0 && c<ncol&& d!=0)
        {
            //para encontar la posición de la fila
            while(k<listaTrip[0][2]+1 && listaTrip[k][0]<f&& listaTrip[k][2]!=0)
            {
                k++;
            }
            //para encontar la posición de la columna
            while(k<listaTrip[0][2]+1 && listaTrip[k][0]<=f&& listaTrip[k][1]<c&& listaTrip[k][2]!=0)
            {
                k++;
            }
            if(k<listaTrip[0][2]+1 && listaTrip[k][0]==f&& listaTrip[k][1]==c&& listaTrip[k][2]!=0)
            {
                if(listaTrip[k][2]+d!=0)
                {
                    listaTrip[k][2]+=d;
                }
                else
                {
                    for(j=k;j<listaTrip[0][2]-1;j++)
                    {
                        listaTrip[j][0]=listaTrip[j+1][0];
                        listaTrip[j][1]=listaTrip[j+1][1];
                        listaTrip[j][2]=listaTrip[j+1][2];
                    }
                    listaTrip[0][2]=listaTrip[0][2]-1;
                }
            }
            else
            {
                if(listaTrip[0][2]+1==nt)
                {
                    this.redimensionar();
                    for(j=(int)listaTrip[0][2]+1;j>k;j--)
                    {
                        listaTrip[j][0]=listaTrip[j-1][0];
                        listaTrip[j][1]=listaTrip[j-1][1];
                        listaTrip[j][2]=listaTrip[j-1][2];
                    }
                }
                else
                {
                    for(j=(int)listaTrip[0][2];j>k;j--)
                    {
                        listaTrip[j][0]=listaTrip[j-1][0];
                        listaTrip[j][1]=listaTrip[j-1][1];
                        listaTrip[j][2]=listaTrip[j-1][2];
                    }
                }
                listaTrip[k][0]=f;
                listaTrip[k][1]=c;
                listaTrip[k][2]=d;
                listaTrip[0][2]++;
            }
        }
    }
    //Método para redimensionar
    public void redimensionar()
    {
        nt=nt+1;
        float aux[][]=new float[nt][3];
        for(int k=0;k<listaTrip[0][2]+1;k++)
        {
            aux[k][0]=listaTrip[k][0];
            aux[k][1]=listaTrip[k][1];
            aux[k][2]=listaTrip[k][2];
        }
        //delete(listaTrip)aqui se libera la lista de tripletas
        listaTrip=aux;
    }

    public Tripletas traspuesta() {
        Tripletas trasp = new Tripletas(ncol, nfilas, (int) listaTrip[0][2]);
        for (int k = 1; k < listaTrip[0][2] + 1; k++) {
            trasp.sumarDato((int) listaTrip[k][1], (int) listaTrip[k][0], (int)listaTrip[k][2]);
        }
        return (trasp);
    }

    public Tripletas sumar(Tripletas mdt2) {

        if (nfilas == mdt2.getNfilas() && ncol == mdt2.getNcol()) {
            Tripletas resultado = new Tripletas(nfilas, ncol, (int) listaTrip[0][2] + (int) mdt2.listaTrip[0][2]);
            int i = 1, j = 1;
            while (i <= listaTrip[0][2]) {
                resultado.sumarDato((int) listaTrip[i][0], (int) listaTrip[i][1], (int) listaTrip[i][2]);
                i++;
            }

            while (j <= mdt2.listaTrip[0][2]) {
                resultado.sumarDato((int) mdt2.listaTrip[j][0], (int) mdt2.listaTrip[j][1], (int) mdt2.listaTrip[j][2]);
                j++;
            }
            return resultado;
        } else {
            JOptionPane.showMessageDialog(null, "\n No se ha podido sumar");
            return null;
        }
    }

    public Tripletas multiplicacion(Tripletas B)
    {
        int i = 1, j;
        Tripletas R;
        if (listaTrip[0][1] == B.listaTrip[0][0])
        {
            int mayor;
            if (B.listaTrip[0][2] > listaTrip[0][2])
            {
                mayor = (int)B.listaTrip[0][2];
            }
            else
            {
                mayor = (int) listaTrip[0][2];
            }
            R = new Tripletas((int)listaTrip[0][0],(int)B.listaTrip[0][1],mayor);
            while (i <= listaTrip[0][2])
            {
                j = 1;
                while ((j <= B.listaTrip[0][2]))
                {
                    if ((B.listaTrip[j][0] == listaTrip[i][1]))
                    {
                        R.sumarDato((int)listaTrip[i][0],(int)B.listaTrip[j][1],(int) (listaTrip[i][2]*B.listaTrip[j][2]));
                    }
                    j++;
                }
                i++;
            }
            return R;
        } else {
            System.out.println("No se pueden multiplicar las matrices");
            return new Tripletas(0,0,0);
        }
    }
}


